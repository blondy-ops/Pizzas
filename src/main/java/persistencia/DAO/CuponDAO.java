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
public class CuponDAO implements ICuponDAO{
    
    private final IConexionBD conexionBD;
    
    public CuponDAO(IConexionBD conexionBD){
        this.conexionBD = conexionBD;
    }
    
    /**
     * Metodo para consultar si un codigo de cupon esta activo en la base de datso
     * @param codigo
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public Cupon consultarCuponPorCodigo(String codigo) throws PersistenciaException {
        //se crea la consulta del sql
        String sql = "SELECT * FROM Cupones WHERE codigo = ?"; 
        
        try(Connection conn = conexionBD.crearConexion();
            PreparedStatement ps = conn.prepareStatement(sql)){
            
            //reemplazar el signo de interrogacion con el codigo en string
            ps.setString(1, codigo);
            
            //ejecuta la linea de la consulta
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    Cupon cupon = new Cupon(); //crea objeto tipo cupon
                    cupon.setIdCupon(rs.getInt("idCupon"));
                    cupon.setCodigo("codigo");
                    cupon.setDescuento(rs.getDouble("descuento"));
                    
                    //manejo de fechas de SQL a LocalDate de java
                    cupon.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                    
                    //la fecha fin puede ser NULA en tu base de datos
                    Date fechaFinSql = rs.getDate("fechaFIN");
                    if(fechaFinSql != null){ //valida si esta vacia
                        cupon.setFechaFin(fechaFinSql.toLocalDate()); //se cambai a formato sin hora (solo dia mes y año)
                    }
                    
                    cupon.setUsosMaximos(rs.getInt("usosMaximos")); //saca del resultado de la consulta de la base de datos cada dato y lo pone en el objeto cupon que se creo como copia
                    cupon.setUsosActuales(rs.getInt("usos"));
                    
                    return cupon; //se devuelve el cupon encontrado en la base de datos
                } else {
                    return null; // cuando no se encontro el cupon 
                }
            }
        } catch (SQLException ex){
            throw new PersistenciaException("Error al consultar el cupon de la BD"); //cuando da la excepcion de la conexion a la bd
        }
    }
    
}
