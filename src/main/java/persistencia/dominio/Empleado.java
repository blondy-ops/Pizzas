/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

import java.util.List;

/**
 *
 * @author Benjamin
 */
public class Empleado extends Usuario{
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private TipoEmpleado tipoEmpleado;

    public Empleado() {
    }

    public Empleado(String nombres, String apellidoPaterno, String apellidoMaterno, TipoEmpleado tipoEmpleado, int idUsuario, String correo, String contraseña, TipoUsuario tipoUsuario, List<Direccion> direcciones) {
        super(idUsuario, correo, contraseña, tipoUsuario, direcciones);
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.tipoEmpleado = tipoEmpleado;
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

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", tipoEmpleado=" + tipoEmpleado + '}';
    }

    
    
    
}
