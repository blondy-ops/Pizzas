/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Benjamin
 */
public class Cliente extends Usuario{
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;

    public Cliente(String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, int idUsuario, String correo, String contraseña, TipoUsuario tipoUsuario, List<Direccion> direcciones) {
        super(idUsuario, correo, contraseña, tipoUsuario, direcciones);
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    
    
    
    
}
