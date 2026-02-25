/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

/**
 *
 * @author jorge
 */
public class PedidoProgramadoDTO {
    private int idPedido;
    private Integer idCupon;

    public PedidoProgramadoDTO() {
    }

    public PedidoProgramadoDTO(int idPedido, Integer idCupon) {
        this.idPedido = idPedido;
        this.idCupon = idCupon;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public Integer getIdCupon() {
        return idCupon;
    }

    @Override
    public String toString() {
        return "PedidoProgramadoDTO{" + "idPedido=" + idPedido + ", idCupon=" + idCupon + '}';
    }
    
}