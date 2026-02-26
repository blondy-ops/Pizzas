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

    /**
     * Metodo para consultar si un codigo de cupon esta activo en la base de
     * datso
     *
     * @param codigo
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Cupon consultarCuponPorCodigo(String codigo) throws PersistenciaException {

        String sql = "SELECT * FROM Cupones WHERE codigo = ?";

        try (Connection conn = conexionBD.crearConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Cupon cupon = new Cupon();
                    cupon.setIdCupon(rs.getInt("idCupon"));
                    cupon.setCodigo(rs.getString("codigo"));
                    cupon.setDescuento(rs.getDouble("descuento"));
                    cupon.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                    Date fechaFinSql = rs.getDate("fechaFin"); 
                    if (fechaFinSql != null) {
                        cupon.setFechaFin(fechaFinSql.toLocalDate());
                    }
                    cupon.setUsosMaximos(rs.getInt("usosMaximos"));
                    cupon.setUsosActuales(rs.getInt("usos"));
                    return cupon;
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al consultar el cupon de la BD", ex);
        }
    }

}
