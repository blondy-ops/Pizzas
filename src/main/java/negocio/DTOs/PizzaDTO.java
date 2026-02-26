/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

import persistencia.dominio.DisponibilidadPizza;
import persistencia.dominio.TamañoPizza;

/**
 *
 * @author jorge
 */
public class PizzaDTO {
    private int idPizza;
    private String nombre;
    private double precio;
    private TamañoPizza tamano;
    private String imagen;
    private DisponibilidadPizza disponibilidad;

    public PizzaDTO() {
    }

    public PizzaDTO(int idPizza, String nombre, double precio, TamañoPizza tamano, String imagen, DisponibilidadPizza disponibilidad) {
        this.idPizza = idPizza;
        this.nombre = nombre;
        this.precio = precio;
        this.tamano = tamano;
        this.imagen = imagen;
        this.disponibilidad = disponibilidad;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public TamañoPizza getTamano() {
        return tamano;
    }

    public String getImagen() {
        return imagen;
    }

    public DisponibilidadPizza getDisponibilidad() {
        return disponibilidad;
    }

    @Override
    public String toString() {
        return "PizzaDTO{" + "idPizza=" + idPizza + ", nombre=" + nombre + ", precio=" + precio + ", tamano=" + tamano + ", imagen=" + imagen + ", disponibilidad=" + disponibilidad + '}';
    }

}
