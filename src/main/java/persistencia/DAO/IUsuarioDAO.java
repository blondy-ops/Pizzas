/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.DAO;

import persistencia.dominio.Usuario;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author jorge
 */
public interface IUsuarioDAO {

    public Usuario autenticar(String correo, String contrasena) throws PersistenciaException;

    public int insertarUsuario(Usuario usuario) throws PersistenciaException;

    public boolean existeCorreo(String correo) throws PersistenciaException;
    
    public void actualizarUsuario(Usuario usuario) throws PersistenciaException;
    
    public boolean existeCorreoExceptoId(String correo, int idUsuario) throws PersistenciaException;
}