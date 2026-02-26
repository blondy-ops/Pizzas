/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

/**
 *
 * @author Benjamin
 */
public class CuponDTO {
    private int idcupon; 
    private String codigo;
    private double descuento;

    public CuponDTO(int idcupon, String codigo, double descuento) {
        this.idcupon = idcupon;
        this.codigo = codigo;
        this.descuento = descuento;
    }

    public int getIdcupon() {
        return idcupon;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getDescuento() {
        return descuento;
    }

    @Override
    public String toString() {
        return "CuponDTO{" + "idcupon=" + idcupon + ", codigo=" + codigo + ", descuento=" + descuento + '}';
    }
    
}
