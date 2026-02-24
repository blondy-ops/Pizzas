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
    private Integer idCupon;
    
    public PedidoProgramado(){
        
    }
    
    public PedidoProgramado(Integer idCupon, int idPedido, Integer idUsuario, EstadoPedido estado, String notasEntrega, LocalDateTime fecha, LocalDateTime fechaEntrega, double total, List<DetallesPedido> detalles) {
        super(idPedido, idUsuario, estado, notasEntrega, fecha, fechaEntrega, total, detalles);
        this.idCupon = idCupon;
    }

    

    public List<DetallesPedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallesPedido> detalles) {
        this.detalles = detalles;
    }

    public Integer getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(Integer idCupon) {
        this.idCupon = idCupon;
    }
    
    
    
    
    
    @Override
    public String toString() {
        return "PedidoProgramado{" + "idCupon=" + idCupon + '}';
    }
    
    
}
