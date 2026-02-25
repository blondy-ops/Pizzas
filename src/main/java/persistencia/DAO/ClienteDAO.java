/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import persistencia.Conexion.ConexionBD;
import persistencia.dominio.Cliente;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author munos
 */
public class ClienteDAO implements IClienteDAO{
    private ConexionBD conexion;

    public ClienteDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }
    @Override
    public void insertarCliente(Cliente cliente) throws PersistenciaException {

        String sql = "INSERT INTO Clientes (idUsuario, nombres, apellidoPaterno, apellidoMaterno, fechaNacimiento) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cliente.getIdUsuario());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getApellidoPaterno());
            ps.setString(4, cliente.getApellidoMaterno());
            ps.setDate(5, Date.valueOf(cliente.getFechaNacimiento()));

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaException("Error al insertar cliente: " + e.getMessage());
        }
    }
}
