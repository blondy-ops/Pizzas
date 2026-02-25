/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

import java.util.List;

/**
 *
 * @author jorge
 */
public class PedidoCompletoDTO {

    private PedidoDTO pedido;
    private List<CarritoDTO> carrito;
    private Integer idCupon;

    public PedidoCompletoDTO() {
    }

    public PedidoCompletoDTO(PedidoDTO pedido, List<CarritoDTO> carrito, Integer idCupon) {
        this.pedido = pedido;
        this.carrito = carrito;
        this.idCupon = idCupon;
    }

    public PedidoDTO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDTO pedido) {
        this.pedido = pedido;
    }

    public List<CarritoDTO> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<CarritoDTO> carrito) {
        this.carrito = carrito;
    }

    public Integer getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(Integer idCupon) {
        this.idCupon = idCupon;
    }

    @Override
    public String toString() {
        return "PedidoCompletoDTO{" + "pedido=" + pedido + ", carrito=" + carrito + ", idCupon=" + idCupon + '}';
    }
    
}
