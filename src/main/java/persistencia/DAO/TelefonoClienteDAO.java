/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import negocio.DTOs.TelefonoDTO;
import persistencia.Conexion.ConexionBD;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author munos
 */
public class TelefonoClienteDAO implements ITelefonoClienteDAO {

     private final ConexionBD conexion;

    public TelefonoClienteDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public List<TelefonoDTO> obtenerTelefonos(int idCliente) throws PersistenciaException {

        List<TelefonoDTO> lista = new ArrayList<>();

        String sql = "SELECT * FROM TelefonosClientes WHERE idCliente = ?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCliente);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new TelefonoDTO(
                            rs.getInt("idTelefono"),
                            rs.getString("telefono"),
                            rs.getString("etiqueta")
                    ));
                }
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener teléfonos", e);
        }

        return lista;
    }
    
    @Override
    public void actualizarTelefono(int idTelefono, String telefono,String etiqueta) throws PersistenciaException {
        String sql = "UPDATE TelefonosClientes SET telefono=?, etiqueta=? WHERE idTelefono=?";

        try (Connection conn = conexion.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, telefono);
            ps.setString(2, etiqueta);
            ps.setInt(3, idTelefono);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar teléfono", e);
        }
    }
    @Override
    public void insertarTelefono(int idCliente, String telefono,String etiqueta) throws PersistenciaException {

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
