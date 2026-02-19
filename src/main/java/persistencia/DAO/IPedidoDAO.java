/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAO;

import java.util.List;
import persistencia.dominio.Pedido;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Benjamin
 */
public interface IPedidoDAO {
    void crearPedidoProgramado(Pedido pedido) throws PersistenciaException;
    
    Pedido consultarPedidoPorTelefono(int telefono) throws PersistenciaException;
    
    List<Pedido> buscarPedidosActivosPorCliente(int telefono) throws PersistenciaException;
    
    
}
