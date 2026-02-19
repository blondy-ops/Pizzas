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
    private int idPizza;
    private int cantidad;
    private String notasPreparacion;
    private double precioUnitario;

    public DetallesPedido() {
    }

    //para insertar
    public DetallesPedido(int idPedido, int idPizza, int cantidad, String notasPreparacion, double precioUnitario) {
        this.idPedido = idPedido;
        this.idPizza = idPizza;
        this.cantidad = cantidad;
        this.notasPreparacion = notasPreparacion;
        this.precioUnitario = precioUnitario;
    }

    public DetallesPedido(int idDetallesPedido, int idPedido, int idPizza, int cantidad, String notasPreparacion, double precioUnitario) {
        this.idDetallesPedido = idDetallesPedido;
        this.idPedido = idPedido;
        this.idPizza = idPizza;
        this.cantidad = cantidad;
        this.notasPreparacion = notasPreparacion;
        this.precioUnitario = precioUnitario;
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

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
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
        return "DetallesPedido{" + "idDetallesPedido=" + idDetallesPedido + ", idPedido=" + idPedido + ", idPizza=" + idPizza + ", cantidad=" + cantidad + ", notasPreparacion=" + notasPreparacion + ", precioUnitario=" + precioUnitario + '}';
    }
    
    
}
