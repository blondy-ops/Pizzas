/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

import java.time.LocalDate;

/**
 *
 * @author Benjamin
 */
public class PedidoProgramado extends Pedido{
    private int idCupon;

    public PedidoProgramado(int idCupon, int idPedido, EstadoPedido estado, String notasEntrega, LocalDate fecha, LocalDate fechaEntrega, double total) {
        super(idPedido, estado, notasEntrega, fecha, fechaEntrega, total);
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
