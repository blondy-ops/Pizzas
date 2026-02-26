/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author munos
 */
public class RegistroUsuarioDTO {

    private int idUsuario;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private String calle;
    private int numero;
    private String colonia;
    private String telefono;
    private String etiqueta;
    private List<TelefonoDTO> telefonos;
    private String correo;
    private String contrasena;

    public RegistroUsuarioDTO(String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, String calle,
            int numero,
            String colonia,
            String telefono,
            String etiqueta,
            String correo,
            String contrasena) {

        this.idUsuario = 0;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.telefono = telefono;
        this.etiqueta = etiqueta;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefonos = new ArrayList<>();
    }

    public RegistroUsuarioDTO(
            int idUsuario,
            String nombres,
            String apellidoPaterno,
            String apellidoMaterno,
            LocalDate fechaNacimiento,
            String calle,
            int numero,
            String colonia,
            List<TelefonoDTO> telefonos,
            String correo,
            String contrasena) {

        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.telefonos = telefonos;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public String getColonia() {
        return colonia;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public List<TelefonoDTO> getTelefonos() {
        return telefonos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }
}
