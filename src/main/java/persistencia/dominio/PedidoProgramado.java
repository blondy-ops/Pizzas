/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.dominio;

/**
 *
 * @author Benjamin
 */
public class PedidoProgramado {

    private int idPedido;
    private Integer idCupon;

    public PedidoProgramado(int idPedido, Integer idCupon) {
        this.idPedido = idPedido;
        this.idCupon = idCupon;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public Integer getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(Integer idCupon) {
        this.idCupon = idCupon;
    }

    @Override
    public String toString() {
        return "PedidoProgramado{" + "idPedido=" + idPedido + ", idCupon=" + idCupon + '}';
    }
    
}
