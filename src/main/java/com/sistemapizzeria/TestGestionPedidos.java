/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sistemapizzeria;

import negocio.BOs.IPedidoBO;
import negocio.BOs.PedidoBO;
import persistencia.Conexion.ConexionBD;
import persistencia.DAO.IPedidoDAO;
import persistencia.DAO.PedidoDAO;
import presentacion.VentanaGestionPedidos;

/**
 *
 * @author Benjamin
 */
public class TestGestionPedidos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1. Instanciamos nuestras herramientas (idealmente esto lo haría una clase Fábrica)
        ConexionBD conexion = new ConexionBD(); // Tu clase de conexión
        IPedidoDAO pedidoDAO = new PedidoDAO(conexion);
        IPedidoBO pedidoBO = new PedidoBO(pedidoDAO);
        
        // 2. Creamos la ventana y le pasamos el BO
        VentanaGestionPedidos ventana = new VentanaGestionPedidos(pedidoBO);
        ventana.setVisible(true);
        
    }
    
}
