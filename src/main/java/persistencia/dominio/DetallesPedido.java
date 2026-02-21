/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

/**
 *
 * @author Benjamin
 */
public class DetallesPedido {
    private int idDetallesPedido;
    private int idPedido;
    private Pizza pizza;
    private int cantidad;
    private String notasPreparacion;
    private double precioUnitario;

    public DetallesPedido() {
    }

    //para insertar
    public DetallesPedido(int idPedido, int cantidad, String notasPreparacion, double precioUnitario) {
        this.idPedido = idPedido;
        this.pizza = pizza;
        this.cantidad = cantidad;
        this.notasPreparacion = notasPreparacion;
        this.precioUnitario = precioUnitario;
    }

    public DetallesPedido(int idDetallesPedido, int idPedido, Pizza pizza, int cantidad, String notasPreparacion, double precioUnitario) {
        this.idDetallesPedido = idDetallesPedido;
        this.idPedido = idPedido;
        this.pizza = pizza;
        this.cantidad = cantidad;
        this.notasPreparacion = notasPreparacion;
        this.precioUnitario = precioUnitario;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    
    
    public int getIdDetallesPedido() {
        return idDetallesPedido;
    }

    public void setIdDetallesPedido(int idDetallesPedido) {
        this.idDetallesPedido = idDetallesPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNotasPreparacion() {
        return notasPreparacion;
    }

    public void setNotasPreparacion(String notasPreparacion) {
        this.notasPreparacion = notasPreparacion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "DetallesPedido{" + "idDetallesPedido=" + idDetallesPedido + ", idPedido=" + idPedido + ", idPizza=" + pizza.getIdPizza() + ", cantidad=" + cantidad + ", notasPreparacion=" + notasPreparacion + ", precioUnitario=" + precioUnitario + '}';
    }
    
    
}
