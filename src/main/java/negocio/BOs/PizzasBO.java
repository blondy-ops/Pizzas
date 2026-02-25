/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.DTOs.PizzaDTO;
import negocio.excepciones.NegocioException;
import persistencia.DAO.IPizzaDAO;
import persistencia.dominio.DisponibilidadPizza;
import persistencia.dominio.Pizza;
import persistencia.dominio.TamañoPizza;
import persistencia.excepciones.PersistenciaException;



/**
 *
 * @author jorge
 */
public class PizzasBO implements IPizzasBO {

     private IPizzaDAO dao;  

    public PizzasBO(IPizzaDAO dao) { 
        this.dao = dao;
    }
    
    private static final Logger LOG = Logger.getLogger(PizzasBO.class.getName());

    @Override
    public List<PizzaDTO> obtenerPizzasDisponibles() throws NegocioException {

        try {
            List<Pizza> pizzas = dao.obtenerTodas();
            List<PizzaDTO> listaDTO = new ArrayList<>();
            for (Pizza x : pizzas) {

                if (x.getDisponibilidad() == DisponibilidadPizza.disponible) {
                    PizzaDTO dto = new PizzaDTO(x.getIdPizza(),x.getNombre(), x.getPrecio(), x.getTamañoPizza(), x.getImagen(),x.getDisponibilidad());
                    listaDTO.add(dto);
                }
            }
            LOG.info("Se creo la lista de pizzas");
            return listaDTO;
        } catch (PersistenciaException e) {
            LOG.log(Level.WARNING, "No se pudo crear la lista de pizzas");
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public int ContarPizzasBO() throws NegocioException {
        try {
            LOG.info("Se contaron las pizzas");
            return dao.ContarPizzas();
        } catch (PersistenciaException ex) {
            LOG.log(Level.WARNING, "No se pudo contar pizzas");
            throw new NegocioException(ex.getMessage());
        }
    }

}
