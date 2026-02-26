/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import persistencia.dominio.Pedido;
import persistencia.dominio.EstadoPedido;

/**
 *
 * @author Benjamin
 */
public class VentanaEstadoPedido extends JFrame{
    private Pedido pedido;
    private JLabel lblEstado;
    private JLabel lblDescripcion;

    public VentanaEstadoPedido(Pedido pedido) {
        this.pedido = pedido;

        setTitle("Estado del pedido");
        setSize(500, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        iniciarComponentes();
        mostrarEstadoActual();
        
        
        
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

        if (pedido == null || pedido.getEstado() == null) {
            lblEstado.setText("Sin información");
            return;
        }

        EstadoPedido estado = pedido.getEstado();

        switch (estado) {

            case pendiente:
                lblEstado.setText("Pendient​e");
                lblDescripcion.setText("Tu orden ha sido recibida.");
                lblEstado.setForeground(Color.ORANGE);
                break;

            case listo:
                lblEstado.setText("Listo");
                lblDescripcion.setText("Tu pedido está terminado.");
                lblEstado.setForeground(new Color(0, 128, 0));
                break;

            case entregado:
                lblEstado.setText("Entregado");
                lblDescripcion.setText("El cliente recibió el pedido.");
                lblEstado.setForeground(Color.GRAY);
                break;

            case cancelado:
                lblEstado.setText("Cancelado");
                lblDescripcion.setText("El pedido fue cancelado.");
                lblEstado.setForeground(Color.RED);
                break;

            case no_reclamado:
                lblEstado.setText("No reclamado");
                lblDescripcion.setText("No se recogió en el tiempo establecido.");
                lblEstado.setForeground(Color.yellow);
                break;
        }
    }

    public void refrescarEstado(Pedido pedidoActualizado) {
        this.pedido = pedidoActualizado;
        mostrarEstadoActual();
        
    }
}
