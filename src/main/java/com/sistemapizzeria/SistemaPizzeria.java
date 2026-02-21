/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sistemapizzeria;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import persistencia.dominio.DetallesPedido;
import static persistencia.dominio.EstadoPedido.EN_PREPARACION;
import persistencia.dominio.PedidoProgramado;
import persistencia.dominio.Pizza;
import presentacion.VentanaRealizarPago;

/**
 *
 * @author Benjamin
 */
public class SistemaPizzeria {

    public static void main(String[] args) {
    PedidoProgramado pedidoFalso = new PedidoProgramado();
    pedidoFalso.setIdPedido(1);
    pedidoFalso.setNotasEntrega("Favor de echarle extra queso");
    pedidoFalso.setTotal(750);
    
    // --- AGREGAR PIZZAS FALSAS PARA VERLAS EN LA TABLA ---
    Pizza pizza1 = new Pizza();
    pizza1.setNombre("Pepperoni Grande");
    
    DetallesPedido det1 = new DetallesPedido();
    det1.setPizza(pizza1);
    det1.setCantidad(3);
    det1.setPrecioUnitario(200.00);
    
    Pizza pizza2 = new Pizza();
    pizza2.setNombre("Hawaiana Mediana");
    
    DetallesPedido det2 = new DetallesPedido();
    det2.setPizza(pizza2);
    det2.setCantidad(1);
    det2.setPrecioUnitario(150.00);
    
    List<DetallesPedido> listaPizzas = new ArrayList<>();
    listaPizzas.add(det1);
    listaPizzas.add(det2);

    // Guardamos la lista en el pedido
    pedidoFalso.setDetalles(listaPizzas);
    // -----------------------------------------------------
    
    VentanaRealizarPago ventana = new VentanaRealizarPago(pedidoFalso);
    ventana.setVisible(true);
    
    }
}
