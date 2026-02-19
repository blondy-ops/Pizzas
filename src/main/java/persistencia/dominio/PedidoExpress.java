/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

import java.time.LocalDate;

/**
 *
 * @author Benjamin
 */
public class PedidoExpress extends Pedido{
    private String pin;
    private String folio;

    public PedidoExpress(String pin, String folio, int idPedido, EstadoPedido estado, String notasEntrega, LocalDate fecha, LocalDate fechaEntrega, double total) {
        super(idPedido, estado, notasEntrega, fecha, fechaEntrega, total);
        this.pin = pin;
        this.folio = folio;
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
        return "PedidoExpress{" + "pin=" + pin + ", folio=" + folio + '}';
    }
    
    
    
}
