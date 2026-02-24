/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAO;

import java.util.List;
import persistencia.dominio.DetallesPedido;
import persistencia.dominio.Pedido;
import persistencia.dominio.PedidoProgramado;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Benjamin
 */
public interface IPedidoDAO {
    //void crearPedido(Pedido pedido) throws PersistenciaException;
    
    //Pedido consultarPedidoPorTelefono(int telefono) throws PersistenciaException;
    
    //List<Pedido> buscarPedidosActivosPorCliente(int telefono) throws PersistenciaException;
    
    public int contarPedidosActivosPorCliente(int idUsuario) throws PersistenciaException;
    
    public int insertarPedido(Pedido pedido) throws PersistenciaException;
    
    public void agregarDetallePedido(DetallesPedido detallePedido) throws PersistenciaException;
    
    public void agregarPedidoProgramado(PedidoProgramado pedidoProgramado) throws PersistenciaException;
}
