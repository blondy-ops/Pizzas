/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.util.ArrayList;
import negocio.DTOs.RegistroUsuarioDTO;
import negocio.DTOs.TelefonoDTO;
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

        if (correo == null || correo.trim().isEmpty()) {
            throw new NegocioException("Correo vacío");
        }

        if (!correo.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new NegocioException("Formato de correo inválido");
        }

        if (contrasena == null || contrasena.trim().isEmpty()) {
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
            if (dto == null) {
                throw new NegocioException("Datos inválidos");
            }
            if (dto.getNombres() == null || dto.getNombres().isEmpty()) {
                throw new NegocioException("El nombre es obligatorio");
            }

            if (dto.getCorreo() == null || dto.getCorreo().isEmpty()) {
                throw new NegocioException("El correo es obligatorio");
            }

            if (dto.getContrasena() == null || dto.getContrasena().isEmpty()) {
                throw new NegocioException("La contraseña es obligatoria");
            }
            if (!dto.getCorreo().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                throw new NegocioException("Formato de correo inválido");
            }
            if (usuarioDAO.existeCorreo(dto.getCorreo())) {
                throw new NegocioException("El correo ya está registrado");
            }
            if (!dto.getTelefono().matches("\\d{10}")) {
                throw new NegocioException("El teléfono debe tener 10 dígitos");
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

    public static UsuarioDTO obtenerUsuarioRegistrado() {
        return usuarioActual;
    }

    @Override
    public void actualizarClienteCompleto(RegistroUsuarioDTO dto)
            throws NegocioException {

        try {

            if (dto == null) {
                throw new NegocioException("Datos inválidos");
            }

            if (dto.getIdUsuario() <= 0) {
                throw new NegocioException("Usuario inválido");
            }

            if (dto.getCorreo() == null || dto.getCorreo().trim().isEmpty()) {
                throw new NegocioException("El correo no puede estar vacío");
            }

            if (dto.getContrasena() == null || dto.getContrasena().trim().isEmpty()) {
                throw new NegocioException("La contraseña no puede estar vacía");
            }

            ConexionBD conexion = new ConexionBD();

            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);

            if (usuarioDAO.existeCorreoExceptoId(
                    dto.getCorreo(), dto.getIdUsuario())) {

                throw new NegocioException(
                        "El correo ya está en uso por otro usuario");
            }

            ClienteDAO clienteDAO = new ClienteDAO(conexion);
            DireccionDAO direccionDAO = new DireccionDAO(conexion);
            TelefonoClienteDAO telefonoDAO = new TelefonoClienteDAO(conexion);

            Usuario usuario = new Usuario(
                    dto.getIdUsuario(),
                    dto.getCorreo(),
                    dto.getContrasena(),
                    TipoUsuario.Cliente,
                    new ArrayList<Direccion>()
            );

            usuarioDAO.actualizarUsuario(usuario);

            Cliente cliente = new Cliente(
                    dto.getNombres(),
                    dto.getApellidoPaterno(),
                    dto.getApellidoMaterno(),
                    dto.getFechaNacimiento(),
                    dto.getIdUsuario(),
                    dto.getCorreo(),
                    dto.getContrasena(),
                    TipoUsuario.Cliente,
                    new ArrayList<Direccion>()
            );

            clienteDAO.actualizarCliente(cliente);

            direccionDAO.actualizarDireccion(
                    dto.getIdUsuario(),
                    dto.getCalle(),
                    dto.getNumero(),
                    dto.getColonia()
            );

            if (dto.getTelefonos() != null) {

                if (dto.getTelefonos().size() > 3) {
                    throw new NegocioException("Máximo 3 teléfonos permitidos");
                }

                for (TelefonoDTO tel : dto.getTelefonos()) {

                    if (tel.getTelefono() == null
                            || !tel.getTelefono().matches("\\d{10}")) {

                        throw new NegocioException(
                                "Teléfono inválido: " + tel.getTelefono());
                    }

                    if (tel.getIdTelefono() > 0) {
                        telefonoDAO.actualizarTelefono(
                                tel.getIdTelefono(),
                                tel.getTelefono(),
                                tel.getEtiqueta()
                        );
                    } else {
                        telefonoDAO.insertarTelefono(
                                dto.getIdUsuario(),
                                tel.getTelefono(),
                                tel.getEtiqueta()
                        );
                    }
                }
            }

        } catch (PersistenciaException e) {
            throw new NegocioException(
                    "Error al actualizar cliente", e);
        }
    }
}
