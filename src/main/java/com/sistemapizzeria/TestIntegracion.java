/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sistemapizzeria;

import negocio.BOs.IPedidoBO;
import negocio.BOs.PedidoBO;
import negocio.DTOs.PedidoDTO;
import negocio.excepciones.NegocioException;
import persistencia.Conexion.ConexionBD;
import persistencia.DAO.IPedidoDAO;
import persistencia.DAO.PedidoDAO;
import presentacion.VentanaEstadoPedido;
import presentacion.VentanaGestionPedidos;

/**
 *
 * @author Benjamin
 */
public class TestIntegracion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD();
        IPedidoDAO pedidoDAO = new PedidoDAO(conexion);
        IPedidoBO pedidoBO = new PedidoBO(pedidoDAO);

        // =========================================================
        // 2. PANTALLA DEL EMPLEADO (Izquierda)
        // =========================================================
        VentanaGestionPedidos ventanaEmpleado = new VentanaGestionPedidos(pedidoBO);
        // Desactivamos el centrado automático para poder moverla
        ventanaEmpleado.setLocationRelativeTo(null); 
        // La colocamos a la izquierda de la pantalla
        ventanaEmpleado.setLocation(100, 200); 
        ventanaEmpleado.setVisible(true);

        // =========================================================
        // 3. PANTALLA DEL CLIENTE (Derecha)
        // =========================================================
        try {
            // Simulamos que el cliente con el Pedido #1 abrió su app
            // (Asegúrate de que el pedido con ID 1 exista en tu BD)
            PedidoDTO pedidoPrueba = pedidoBO.obtenerPedidoPorId(1);
            
            if (pedidoPrueba != null) {
                VentanaEstadoPedido ventanaCliente = new VentanaEstadoPedido(pedidoPrueba, pedidoBO);
                // La colocamos a la derecha de la pantalla
                ventanaCliente.setLocationRelativeTo(null);
                ventanaCliente.setLocation(1050, 200); 
                ventanaCliente.setVisible(true);
            } else {
                System.out.println("⚠️ No se encontró el pedido #1 en la base de datos.");
            }
            
        } catch (NegocioException ex) {
            System.out.println("Error al arrancar la prueba: " + ex.getMessage());
        }
    }
    
}
