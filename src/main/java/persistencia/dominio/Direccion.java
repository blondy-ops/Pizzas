/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

/**
 *
 * @author Benjamin
 */
public class Direccion {
    private int idDireccion;
    private int idUsuario;
    private String calle;
    private String numero;
    private String colonia;

    public Direccion() { //constructor vacio
    }
    
    /**
     * Constructor sin idDireccion para insertar
     * @param idUsuario
     * @param calle
     * @param numero
     * @param colonia 
     */
    public Direccion(int idUsuario, String calle, String numero, String colonia) {
        this.idUsuario = idUsuario;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
    }
    //constructor completo
    public Direccion(int idDireccion, int idUsuario, String calle, String numero, String colonia) {
        this.idDireccion = idDireccion;
        this.idUsuario = idUsuario;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    @Override
    public String toString() {
        return "Direccion{" + "idDireccion=" + idDireccion + ", idUsuario=" + idUsuario + ", calle=" + calle + ", numero=" + numero + ", colonia=" + colonia + '}';
    }
    
    
    
}
