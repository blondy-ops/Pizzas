/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.DTOs.CarritoDTO;
import negocio.DTOs.PedidoCompletoDTO;
import negocio.DTOs.PedidoDTO;
import negocio.DTOs.PedidoExpressDTO;
import negocio.excepciones.NegocioException;
import persistencia.Conexion.ConexionBD;
import persistencia.DAO.IPedidoDAO;
import persistencia.DAO.PedidoDAO;
import persistencia.DAO.UsuarioDAO;
import persistencia.dominio.DetallesPedido;
import persistencia.dominio.EstadoPedido;
import persistencia.dominio.Pedido;
import persistencia.dominio.PedidoExpress;
import persistencia.dominio.PedidoProgramado;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author jorge
 */
public class PedidoBO implements IPedidoBO {

    private IPedidoDAO pedidoDAO;

    public PedidoBO(ConexionBD conexion) {
        this.pedidoDAO = new PedidoDAO(conexion);
    }

    @Override
    public PedidoDTO obtenerPedidoPorId(int idPedido) throws NegocioException {
        try {
            Pedido pedidoBD = pedidoDAO.obtenerPedidoPorId(idPedido);

            if (pedidoBD == null) {
                return null;
            }

            // Empaquetamos la información en el DTO
            PedidoDTO dto = new PedidoDTO();
            dto.setIdPedido(pedidoBD.getIdPedido());
            dto.setIdUsuario(pedidoBD.getIdUsuario());

            if (pedidoBD.getEstado() != null) {
                dto.setEstado(pedidoBD.getEstado().name()); // Lo convertimos a String
            }

            dto.setFecha(pedidoBD.getFecha());
            dto.setTotal(pedidoBD.getTotal());

            return dto;

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar la información del pedido.", ex);
        }
    }

    @Override
    public void actualizarEstado(int idPedido, String nuevoEstado) throws NegocioException {
        try {
            // Le pedimos al DAO que haga el UPDATE
            pedidoDAO.actualizarEstado(idPedido, nuevoEstado);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo actualizar el estado del pedido en el sistema.", ex);
        }
    }

    @Override
    public List<PedidoDTO> obtenerPedidosOrdenadosPorFecha() throws NegocioException {
        try {
            //1. se pide las entidades puras al DAO
            List<Pedido> pedidosBD = pedidoDAO.obtenerPedidosOrdenadosPorFecha();

            //2. se prepara la lista de mensajeros (DTOs)
            List<PedidoDTO> pedidosDTO = new ArrayList<>();

            //3. transformamos cada pedido en un dto 
            for (Pedido p : pedidosBD) {
                PedidoDTO dto = new PedidoDTO();

                dto.setIdPedido(p.getIdPedido());
                dto.setIdUsuario(p.getIdUsuario());

                if (p.getEstado() != null) {
                    dto.setEstado(p.getEstado().name());
                }

                dto.setFecha(p.getFecha());
                dto.setTotal(p.getTotal());

                //se agrega el dto a la lista
                pedidosDTO.add(dto);
            }

            //4. se devuelve la lista limpia a la ventana para que la muestre
            return pedidosDTO;
        } catch (PersistenciaException ex) {
            //si la base de datos falla, se lanza la e
            throw new NegocioException("No se pudieron recuperar los pedidos", ex);
        }
    }

    @Override
    public int crearPedido(PedidoCompletoDTO pedidoCompleto) throws NegocioException {
        if (pedidoCompleto == null) {
            throw new NegocioException("Error: El pedido esta vacio");
        }

        if (pedidoCompleto.getCarrito() == null || pedidoCompleto.getCarrito().isEmpty()) {
            throw new NegocioException("Error: El carrito esta vacio");
        }

        PedidoDTO pedidoDTO = pedidoCompleto.getPedido();
        String notaGeneral = pedidoDTO.getNotasEntrega();

        try {
            if (pedidoDTO.getIdUsuario() != null) {
                int pedidosActivos = pedidoDAO.contarPedidosActivosPorCliente(pedidoDTO.getIdUsuario());

                if (pedidosActivos >= 3) {
                    throw new NegocioException(
                            "Error: Tiene 3 pedidos activos");
                }
            }

            Pedido pedido = new Pedido();
            pedido.setIdUsuario(pedidoDTO.getIdUsuario());
            pedido.setEstado(EstadoPedido.pendiente);
            pedido.setFecha(LocalDateTime.now());
            pedido.setNotasEntrega(notaGeneral);
            pedido.setTotal(pedidoDTO.getTotal());

            int idGenerado = pedidoDAO.CrearPedido(pedido);

            for (CarritoDTO x : pedidoCompleto.getCarrito()) {
                DetallesPedido detalle = new DetallesPedido();
                detalle.setIdPedido(idGenerado);
                detalle.setIdPizza(x.getIdPizza());
                detalle.setCantidad(x.getCantidad());
                detalle.setNotasPreparacion(x.getNotaIndividual());
                detalle.setPrecioUnitario(x.getPrecioUnitario());
                pedidoDAO.agregarDetallePedido(detalle);
            }
            return idGenerado;

        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo contar los pedidos activos por cliente.");
        }
    }

