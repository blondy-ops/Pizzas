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

    public PedidoDTO() {
    }

    public PedidoDTO(Integer idUsuario, double total, String notasEntrega) {
        this.idUsuario = idUsuario;
        this.total = total;
        this.notasEntrega = notasEntrega;
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

    @Override
    public String toString() {
        return "PedidoDTO{" + "idUsuario=" + idUsuario + ", total=" + total + ", notasEntrega=" + notasEntrega + '}';
    }

}
