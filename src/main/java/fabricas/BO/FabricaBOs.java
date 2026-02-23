/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricas.BO;

import fabricas.DAO.FabricaDAO;
import negocio.BOs.CuponBO;
import negocio.BOs.ICuponBO;
import persistencia.DAO.CuponDAO;

/**
 *
 * @author Benjamin
 */
public class FabricaBOs {
    /*
    //metodo para obtener un tecnico listo para trabajar
    public static TecnicoBO obtenerTecnicoBO(){
        //creamos el tecnico BO e inyectamos la dependencia
        TecnicoBO tecnico=new TecnicoBO(FabricaDAO.obtenerTecnicoDAO());
        //regresamos el tecnico listo
        return tecnico;
    }
*/
    //metodo para obtener la herramiento (BO) lista para trabajar
    public static ICuponBO obtenerCuponBO(){
        //creamos el BO y le inyectamos su dependencia (el DAO)
        ICuponBO cuponBO = new CuponBO(FabricaDAO.obtenerCuponDAO());
        //se regresa el BO listo
        return cuponBO;
    }
}
