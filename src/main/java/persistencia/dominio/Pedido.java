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
public class Pedido {
    private int idPedido;
    private EstadoPedido estado;
    private String notasEntrega;
    private LocalDate fecha;
    private LocalDate fechaEntrega;
    private double total;

    
    public Pedido(){
        
    }

    public Pedido(int idPedido, EstadoPedido estado, String notasEntrega, LocalDate fecha, LocalDate fechaEntrega, double total) {
        this.idPedido = idPedido;
        this.estado = estado;
        this.notasEntrega = notasEntrega;
        this.fecha = fecha;
        this.fechaEntrega = fechaEntrega;
        this.total = total;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public String getNotasEntrega() {
        return notasEntrega;
    }

    public void setNotasEntrega(String notasEntrega) {
        this.notasEntrega = notasEntrega;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", estado=" + estado + ", notasEntrega=" + notasEntrega + ", fecha=" + fecha + ", fechaEntrega=" + fechaEntrega + ", total=" + total + '}';
    }
    
    
}
