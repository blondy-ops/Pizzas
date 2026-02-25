/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAO;

import persistencia.dominio.Cliente;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author jorge
 */
public interface IClienteDAO {
    public void insertarCliente(Cliente cliente) throws PersistenciaException;
}
