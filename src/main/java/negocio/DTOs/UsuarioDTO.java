/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

import persistencia.dominio.TipoUsuario;

/**
 *
 * @author Benjamin
 */
public class UsuarioDTO {
    private final int idUsuario;
    private final String correo;
    private final TipoUsuario tipoUsuario;  

    public UsuarioDTO(int idUsuario, String correo, TipoUsuario tipoUsuario) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.tipoUsuario = tipoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public TipoUsuario getTipoUsuario() {   
        return tipoUsuario;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "idUsuario=" + idUsuario + ", correo=" + correo + ", tipoUsuario=" + tipoUsuario + '}';
    }
    
}

