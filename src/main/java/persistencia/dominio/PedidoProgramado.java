/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Benjamin
 */
public class PedidoProgramado extends Pedido{
    private int idCupon;

    public PedidoProgramado(){
        
    }
    
    public PedidoProgramado(int idPedido, EstadoPedido estado, String notasEntrega, LocalDateTime fecha, LocalDateTime fechaEntrega, double total, int idCupon, List<DetallesPedido> detalles) {
        super(idPedido, estado, notasEntrega, fecha, fechaEntrega, total, detalles);
        this.idCupon = idCupon;
      
    }

    public int getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(int idCupon) {
        this.idCupon = idCupon;
    }
    
    @Override
    public String toString() {
        return "PedidoProgramado{" + "idCupon=" + idCupon + '}';
    }

    
    
    
}
