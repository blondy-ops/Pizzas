/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

/**
 *
 * @author Benjamin
 */
public class IngredientePizza {
    private int idPizzasIngredientes;  
    private int idPizza;              
    private int idIngrediente;     

    public IngredientePizza() {
    }

    public IngredientePizza(int idPizza, int idIngrediente) {
        this.idPizza = idPizza;
        this.idIngrediente = idIngrediente;
    }

    public IngredientePizza(int idPizzasIngredientes, int idPizza, int idIngrediente) {
        this.idPizzasIngredientes = idPizzasIngredientes;
        this.idPizza = idPizza;
        this.idIngrediente = idIngrediente;
    }

    public int getIdPizzasIngredientes() {
        return idPizzasIngredientes;
    }

    public void setIdPizzasIngredientes(int idPizzasIngredientes) {
        this.idPizzasIngredientes = idPizzasIngredientes;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    @Override
    public String toString() {
        return "IngredientePizza{" + "idPizzasIngredientes=" + idPizzasIngredientes + ", idPizza=" + idPizza + ", idIngrediente=" + idIngrediente + '}';
    }
    
    
}
