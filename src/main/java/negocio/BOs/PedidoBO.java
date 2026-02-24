/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import negocio.DTOs.UsuarioDTO;
import negocio.excepciones.NegocioException;
import persistencia.DAO.IPedidoDAO;
import persistencia.dominio.Pedido;
import persistencia.dominio.PedidoExpress;
import persistencia.dominio.PedidoProgramado;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Benjamin
 */
public class PedidoBO implements IPedidoBO{
    
    //1. se declara la herramienta (la dependencia)
    private final IPedidoDAO pedidoDAO;
    
    //2. pedimos la herramienta en el constructor (inyeccion de dependencias)
    public PedidoBO(IPedidoDAO pedidoDAO){
        this.pedidoDAO = pedidoDAO;
    }
    
    //private final IPedidoProgramadoDAO pedidoProgramadoDAO;
    /*
    @Override
    public void procesarCompra(ICarritoBO carrito, UsuarioDTO usuario) throws NegocioException {
        try {
            // 1. Armamos el pedido general
            Pedido pedidoGeneral = new Pedido();
            pedidoGeneral.setNotasEntrega(carrito.getNotaGeneral());
            pedidoGeneral.setTotal(carrito.calcularTotal());

            // Si hay usuario, le asignamos su ID al pedido general
            if (usuario != null) {
                pedidoGeneral.setIdUsuario(usuario.getIdUsuario());
            }

            // 2. Le pedimos al DAO que lo guarde y nos devuelva el ID generado
            int idPedidoGenerado = pedidoDAO.insertarPedido(pedidoGeneral);
            
            // --- AQUÍ SEGUIREMOS CON LA LÓGICA DE PROGRAMADO / EXPRESS ---

            if (usuario != null) {
                // --- ES UN PEDIDO PROGRAMADO ---
                PedidoProgramado programado = new PedidoProgramado();
                programado.setIdPedido(idPedidoGenerado); // El ID mágico que nos dio el DAO principal
                programado.setIdCupon(carrito.getIdCuponAplicado()); // Puede traer el ID o null
                
                pedidoProgramadoDAO.insertar(programado);
                
            } else {
                // --- ES UN PEDIDO EXPRESS ---
                PedidoExpress express = new PedidoExpress();
                express.setIdPedido(idPedidoGenerado);
                
                // ¡ALERTA! Según tu base de datos, necesitamos dos cosas más:
                // express.setFolio(...);
                // express.setPin(...);
                
                pedidoExpressDAO.insertar(express);
            }
            
        } catch (PersistenciaException ex) {
            // Atrapamos el error de BD y lo convertimos en error de negocio
            throw new NegocioException("Error al registrar el pedido en el sistema.", ex);
        }
    }
    */
    
}
