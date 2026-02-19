/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

/**
 *
 * @author Benjamin
 */
public class TelefonoCliente {
    private int idTelefono;
    private int idCliente;
    private String telefono;
    private EtiquetaTelefonoCliente etiquetaTelefono;

    public TelefonoCliente() {
    }
    //para insertar
    public TelefonoCliente(int idCliente, String telefono, EtiquetaTelefonoCliente etiquetaTelefono) {
        this.idCliente = idCliente;
        this.telefono = telefono;
        this.etiquetaTelefono = etiquetaTelefono;
    }
    //completo
    public TelefonoCliente(int idTelefono, int idCliente, String telefono, EtiquetaTelefonoCliente etiquetaTelefono) {
        this.idTelefono = idTelefono;
        this.idCliente = idCliente;
        this.telefono = telefono;
        this.etiquetaTelefono = etiquetaTelefono;
    }
    
    public int getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public EtiquetaTelefonoCliente getEtiquetaTelefono() {
        return etiquetaTelefono;
    }

    public void setEtiquetaTelefono(EtiquetaTelefonoCliente etiquetaTelefono) {
        this.etiquetaTelefono = etiquetaTelefono;
    }
    
    
}
