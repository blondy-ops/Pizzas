package persistencia.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.Conexion.IConexionBD;
import persistencia.DAO.IPizzaDAO;
import persistencia.dominio.DisponibilidadPizza;
import persistencia.dominio.Pizza;
import persistencia.dominio.TamañoPizza;
import persistencia.excepciones.PersistenciaException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jorge
 */
public class PizzasDAO implements  IPizzaDAO{

    private final IConexionBD conexionBD;

    public PizzasDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    private static final Logger LOG=Logger.getLogger(PizzasDAO.class.getName());
    
    
    @Override
    public List<Pizza> obtenerTodas() throws PersistenciaException {
        
        List<Pizza> listaPizzas=new ArrayList<>();
        
        String comandoSQL="""
                          SELECT idPizza,nombre,descripcion,precio,disponibilidad,tamano,imagen
                          FROM Pizzas
                          """;
        
        try (Connection con=this.conexionBD.crearConexion();PreparedStatement ps=con.prepareStatement(comandoSQL)){
            try(ResultSet rs=ps.executeQuery()){
                while(rs.next()){
                    Pizza pizza=new Pizza();
                    
                    pizza.setIdPizza(rs.getInt("idPizza"));
                    pizza.setNombre(rs.getString("nombre"));
                    pizza.setDescripcion(rs.getString("descripcion"));
                    pizza.setPrecio(rs.getDouble("precio"));
                    String disponibilidad=rs.getString("disponibilidad");
                    disponibilidad = disponibilidad.replace(" ", "_");
                    pizza.setDisponibilidad(DisponibilidadPizza.valueOf(disponibilidad));
                    String tamano=rs.getString("tamano");
                    pizza.setTamañoPizza(TamañoPizza.valueOf(tamano));
                    pizza.setImagen(rs.getString("imagen"));
                    
                    listaPizzas.add(pizza);
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.WARNING, "Error: Al obtener las pizzas",e);
            throw new PersistenciaException("Error: no se pudo obtener las pizzas");
        }
        
        return listaPizzas;
    }

    @Override
    public int ContarPizzas() throws PersistenciaException {
        String comandoSql="""
                          SELECT COUNT(*)
                          FROM Pizzas
                          WHERE disponibilidad="disponible"
                          """;
        int total=0;
        try (Connection con=this.conexionBD.crearConexion(); PreparedStatement ps=con.prepareStatement(comandoSql)){
            try(ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    total = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
             LOG.log(Level.WARNING, "Error: Al obtener cuantas pizzas hay",e);
             throw new PersistenciaException("Error: no se pudo obtener cuantas pizzas hay");
        }
        
        return total;
    }
    
}
