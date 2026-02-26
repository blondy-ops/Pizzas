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
    private Integer idUsuario;
    private EstadoPedido estado;
    private String notasEntrega;
    private LocalDateTime fecha;
    private LocalDateTime fechaListo; 
    private LocalDateTime fechaEntrega;
    private double total;

    public Pedido() {
    }

    public Pedido(int idPedido, Integer idUsuario, EstadoPedido estado, String notasEntrega, LocalDateTime fecha, LocalDateTime fechaListo, LocalDateTime fechaEntrega, double total) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.estado = estado;
        this.notasEntrega = notasEntrega;
        this.fecha = fecha;
        this.fechaListo = fechaListo;
        this.fechaEntrega = fechaEntrega;
        this.total = total;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public LocalDateTime getFechaListo() {
        return fechaListo;
    }

    public void setFechaListo(LocalDateTime fechaListo) {
        this.fechaListo = fechaListo;
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
        return "Pedido{" + "idPedido=" + idPedido + ", idUsuario=" + idUsuario + ", estado=" + estado + ", notasEntrega=" + notasEntrega + ", fecha=" + fecha + ", fechaListo=" + fechaListo + ", fechaEntrega=" + fechaEntrega + ", total=" + total + '}';
    }
    
}
