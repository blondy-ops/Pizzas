package presentacion;

import javax.swing.*;
import java.awt.*;
import negocio.BOs.IUsuarioBO;
import negocio.BOs.UsuarioBO;
import negocio.DTOs.RegistroUsuarioDTO;
import negocio.excepciones.NegocioException;
import persistencia.Conexion.ConexionBD;

public class RegistroCompletoFrame extends JFrame {

    private JTextField nombres, apPaterno, apMaterno, calle, numero,
            colonia, fecha, telefono, etiqueta, correo;

    private JPasswordField pass1, pass2;

    public RegistroCompletoFrame() {

        setTitle("Registro Completo");
        setSize(500, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FondoPanel fondo = new FondoPanel("fondo.jpg");
        fondo.setLayout(null);

        int y = 30;

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
        fecha = crearCampo("Fecha nacimiento (YYYY-MM-DD)", fondo, y);
        y += 60;
        telefono = crearCampo("Telefono", fondo, y);
        y += 60;
        etiqueta = crearCampo("Etiqueta telefono (casa/trabajo)", fondo, y);
        y += 60;
        correo = crearCampo("Correo electrónico", fondo, y);
        y += 60;
        pass1 = crearPassword("Contraseña", fondo, y);
        y += 60;
        pass2 = crearPassword("Repetir contraseña", fondo, y);
        y += 80;

        JButton btnRegistrar = new JButton("Crear Cuenta");
        btnRegistrar.setBounds(130, y, 220, 45);
        estilizarBoton(btnRegistrar);
        fondo.add(btnRegistrar);

        btnRegistrar.addActionListener(e -> validarYRegistrar());

        fondo.setPreferredSize(new Dimension(480, y + 120));

        JScrollPane scroll = new JScrollPane(fondo);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        setContentPane(scroll);

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

    private JPasswordField crearPassword(String texto, JPanel fondo, int y) {
        JLabel label = new JLabel(texto);
        label.setBounds(90, y, 300, 20);
        label.setForeground(Color.WHITE);
        fondo.add(label);

        JPasswordField campo = new JPasswordField();
        campo.setBounds(90, y + 22, 300, 35);
        fondo.add(campo);

        JScrollPane scroll = new JScrollPane(fondo);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scroll);

        return campo;
    }

    private void validarYRegistrar() {

        String p1 = new String(pass1.getPassword());
        String p2 = new String(pass2.getPassword());

        if (nombres.getText().isEmpty()
                || apPaterno.getText().isEmpty()
                || telefono.getText().isEmpty()
                || correo.getText().isEmpty()
                || !p1.equals(p2)) {

            JOptionPane.showMessageDialog(this,
                    "Datos inválidos o contraseñas no coinciden",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            RegistroUsuarioDTO dto = new RegistroUsuarioDTO(
                    nombres.getText(),
                    apPaterno.getText(),
                    apMaterno.getText(),
                    java.time.LocalDate.parse(fecha.getText()),
                    calle.getText(),
                    Integer.parseInt(numero.getText()),
                    colonia.getText(),
                    telefono.getText(),
                    etiqueta.getText(),
                    correo.getText(),
                    p1
            );

            ConexionBD conexion = new ConexionBD();
            IUsuarioBO bo = new UsuarioBO(conexion);

            bo.registrarClienteCompleto(dto);

            JOptionPane.showMessageDialog(this,
                    "Cuenta creada correctamente");

            new LoginFrame();
            dispose();

        } catch (NegocioException e) {

            JOptionPane.showMessageDialog(this,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    "Error inesperado: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
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
