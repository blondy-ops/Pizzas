/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAO;

import java.util.List;
import persistencia.dominio.Pizza;
import persistencia.excepciones.PersistenciaException;


/**
 *
 * @author jorge
 */
public interface IPizzaDAO {
    List<Pizza> obtenerTodas() throws PersistenciaException;
    int ContarPizzas() throws PersistenciaException;
}
