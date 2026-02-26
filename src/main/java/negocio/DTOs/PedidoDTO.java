/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

import java.time.LocalDateTime;

/**
 *
 * @author jorge
 */
public class PedidoDTO {
    private int idPedido;
    private Integer idUsuario;
    private String estado;
    private LocalDateTime fecha;
    private LocalDateTime fechaListo;
    private LocalDateTime fechaEntrega;
    private double total;
    private String notasEntrega;

    public PedidoDTO() {
    }

    public PedidoDTO(int idPedido, Integer idUsuario, String estado, LocalDateTime fecha, LocalDateTime fechaListo, LocalDateTime fechaEntrega, double total, String notasEntrega) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.estado = estado;
        this.fecha = fecha;
        this.fechaListo = fechaListo;
        this.fechaEntrega = fechaEntrega;
        this.total = total;
        this.notasEntrega = notasEntrega;
    }
   
    
    //DTO para ventana de modificacion de estado de pedidos por empleados
    public PedidoDTO(int idPedido, Integer idUsuario, String estado, LocalDateTime fecha, double total){
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.estado = estado;
        this.fecha = fecha;
        this.total = total;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public LocalDateTime getFechaListo() {
        return fechaListo;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public double getTotal() {
        return total;
    }

    public String getNotasEntrega() {
        return notasEntrega;
    }

    @Override
    public String toString() {
        return "PedidoDTO{" + "idPedido=" + idPedido + ", idUsuario=" + idUsuario + ", estado=" + estado + ", fecha=" + fecha + ", fechaListo=" + fechaListo + ", fechaEntrega=" + fechaEntrega + ", total=" + total + ", notasEntrega=" + notasEntrega + '}';
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setFechaListo(LocalDateTime fechaListo) {
        this.fechaListo = fechaListo;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setNotasEntrega(String notasEntrega) {
        this.notasEntrega = notasEntrega;
    }

    
    
}
