/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;


/**
 *
 * @author jorge
 */
public class CarritoDTO {
    
    private String nombre;
    private String tamaño;
    private int cantidad; 
    private double precioUnitario;
    private double Subtotal;

    public CarritoDTO() {
    }

    public CarritoDTO(String nombre, String tamaño, int cantidad, double precioUnitario, double Subtotal) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.Subtotal = Subtotal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTamaño() {
        return tamaño;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getSubtotal() {
        return Subtotal;
    }

    @Override
    public String toString() {
        return "CarritoDTO{" + "nombre=" + nombre + ", tama\u00f1o=" + tamaño + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", Subtotal=" + Subtotal + '}';
    }

}
