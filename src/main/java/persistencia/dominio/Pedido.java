/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Benjamin
 */
public class Pedido {
    private int idPedido;
    private EstadoPedido estado;
    private String notasEntrega;
    private LocalDateTime fecha;
    private LocalDateTime fechaEntrega;
    private double total;

    protected List<DetallesPedido> detalles;
    
    public Pedido(){
        this.detalles = new ArrayList<>();
    }

    public Pedido(int idPedido, EstadoPedido estado, String notasEntrega, LocalDateTime fecha, LocalDateTime fechaEntrega, double total, List<DetallesPedido> detalles) {
        this.idPedido = idPedido;
        this.estado = estado; 
        this.notasEntrega = notasEntrega;
        this.fecha = fecha;
        this.fechaEntrega = fechaEntrega;
        this.total = total;
        
        this.detalles = detalles;
    }

    public List<DetallesPedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallesPedido> detalles) {
        this.detalles = detalles;
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
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
