/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.BOs;

import negocio.DTOs.RegistroUsuarioDTO;
import negocio.DTOs.UsuarioDTO;
import negocio.excepciones.NegocioException;

/**
 *
 * @author jorge
 */
public interface IUsuarioBO {

    public UsuarioDTO iniciarSesion(String correo, String contrasena) throws NegocioException;

    public void registrarClienteCompleto(RegistroUsuarioDTO dto) throws NegocioException;
}
