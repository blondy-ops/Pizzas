/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricas.DAO;

import persistencia.Conexion.ConexionBD;
import persistencia.Conexion.IConexionBD;
import persistencia.DAO.CuponDAO;
import persistencia.DAO.ICuponDAO;

/**
 *
 * @author Benjamin
 */
public class FabricaDAO {
    
    //para la conexion
    public static IConexionBD obtenerConexion(){
        return new ConexionBD();
    }
    
    //construye el dao del cupon intectandole la conexion
    public static ICuponDAO obtenerCuponDAO(){
        return new CuponDAO(obtenerConexion());
    }
}
