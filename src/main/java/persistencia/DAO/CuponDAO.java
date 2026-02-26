/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
//import java.util.Date;
import persistencia.Conexion.IConexionBD;
import persistencia.dominio.Cupon;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Benjamin
 */
public class CuponDAO implements ICuponDAO {

    private final IConexionBD conexionBD;

    public CuponDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Cupon consultarCuponPorCodigo(String codigo)
            throws PersistenciaException {

        String sql = "SELECT * FROM Cupones WHERE codigo = ?";

        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, codigo);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Cupon cupon = new Cupon();

                    cupon.setIdCupon(rs.getInt("idCupon"));
                    cupon.setCodigo(rs.getString("codigo"));
                    cupon.setDescuento(rs.getDouble("descuento"));

                    Date fechaInicio = rs.getDate("fechaInicio");
                    if (fechaInicio != null) {
                        cupon.setFechaInicio(fechaInicio.toLocalDate());
                    }

                    Date fechaFin = rs.getDate("fechaFin");
                    if (fechaFin != null) {
                        cupon.setFechaFin(fechaFin.toLocalDate());
                    }

                    cupon.setUsosMaximos(rs.getInt("usosMaximos"));
                    cupon.setUsosActuales(rs.getInt("usos"));

                    return cupon;
                }
            }

            return null;

        } catch (SQLException e) {
            throw new PersistenciaException(
                    "Error al consultar el cupón", e);
        }
    }
}