/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

/**
 *
 * @author munos
 */
import java.awt.GridLayout;
import negocio.BOs.IUsuarioBO;
import negocio.BOs.UsuarioBO;
import negocio.DTOs.RegistroUsuarioDTO;
import negocio.DTOs.TelefonoDTO;
import negocio.excepciones.NegocioException;
import persistencia.Conexion.ConexionBD;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ActualizarDatosFrame extends JFrame {

    private JTextField nombres, apPaterno, apMaterno, calle, numero, colonia, fecha, correo;
    private JTextField tel1, tel2, tel3;
    private JTextField etq1, etq2, etq3;
    private JPasswordField pass;
    private int idUsuario;

    public ActualizarDatosFrame(int idUsuario) {

        this.idUsuario = idUsuario;

        setTitle("Actualizar Perfil");
        setSize(450, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(0,1));

        nombres = new JTextField();
        apPaterno = new JTextField();
        apMaterno = new JTextField();
        fecha = new JTextField();
        calle = new JTextField();
        numero = new JTextField();
        colonia = new JTextField();
        correo = new JTextField();
        pass = new JPasswordField();

        tel1 = new JTextField();
        tel2 = new JTextField();
        tel3 = new JTextField();

        etq1 = new JTextField();
        etq2 = new JTextField();
        etq3 = new JTextField();

        add(new JLabel("Nombres")); add(nombres);
        add(new JLabel("Apellido Paterno")); add(apPaterno);
        add(new JLabel("Apellido Materno")); add(apMaterno);
        add(new JLabel("Fecha (YYYY-MM-DD)")); add(fecha);
        add(new JLabel("Calle")); add(calle);
        add(new JLabel("Número")); add(numero);
        add(new JLabel("Colonia")); add(colonia);
        add(new JLabel("Correo")); add(correo);
        add(new JLabel("Contraseña")); add(pass);

        add(new JLabel("Teléfono 1")); add(tel1);
        add(new JLabel("Etiqueta 1")); add(etq1);

        add(new JLabel("Teléfono 2")); add(tel2);
        add(new JLabel("Etiqueta 2")); add(etq2);

        add(new JLabel("Teléfono 3")); add(tel3);
        add(new JLabel("Etiqueta 3")); add(etq3);

        JButton btnActualizar = new JButton("Actualizar");
        add(btnActualizar);

        btnActualizar.addActionListener(e -> actualizar());

        setVisible(true);
    }

    private void actualizar() {
        try {
            List<TelefonoDTO> telefonos = new ArrayList<>();
            if (!tel1.getText().isEmpty())
                telefonos.add(new TelefonoDTO(0, tel1.getText(), etq1.getText()));
            if (!tel2.getText().isEmpty())
                telefonos.add(new TelefonoDTO(0, tel2.getText(), etq2.getText()));
            if (!tel3.getText().isEmpty())
                telefonos.add(new TelefonoDTO(0, tel3.getText(), etq3.getText()));

            RegistroUsuarioDTO dto = new RegistroUsuarioDTO(
                    idUsuario,
                    nombres.getText(),
                    apPaterno.getText(),
                    apMaterno.getText(),
                    LocalDate.parse(fecha.getText()),
                    calle.getText(),
                    Integer.parseInt(numero.getText()),
                    colonia.getText(),
                    telefonos,
                    correo.getText(),
                    new String(pass.getPassword())
            );

            ConexionBD conexion = new ConexionBD();
            IUsuarioBO bo = new UsuarioBO(conexion);
            bo.actualizarClienteCompleto(dto);
            JOptionPane.showMessageDialog(this,
                    "Datos actualizados correctamente");
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
}
