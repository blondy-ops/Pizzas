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

public class LoginFrame extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;

    public LoginFrame() {
        setTitle("Iniciar Sesión");
        setSize(500, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FondoPanel fondo = new FondoPanel("fondo.jpg");
        fondo.setLayout(null);
        add(fondo);

        JLabel titulo = new JLabel("INICIAR SESIÓN");
        titulo.setBounds(140, 80, 250, 40);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setForeground(Color.WHITE);
        fondo.add(titulo);

        JLabel lblUsuario = new JLabel("Correo");
        lblUsuario.setBounds(100, 200, 200, 25);
        lblUsuario.setForeground(Color.WHITE);
        fondo.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 230, 300, 35);
        fondo.add(txtUsuario);

        JLabel lblPassword = new JLabel("Contraseña");
        lblPassword.setBounds(100, 290, 200, 25);
        lblPassword.setForeground(Color.WHITE);
        fondo.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(100, 320, 300, 35);
        fondo.add(txtPassword);

        JButton btnLogin = new JButton("Iniciar sesión");
        btnLogin.setBounds(150, 400, 200, 45);
        estilizarBoton(btnLogin);
        fondo.add(btnLogin);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(150, 460, 200, 45);
        estilizarBoton(btnRegresar);
        fondo.add(btnRegresar);

        JLabel lblRegistro = new JLabel("<HTML><U>Registrar cuenta</U></HTML>");
        lblRegistro.setBounds(185, 520, 200, 30);
        lblRegistro.setForeground(Color.white);
        lblRegistro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fondo.add(lblRegistro);

        lblRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new RegistroDatosFrame();
                dispose();
            }
        });
        btnLogin.addActionListener(e -> validarLogin());

        btnRegresar.addActionListener(e -> {
            new InicioFrame();
            dispose();
        });

        setVisible(true);
    }

    private void validarLogin() {

        String usuario = txtUsuario.getText();
        String password = new String(txtPassword.getPassword());

        if (usuario.equals("admin") && password.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Bienvenido");
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        }
    }

    private void estilizarBoton(JButton btn) {
        btn.setBackground(Color.DARK_GRAY);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.setFont(new Font("Arial", Font.BOLD, 16));
    }
}