    @Override
    public PedidoExpressDTO crearPedidoExpress(PedidoCompletoDTO pedidoCompleto) throws NegocioException {
        if (pedidoCompleto == null) {
            throw new NegocioException("El pedido esta vacio");
        }

        if (pedidoCompleto.getCarrito() == null || pedidoCompleto.getCarrito().isEmpty()) {
            throw new NegocioException("El carrito esta vacio");
        }

        try {
            int idGenerado = crearPedido(pedidoCompleto);

            String pinInicial = generarPin();
            String pinHash = hashPin(pinInicial);

            String folio = "EXP-" + idGenerado;

            PedidoExpress pe = new PedidoExpress();
            pe.setIdPedido(idGenerado);
            pe.setPin(pinHash);
            pe.setFolio(folio);

            pedidoDAO.agregarPedidoExpres(pe);
            return new PedidoExpressDTO(idGenerado, pinInicial, folio);

        } catch (PersistenciaException e) {
            throw new NegocioException("Error: error al crear el pedido express");
        }
    }

    @Override
    public int CrearPedidoProgramado(PedidoCompletoDTO pedidoCompleto) throws NegocioException {
        if (pedidoCompleto == null) {
            throw new NegocioException("El pedido esta vacio");
        }
        if (pedidoCompleto.getCarrito() == null || pedidoCompleto.getCarrito().isEmpty()) {
            throw new NegocioException("El carrito esta vacio");
        }
        try {
            int idGenerado = crearPedido(pedidoCompleto);
            PedidoProgramado pp = new PedidoProgramado(idGenerado, pedidoCompleto.getIdCupon());
            pedidoDAO.agregarPedidoProgramado(pp);
            return idGenerado;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error: error al ccrear el pedido programado");
        }
    }

    @Override
    public boolean validarPin(String folio, String pinIngresado) throws NegocioException {
        //valido que el folio no este vacio 
        if (folio == null || folio.isBlank()) {
            throw new NegocioException("Error: Folio vacío");
        }
        //valido que el pin no estte vacio 
        if (pinIngresado == null || pinIngresado.isBlank()) {
            throw new NegocioException("Error: PIN vacío");
        }

        try {
            //buscamos el pedido en la base de datos 
            PedidoExpress express = pedidoDAO.obtenerExpressPorFolio(folio);
            //si validamos que el pedido no este vecio, si esta vacio quiere decir que el folio es invalido 
            if (express == null) {
                throw new NegocioException("Error: No existe el folio");
            }
            //hasheamos el pin
            String hashIngresado = hashPin(pinIngresado);
            //comparo el pin hasheado con los de la base de datos 
            return hashIngresado.equals(express.getPin());

        } catch (PersistenciaException e) {
            throw new NegocioException("Error: error al validar pin", e);
        }
    }

    private String hashPin(String pin) throws NegocioException {
        try {
            //uso el algoridmo SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //convierto el pin a bytes
            byte[] hashBytes = digest.digest(pin.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            //combierto bytes a texto hexadecimal 
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new NegocioException("Error al hashear PIN", e);
        }
    }

    private String generarPin() {
        SecureRandom random = new SecureRandom();
        int pin = 1000 + random.nextInt(9000);
        return String.valueOf(pin);
    }

    @Override
    public int contarPedidosActivos(int idUsuario) throws NegocioException {
        if (idUsuario <= 0) {
            throw new NegocioException("Id de usuario inválido");
        }
        try {
            return pedidoDAO.contarPedidosActivosPorCliente(idUsuario);
        } catch (PersistenciaException e) {

            throw new NegocioException(
                    "Error al contar pedidos activos", e);
        }
    }

}
