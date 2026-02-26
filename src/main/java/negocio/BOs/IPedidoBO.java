/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.BOs;

import negocio.DTOs.PedidoCompletoDTO;
import negocio.DTOs.PedidoExpressDTO;
import negocio.excepciones.NegocioException;

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
    
}
