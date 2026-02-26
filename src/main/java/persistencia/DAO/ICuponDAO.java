/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAO;

import persistencia.dominio.Cupon;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Benjamin
 */
public interface ICuponDAO {
    
    /**
     * Codigo que busca un codigo de cupon en string que exista en la base de datos y que sea valido
     * @param codigo
     * @return
     * @throws PersistenciaException 
     */
    Cupon consultarCuponPorCodigo(String codigo) throws PersistenciaException;
    
}
