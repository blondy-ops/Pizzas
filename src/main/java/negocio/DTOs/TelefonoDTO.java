/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

/**
 *
 * @author munos
 */
public class TelefonoDTO {
    private int idTelefono; 
    private String telefono;
    private String etiqueta;

    public TelefonoDTO(int idTelefono, String telefono, String etiqueta) {
        this.idTelefono = idTelefono;
        this.telefono = telefono;
        this.etiqueta = etiqueta;
    }

    public int getIdTelefono() {
        return idTelefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
}