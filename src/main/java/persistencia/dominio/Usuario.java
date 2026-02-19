/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Benjamin
 */
public class Usuario {
    private int idUsuario;
    private String correo;
    private String contraseña;
    private TipoUsuario tipoUsuario;
    private List<Direccion> direcciones;

    public Usuario() {
    }

    public Usuario(int idUsuario, String correo, String contraseña, TipoUsuario tipoUsuario, List<Direccion> direcciones) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
        this.direcciones = new ArrayList<>();
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + ", tipoUsuario=" + tipoUsuario + ", direcciones=" + direcciones + '}';
    }
   
}
