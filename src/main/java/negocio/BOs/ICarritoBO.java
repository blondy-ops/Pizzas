/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.BOs;

import java.util.List;
import negocio.DTOs.CarritoDTO;
import negocio.excepciones.NegocioException;


/**
 *
 * @author jorge
 */
public interface ICarritoBO {

    public void agregarCarrito(CarritoDTO carrito) throws NegocioException;

    public double calcularTotal() throws NegocioException;
    
    public List<CarritoDTO> obtenerCarrito() throws NegocioException;
    
}
