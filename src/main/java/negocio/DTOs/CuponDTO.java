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
    private String codigo;
    private double descuento;
    
    public CuponDTO(String codigo, double descuento){
        this.codigo = codigo;
        this.descuento = descuento;
    }
    
    public double getDescuento() { return descuento; }
    public String getCodigo() { return codigo; }
}
