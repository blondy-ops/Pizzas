/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import javax.swing.JFrame;
import java.awt.*;
import java.util.logging.Level;
import javax.swing.*;
import negocio.BOs.IPedidoBO;
import persistencia.dominio.Pedido;
import persistencia.dominio.EstadoPedido;
import java.util.logging.Logger;
import negocio.DTOs.PedidoDTO;
/**
 *
 * @author Benjamin
 */
public class VentanaEstadoPedido extends JFrame{
    private PedidoDTO pedidoDTO;
    private JLabel lblEstado;
    private JLabel lblDescripcion;
    
    //estas herramientas se usan para la constante actualizacion del pedido verificando la bd (
    private final IPedidoBO pedidoBO;
    private Timer temporizador;
    
    
    public VentanaEstadoPedido(PedidoDTO pedidoDTO, IPedidoBO pedidoBO) { //se agrega la herramienta de pedidoBO al constructor
        this.pedidoDTO = pedidoDTO;
        this.pedidoBO = pedidoBO;

        setTitle("Estado del pedido");
        setSize(500, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        iniciarComponentes();
        mostrarEstadoActual();
        
        iniciarSondeoAutomatico();//este metodo es para que vaya a la base de datos cada cierto tiempo y pueda actualizarse lo que vaya cambiando un empleado en la otra ventana de gestion de pedidos
        
    }

    private void iniciarSondeoAutomatico(){
        // Se pone un temporizador de 5 segundos
        temporizador = new Timer(5000, e -> { 
            try {
                // Se llama al BO para que vaya a la BD y traiga la versión más reciente
                PedidoDTO pedidoFresco = pedidoBO.obtenerPedidoPorId(pedidoDTO.getIdPedido());
                
                // Si encontramos una actualización de estado en el pedido
                if(pedidoFresco != null && !pedidoFresco.getEstado().equals(this.pedidoDTO.getEstado())){
                    
                    // Usamos el método para actualizar la pantalla
                    refrescarEstado(pedidoFresco);
                    
                    // CORRECCIÓN 1: Como ahora es DTO, comparamos con Textos (String) y no con el Enum
                    String estadoFresco = pedidoFresco.getEstado().toLowerCase();
                    if(estadoFresco.equals("entregado") || estadoFresco.equals("cancelado")){
                        temporizador.stop();
                    }
                }
            } catch(Exception ex) {
                // Si hay un error que cause que se detenga el timer, se dejará de estar actualizando
                //LOG.log(Level.WARNING, "Interrupcion temporal de la conexion de actualizacion de estado", ex);
                System.out.println("Er");
            }
        });
        
        // CORRECCIÓN 2: ¡Encendemos el cronómetro para que empiece a funcionar!
        temporizador.start(); 
    }
    
    // detiene el temporizador si el usuario cierra la ventana manualmente
    @Override
    public void dispose(){
        if(temporizador != null && temporizador.isRunning()){
            temporizador.stop();
        }
        super.dispose();
    }
    
    private void iniciarComponentes() {

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Estado del pedido", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        lblEstado = new JLabel("", SwingConstants.CENTER);
        lblEstado.setFont(new Font("Arial", Font.BOLD, 20));
        lblEstado.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblDescripcion = new JLabel("", SwingConstants.CENTER);
        lblDescripcion.setAlignmentX(Component.CENTER_ALIGNMENT);

        centro.add(lblEstado);
        centro.add(Box.createVerticalStrut(10));
        centro.add(lblDescripcion);

        add(centro, BorderLayout.CENTER);

        JButton btnVolver = new JButton("Volver al menú");
        btnVolver.addActionListener(e -> dispose());

        JPanel sur = new JPanel();
        sur.add(btnVolver);

        add(sur, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    private void mostrarEstadoActual() {

        if (pedidoDTO == null || pedidoDTO.getEstado() == null) {
            lblEstado.setText("Sin información");
            return;
        }

        String estadoTexto = pedidoDTO.getEstado().toLowerCase();

        switch (estadoTexto) {

            case "pendiente":
                lblEstado.setText("Pendient​e");
                lblDescripcion.setText("Tu orden ha sido recibida.");
                lblEstado.setForeground(Color.ORANGE);
                break;

            case "listo":
                lblEstado.setText("Listo");
                lblDescripcion.setText("Tu pedido está terminado.");
                lblEstado.setForeground(new Color(0, 128, 0));
                break;

            case "entregado":
                lblEstado.setText("Entregado");
                lblDescripcion.setText("El cliente recibió el pedido.");
                lblEstado.setForeground(Color.GRAY);
                break;

            case "cancelado":
                lblEstado.setText("Cancelado");
                lblDescripcion.setText("El pedido fue cancelado.");
                lblEstado.setForeground(Color.RED);
                break;

            case "no_reclamado":
                lblEstado.setText("No reclamado");
                lblDescripcion.setText("No se recogió en el tiempo establecido.");
                lblEstado.setForeground(Color.yellow);
                break;
        }
    }

    public void refrescarEstado(PedidoDTO pedidoActualizado) {
        this.pedidoDTO = pedidoActualizado;
        mostrarEstadoActual();
    }
    
}
