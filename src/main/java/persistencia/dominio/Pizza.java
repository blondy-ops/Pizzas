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
    private List<Ingrediente> ingredientes;

    public Pizza() {
    }

    public Pizza(int idPizza, String nombre, String descripcion, TamañoPizza tamañoPizza, double precio, List<Ingrediente> ingredientes) {
        this.idPizza = idPizza;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamañoPizza = tamañoPizza;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
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

    @Override
    public String toString() {
        return "Pizza{" + "idPizza=" + idPizza + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }
    
    
}
