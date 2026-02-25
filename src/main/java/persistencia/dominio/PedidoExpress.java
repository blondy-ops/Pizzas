/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Benjamin
 */
public class PedidoExpress{
   private int idPedido;
    private String pin;
    private String folio;

    public PedidoExpress() {
    }

    public PedidoExpress(int idPedido, String pin, String folio) {
        this.idPedido = idPedido;
        this.pin = pin;
        this.folio = folio;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    @Override
    public String toString() {
        return "PedidoExpress{" + "idPedido=" + idPedido + ", pin=" + pin + ", folio=" + folio + '}';
    }
    
}
