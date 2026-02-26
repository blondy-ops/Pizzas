/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAO;

/**
 *
 * @author munos
 */
import java.sql.*;
import java.util.ArrayList;
import persistencia.Conexion.ConexionBD;
import persistencia.dominio.TipoUsuario;
import persistencia.dominio.Usuario;
import persistencia.excepciones.PersistenciaException;

public class UsuarioDAO implements IUsuarioDAO {

    private ConexionBD conexion;

    public UsuarioDAO(ConexionBD conexion) {
        this.conexion = conexion;
    }

    @Override
    public Usuario autenticar(String correo, String contrasena) throws PersistenciaException {

        String sql = "SELECT * FROM Usuarios WHERE correo = ? AND contrasena = ?";

        try (Connection conn = conexion.crearConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, correo);
            ps.setString(2, contrasena);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    int id = rs.getInt("idUsuario");
                    String tipoStr = rs.getString("tipo");

                    TipoUsuario tipo = TipoUsuario.valueOf(
                            tipoStr.substring(0, 1).toUpperCase() + tipoStr.substring(1)
                    );

                    return new Usuario(id, correo, contrasena, tipo, new ArrayList<>());
                }
            }

            return null;

        } catch (SQLException e) {
            throw new PersistenciaException("Error al autenticar usuario", e);
        }
    }

    @Override
    public int insertarUsuario(Usuario usuario) throws PersistenciaException {

        String sql = "INSERT INTO Usuarios (correo, contrasena, tipo) VALUES (?, ?, ?)";

        try (Connection conn = conexion.crearConexion(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, usuario.getCorreo());
            ps.setString(2, usuario.getContraseña());
            ps.setString(3, usuario.getTipoUsuario().name().toLowerCase());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }

            throw new PersistenciaException("No se pudo obtener el id generado");

        } catch (SQLException e) {
            throw new PersistenciaException("Error al insertar usuario", e);
        }
    }

    @Override
    public boolean existeCorreo(String correo) throws PersistenciaException {

        String sql = "SELECT 1 FROM Usuarios WHERE correo = ?";

        try (Connection conn = conexion.crearConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, correo);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al verificar correo", e);
        }
    }
    @Override
    public void actualizarUsuario(Usuario usuario) throws PersistenciaException {

        String sql = "UPDATE Usuarios SET correo = ?, contrasena = ? WHERE idUsuario = ?";

        try (Connection conn = conexion.crearConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getCorreo());
            ps.setString(2, usuario.getContraseña());
            ps.setInt(3, usuario.getIdUsuario());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar usuario", e);
        }
    }
    @Override
    public boolean existeCorreoExceptoId(String correo, int idUsuario) throws PersistenciaException {

    String sql = "SELECT 1 FROM Usuarios WHERE correo = ? AND idUsuario <> ?";

    try (Connection conn = conexion.crearConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, correo);
        ps.setInt(2, idUsuario);

        try (ResultSet rs = ps.executeQuery()) {
            return rs.next();
        }

    } catch (SQLException e) {
        throw new PersistenciaException("Error al verificar correo", e);
    }
}
}
