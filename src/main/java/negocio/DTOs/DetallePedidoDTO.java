/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

/**
 *
 * @author jorge
 */
public class DetallePedidoDTO {  
    private int idPedido;          
    private int idPizza;           
    private int cantidad;
    private String notasPreparacion;
    private double precioUnitario;

    public DetallePedidoDTO() {
    }

    public DetallePedidoDTO(int idPedido, int idPizza, int cantidad, String notasPreparacion, double precioUnitario) {
        this.idPedido = idPedido;
        this.idPizza = idPizza;
        this.cantidad = cantidad;
        this.notasPreparacion = notasPreparacion;
        this.precioUnitario = precioUnitario;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNotasPreparacion() {
        return notasPreparacion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    @Override
    public String toString() {
        return "DetallePedidoDTO{" + "idPedido=" + idPedido + ", idPizza=" + idPizza + ", cantidad=" + cantidad + ", notasPreparacion=" + notasPreparacion + ", precioUnitario=" + precioUnitario + '}';
    }   
    
}
