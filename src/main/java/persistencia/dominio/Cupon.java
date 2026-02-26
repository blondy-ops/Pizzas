/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Benjamin
 */
public class Cupon {
    private int idCupon;
    private String codigo;
    private double descuento; 
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int usosMaximos;
    private int usosActuales;
    
    public Cupon() {
    }

    public Cupon(int idCupon, String codigo, double descuento, LocalDate fechaInicio, LocalDate fechaFin, int usosMaximos, int usosActuales) {
        this.idCupon = idCupon;
        this.codigo = codigo;
        this.descuento = descuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usosMaximos = usosMaximos;
        this.usosActuales = usosActuales;
    }
    
    public int getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(int idCupon) {
        this.idCupon = idCupon;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getUsosMaximos() {
        return usosMaximos;
    }

    public void setUsosMaximos(int usosMaximos) {
        this.usosMaximos = usosMaximos;
    }

    public int getUsosActuales() {
        return usosActuales;
    }

    public void setUsosActuales(int usosActuales) {
        this.usosActuales = usosActuales;
    }

    @Override
    public String toString() {
        return "Cupon{" + "idCupon=" + idCupon + ", codigo=" + codigo + ", descuento=" + descuento + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", usosMaximos=" + usosMaximos + ", usosActuales=" + usosActuales + '}';
    }
    
}
