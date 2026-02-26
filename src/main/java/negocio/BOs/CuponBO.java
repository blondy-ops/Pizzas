/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.time.LocalDate;
import negocio.DTOs.CuponDTO;
import negocio.excepciones.NegocioException;
import persistencia.Conexion.ConexionBD;
import persistencia.DAO.CuponDAO;
import persistencia.DAO.ICuponDAO;
import persistencia.dominio.Cupon;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Benjamin
 */
public class CuponBO implements ICuponBO {

    private final ICuponDAO cuponDAO;

    public CuponBO(ConexionBD conexion) {
        this.cuponDAO = new CuponDAO(conexion);
    }

    @Override
    public CuponDTO validarYObtenerCupon(String codigo)
            throws NegocioException {

        if (codigo == null || codigo.trim().isEmpty()) {
            throw new NegocioException("Ingrese un código válido.");
        }

        try {
            Cupon cupon
                    = cuponDAO.consultarCuponPorCodigo(codigo.trim());

            if (cupon == null) {
                throw new NegocioException("El cupón no existe.");
            }

            LocalDate hoy = LocalDate.now();

            if (cupon.getFechaInicio() != null && cupon.getFechaInicio().isAfter(hoy)) {
                throw new NegocioException("Cupón aún no válido.");
            }

            if (cupon.getFechaFin() != null && cupon.getFechaFin().isBefore(hoy)) {
                throw new NegocioException("Cupón expirado.");
            }

            if (cupon.getUsosActuales() >= cupon.getUsosMaximos()) {
                throw new NegocioException("Cupón sin usos disponibles.");
            }

            return new CuponDTO(
                    cupon.getIdCupon(),
                    cupon.getCodigo(),
                    cupon.getDescuento());

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al validar cupón.", e);
        }
    }
}
