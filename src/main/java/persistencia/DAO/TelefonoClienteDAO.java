/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import persistencia.Conexion.ConexionBD;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author munos
 */
public class TelefonoClienteDAO implements ITelefonoClienteDAO{
    private ConexionBD conexion;

    public TelefonoClienteDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }
    @Override
    public void insertarTelefono(int idCliente, String telefono, String etiqueta) throws PersistenciaException {

    String sql = "INSERT INTO TelefonosClientes (idCliente, telefono, etiqueta) VALUES (?, ?, ?)";

    try (Connection conn = conexion.crearConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, idCliente);
        ps.setString(2, telefono);
        ps.setString(3, etiqueta.toLowerCase());

        ps.executeUpdate();

    } catch (SQLException e) {
        throw new PersistenciaException("Error al insertar teléfono", e);
    }
}
}