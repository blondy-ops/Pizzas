/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.BOs;

import java.util.List;
import negocio.DTOs.PedidoCompletoDTO;
import negocio.DTOs.PedidoDTO;
import negocio.DTOs.PedidoExpressDTO;
import negocio.excepciones.NegocioException;
import persistencia.dominio.Pedido;

/**
 *
 * @author jorge
 */
public interface IPedidoBO {
    
    public int crearPedido(PedidoCompletoDTO pedidoCompleto) throws NegocioException;
    
    public PedidoExpressDTO crearPedidoExpress(PedidoCompletoDTO pedidoCompleto) throws NegocioException;
    
    public int CrearPedidoProgramado(PedidoCompletoDTO pedidoCompleto) throws NegocioException;
    
    public int contarPedidosActivos(int idUsuario) throws NegocioException;
    
    boolean validarPin(String folio, String pinIngresado) throws NegocioException;
    
    //para la ventana de gestion de pedidos
    public List<PedidoDTO> obtenerPedidosOrdenadosPorFecha() throws NegocioException;
    
    public void actualizarEstado(int idPedido, String nuevoEstado) throws NegocioException;
    
    public PedidoDTO obtenerPedidoPorId(int idPedido) throws NegocioException;

    
}
