/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

/**
 *
 * @author Benjamin
 */
import javax.swing.*;
import java.awt.*;

public class RegistroDatosFrame extends JFrame {

    private JTextField nombres, apPaterno, apMaterno, calle, numero,
            colonia, fecha, telefono, etiqueta;

    public RegistroDatosFrame() {

        setTitle("Registro de Perfil");
        setSize(500, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FondoPanel fondo = new FondoPanel("fondo.jpg");
        fondo.setLayout(null);
        add(fondo);

        int y = 40;

        nombres = crearCampo("Nombres", fondo, y);
        y += 60;
        apPaterno = crearCampo("Apellido paterno", fondo, y);
        y += 60;
        apMaterno = crearCampo("Apellido materno", fondo, y);
        y += 60;
        calle = crearCampo("Calle", fondo, y);
        y += 60;
        numero = crearCampo("Numero exterior", fondo, y);
        y += 60;
        colonia = crearCampo("Colonia", fondo, y);
        y += 60;
        fecha = crearCampo("Fecha nacimiento", fondo, y);
        y += 60;
        telefono = crearCampo("Telefono", fondo, y);
        y += 60;
        etiqueta = crearCampo("Etiqueta(telefono)", fondo, y);
        y += 70;

        JButton btnRegistrar = new JButton("Registrar Perfil");
        btnRegistrar.setBounds(130, y, 220, 45);
        estilizarBoton(btnRegistrar);
        fondo.add(btnRegistrar);

        btnRegistrar.addActionListener(e -> validarDatos());

        setVisible(true);
    }

    private JTextField crearCampo(String texto, JPanel fondo, int y) {
        JLabel label = new JLabel(texto);
        label.setBounds(90, y, 300, 20);
        label.setForeground(Color.WHITE);
        fondo.add(label);

        JTextField campo = new JTextField();
        campo.setBounds(90, y + 22, 300, 35);
        fondo.add(campo);

        return campo;
    }

    private void validarDatos() {

        if (nombres.getText().isEmpty()
                || apPaterno.getText().isEmpty()
                || telefono.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Algunos campos son inválidos",
                    "Datos inválidos",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // si todo correcto → siguiente pantalla
        new CrearUsuarioFrame();
        dispose();
    }

    private void estilizarBoton(JButton btn) {
        btn.setBackground(Color.DARK_GRAY);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.setFont(new Font("Arial", Font.BOLD, 16));
    }
}
