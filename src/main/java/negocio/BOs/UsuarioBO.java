/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.DTOs.RegistroUsuarioDTO;
import negocio.DTOs.UsuarioDTO;
import negocio.excepciones.NegocioException;
import persistencia.DAO.UsuarioDAO;
import persistencia.Conexion.ConexionBD;
import persistencia.DAO.ClienteDAO;
import persistencia.DAO.DireccionDAO;
import persistencia.DAO.TelefonoClienteDAO;
import persistencia.dominio.Cliente;
import persistencia.dominio.Direccion;
import persistencia.dominio.TipoUsuario;
import persistencia.dominio.Usuario;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author munos
 */
public class UsuarioBO implements IUsuarioBO {

    private UsuarioDAO dao;

    public UsuarioBO(ConexionBD conexion) {
        this.dao = new UsuarioDAO(conexion);
    }

    private static UsuarioDTO usuarioActual;

    @Override
    public UsuarioDTO iniciarSesion(String correo, String contrasena) throws NegocioException {

        if (correo == null || correo.isEmpty()) {
            throw new NegocioException("Correo vacío");
        }

        if (contrasena == null || contrasena.isEmpty()) {
            throw new NegocioException("Contraseña vacía");
        }

        try {

            Usuario usuario = dao.autenticar(correo, contrasena);

            if (usuario == null) {
                return null;
            }

            UsuarioDTO dto = new UsuarioDTO(usuario.getIdUsuario(), usuario.getCorreo(), usuario.getTipoUsuario());

            usuarioActual = dto;

            return dto;

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al iniciar sesión", e);
        }
    }

    @Override
    public void registrarClienteCompleto(RegistroUsuarioDTO dto) throws NegocioException {

        try {

            ConexionBD conexion = new ConexionBD();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);

            if (usuarioDAO.existeCorreo(dto.getCorreo())) {
                throw new NegocioException("El correo ya está registrado");
            }

            Usuario usuario = new Usuario(
                    0,
                    dto.getCorreo(),
                    dto.getContrasena(),
                    TipoUsuario.Cliente,
                    new ArrayList<>()
            );

            int idGenerado = usuarioDAO.insertarUsuario(usuario);

            ClienteDAO clienteDAO = new ClienteDAO(conexion);

            Cliente cliente = new Cliente(
                    dto.getNombres(),
                    dto.getApellidoPaterno(),
                    dto.getApellidoMaterno(),
                    dto.getFechaNacimiento(),
                    idGenerado,
                    dto.getCorreo(),
                    dto.getContrasena(),
                    TipoUsuario.Cliente,
                    new ArrayList<>()
            );

            clienteDAO.insertarCliente(cliente);
            DireccionDAO direccionDAO = new DireccionDAO(conexion);
            direccionDAO.insertarDireccion(
                    idGenerado,
                    dto.getCalle(),
                    dto.getNumero(),
                    dto.getColonia()
            );
            TelefonoClienteDAO telefonoDAO = new TelefonoClienteDAO(conexion);
            telefonoDAO.insertarTelefono(
                    idGenerado,
                    dto.getTelefono(),
                    dto.getEtiqueta()
            );
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al registrar cliente", e);
        }
    }

    public static void cerrarSesion() {
        usuarioActual = null;
    }

    public static UsuarioDTO obtenerUsuarioRegistrado() {
        return usuarioActual;
    }

}
