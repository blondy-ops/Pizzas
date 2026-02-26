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

    private Integer idUsuario;
    private double total;
    private String notasEntrega;
    private int idPedido;
    private String estado;
    private LocalDateTime fecha;

    public PedidoDTO() {
    }

    public PedidoDTO(Integer idUsuario, double total, String notasEntrega) {
        this.idUsuario = idUsuario;
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

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNotasEntrega() {
        return notasEntrega;
    }

    public void setNotasEntrega(String notasEntrega) {
        this.notasEntrega = notasEntrega;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "PedidoDTO{" + "idUsuario=" + idUsuario + ", total=" + total + ", notasEntrega=" + notasEntrega + ", idPedido=" + idPedido + ", estado=" + estado + ", fecha=" + fecha + '}';
    }
    
}
