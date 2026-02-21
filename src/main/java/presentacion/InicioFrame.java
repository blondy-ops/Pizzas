/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Benjamin
 */
public class InicioFrame extends JFrame{
        public InicioFrame() {
        setTitle("Inicio");
        setSize(500, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FondoPanel fondo = new FondoPanel("fondo.jpg");
        fondo.setLayout(new GridBagLayout());
        add(fondo);

        JPanel panelBotones = new JPanel();
        panelBotones.setOpaque(false);
        panelBotones.setLayout(new GridLayout(2, 1, 10, 10));

        JButton btnPedido = new JButton("Pedido express");
        JButton btnLogin = new JButton("Iniciar sesión");

        estilizarBoton(btnPedido);
        estilizarBoton(btnLogin);

        panelBotones.add(btnPedido);
        panelBotones.add(btnLogin);

        fondo.add(panelBotones);

        btnPedido.addActionListener(e -> {
            new PedidoFrame();
            dispose();
        });

        btnLogin.addActionListener(e -> {
            new LoginFrame();
            dispose();
        });

        setVisible(true);
    }

    private void estilizarBoton(JButton btn) {
        btn.setBackground(Color.DARK_GRAY);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 16));
    }
}

