/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

import java.util.List;

/**
 * 
 * @author Benjamin
 */
public class Pizza {
    private int idPizza;
    private String nombre;
    private String descripcion;
    private TamañoPizza tamañoPizza;
    private double precio;
    private String imagen;
    private DisponibilidadPizza disponibilidad;

    public Pizza() {
    }

    public Pizza(int idPizza, String nombre, String descripcion, TamañoPizza tamañoPizza, double precio, String imagen, DisponibilidadPizza disponibilidad) {
        this.idPizza = idPizza;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamañoPizza = tamañoPizza;
        this.precio = precio;
        this.imagen = imagen;
        this.disponibilidad = disponibilidad;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TamañoPizza getTamañoPizza() {
        return tamañoPizza;
    }

    public void setTamañoPizza(TamañoPizza tamañoPizza) {
        this.tamañoPizza = tamañoPizza;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public DisponibilidadPizza getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(DisponibilidadPizza disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Pizza{" + "idPizza=" + idPizza + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tama\u00f1oPizza=" + tamañoPizza + ", precio=" + precio + ", imagen=" + imagen + ", disponibilidad=" + disponibilidad + '}';
    }

}
