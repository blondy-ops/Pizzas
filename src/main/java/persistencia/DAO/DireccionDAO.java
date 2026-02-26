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
public class DireccionDAO implements IDireccionDAO {

    private ConexionBD conexion;

    public DireccionDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertarDireccion(int idCliente, String calle, int numero, String colonia) throws PersistenciaException {

        String sql = "INSERT INTO DireccionesClientes (idCliente, calle, numero, colonia) VALUES (?, ?, ?, ?)";

        try (Connection conn = conexion.crearConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            ps.setString(2, calle);
            ps.setInt(3, numero);
            ps.setString(4, colonia);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaException("Error al insertar dirección", e);
        }
    }

    public void actualizarDireccion(int idCliente, String calle,
            int numero, String colonia)
            throws PersistenciaException {

        String sql = "UPDATE DireccionesClientes SET calle=?, numero=?, colonia=? WHERE idCliente=?";

        try (Connection conn = conexion.crearConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, calle);
            ps.setInt(2, numero);
            ps.setString(3, colonia);
            ps.setInt(4, idCliente);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar dirección", e);
        }
    }
}
