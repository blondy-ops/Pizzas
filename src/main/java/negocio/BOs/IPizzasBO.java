/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.BOs;

import java.util.List;
import negocio.DTOs.PizzaDTO;
import negocio.excepciones.NegocioException;



/**
 *
 * @author jorge
 */
public interface IPizzasBO {

    public List<PizzaDTO> obtenerPizzasDisponibles() throws NegocioException;
    
    public int ContarPizzasBO() throws NegocioException;
    
}
