/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.awt.Component;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import negocio.DTOs.PedidoExpressDTO;

/**
 *
 * @author jorge
 */
public class FrameDatosExpress extends JFrame{
    public FrameDatosExpress(PedidoExpressDTO dto) {

        setTitle("Datos del Pedido Express");
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel lblTitulo = new JLabel("Pedido Express creado");
        JLabel lblsubTitulo = new JLabel("Pasar a recojer con esta informacion");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblsubTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblsubTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblFolio = new JLabel("Folio: " + dto.getFolio());
        JLabel lblPin = new JLabel("PIN: " + dto.getPin());

        lblFolio.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblPin.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(20));
        panel.add(lblTitulo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblsubTitulo);
        panel.add(Box.createVerticalStrut(20));
        panel.add(lblFolio);
        panel.add(Box.createVerticalStrut(10));
        panel.add(lblPin);

        add(panel);
        setVisible(true);
    }
}
