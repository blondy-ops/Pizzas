/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.util.ArrayList;
import java.util.List;
import negocio.DTOs.CarritoDTO;
import negocio.excepciones.NegocioException;

/**
 *
 * @author jorge
 */
public class CarritoBO implements ICarritoBO {

    private Integer idCuponAplicado = null; //empieza nulo

    private List<CarritoDTO> ListaCarrito = new ArrayList<>();

    private String notaGeneral = ""; //se agregar para las notas

    @Override
    public void setIdCuponAplicado(Integer idCupon) {
        this.idCuponAplicado = idCupon;
    }

    @Override
    public Integer getIdCuponAplicado() {
        return this.idCuponAplicado;
    }

    @Override
    public void setNotaGeneral(String nota) throws NegocioException {
        this.notaGeneral = nota;
    }

    @Override
    public String getNotaGeneral() {
        return this.notaGeneral;
    }

    @Override
    public void agregarCarrito(CarritoDTO carrito) throws NegocioException {
        ListaCarrito.add(carrito);
    }

    @Override
    public double calcularTotal() throws NegocioException {
        double total = 0;
        for (CarritoDTO x : ListaCarrito) {
            total += x.getSubtotal();
        }
        return total;
    }

    @Override
    public List<CarritoDTO> obtenerCarrito() throws NegocioException {
        return this.ListaCarrito;
    }

    @Override
    public void eliminarProduco(CarritoDTO carrito) throws NegocioException {
        ListaCarrito.remove(carrito);
    }

}
