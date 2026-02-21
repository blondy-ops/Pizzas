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

public class CrearUsuarioFrame extends JFrame {

    private JTextField correo;
    private JPasswordField pass1, pass2;

    public CrearUsuarioFrame() {

        setTitle("Crear Usuario");
        setSize(400,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FondoPanel fondo = new FondoPanel("fondo.jpg");
        fondo.setLayout(null);
        add(fondo);

        correo = crearCampo("Correo electrónico", fondo, 40);
        pass1 = crearPassword("Contraseña", fondo, 120);
        pass2 = crearPassword("Repetir contraseña", fondo, 200);

        JButton btn = new JButton("Registrar cuenta");
        btn.setBounds(80, 290, 240, 45);
        estilizarBoton(btn);
        fondo.add(btn);

        btn.addActionListener(e -> validar());

        setVisible(true);
    }

    private JTextField crearCampo(String texto, JPanel fondo, int y){
        JLabel l = new JLabel(texto);
        l.setBounds(40,y,300,20);
        l.setForeground(Color.WHITE);
        fondo.add(l);

        JTextField t = new JTextField();
        t.setBounds(40,y+22,300,35);
        fondo.add(t);
        return t;
    }

    private JPasswordField crearPassword(String texto, JPanel fondo, int y){
        JLabel l = new JLabel(texto);
        l.setBounds(40,y,300,20);
        l.setForeground(Color.WHITE);
        fondo.add(l);

        JPasswordField t = new JPasswordField();
        t.setBounds(40,y+22,300,35);
        fondo.add(t);
        return t;
    }

    private void validar(){

        String p1 = new String(pass1.getPassword());
        String p2 = new String(pass2.getPassword());

        if(correo.getText().isEmpty() || !p1.equals(p2)){
            JOptionPane.showMessageDialog(this,
                    "Credenciales inválidas",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Registro exitoso");

        new LoginFrame();
        dispose();
    }

    private void estilizarBoton(JButton btn){
        btn.setBackground(Color.DARK_GRAY);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.setFont(new Font("Arial", Font.BOLD, 16));
    }
}
