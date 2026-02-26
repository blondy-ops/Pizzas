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

}
