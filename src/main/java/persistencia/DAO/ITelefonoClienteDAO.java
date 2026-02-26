/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAO;

import java.util.List;
import negocio.DTOs.TelefonoDTO;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author jorge
 */
public interface ITelefonoClienteDAO {
    public void insertarTelefono(int idCliente, String telefono, String etiqueta) throws PersistenciaException;
    
    public void actualizarTelefono(int idTelefono, String telefono,String etiqueta) throws PersistenciaException;
    
    public List<TelefonoDTO> obtenerTelefonos(int idCliente) throws PersistenciaException;
}
