/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.DTOs;

/**
 *
 * @author jorge
 */
public class PedidoExpressDTO {
    private int idPedido;  
    private String pin;        
    private String folio;   

    public PedidoExpressDTO() {
    }

    public PedidoExpressDTO(int idPedido, String pin, String folio) {
        this.idPedido = idPedido;
        this.pin = pin;
        this.folio = folio;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getPin() {
        return pin;
    }

    public String getFolio() {
        return folio;
    }

    @Override
    public String toString() {
        return "PedidoExpressDTO{" + "idPedido=" + idPedido + ", pin=" + pin + ", folio=" + folio + '}';
    }
    
}
