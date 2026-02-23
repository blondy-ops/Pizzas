/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio.BOs;

import negocio.excepciones.NegocioException;
import negocio.DTOs.CuponDTO;

/**
 *
 * @author Benjamin
 */
public interface ICuponBO {
    CuponDTO validarYObtenerCupon(String codigo) throws NegocioException;
}
