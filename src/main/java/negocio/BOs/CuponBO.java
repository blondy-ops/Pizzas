/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.BOs;

import java.time.LocalDate;
import negocio.DTOs.CuponDTO;
import negocio.excepciones.NegocioException;
import persistencia.DAO.ICuponDAO;
import persistencia.dominio.Cupon;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Benjamin
 */
public class CuponBO implements ICuponBO{

    private final ICuponDAO cuponDAO;
    
    public CuponBO(ICuponDAO cuponDAO){
        this.cuponDAO = cuponDAO;
    }
    
    @Override
    public CuponDTO validarYObtenerCupon(String codigo) throws NegocioException {
        //1. Se valida que el codigo no este vacio
        if(codigo == null || codigo.trim().isEmpty()){
            throw new NegocioException("Por favor ingrese un codigo valido");
        }
        
        try{
            //2. pedimos al dao que busque en la base de datos
            Cupon cupon = cuponDAO.consultarCuponPorCodigo(codigo); //metodo que se hico en el CuponDAO
            
            // 3. el cupon debe existir
            if(cupon == null){
                throw new NegocioException("El codigo de cupon ingresado no existo");
            }
            
            LocalDate hoy = LocalDate.now();
            
            //4. regla de negocio validar fecha de inicio
            if(cupon.getFechaInicio().isAfter(hoy)){
                throw new NegocioException("Este cupon aun no es valido ya que aun no inicia el periodo seleccionado");
            }
            
            //5. regla validar fecha de fin (si tiene)
            if(cupon.getFechaFin() != null && cupon.getFechaFin().isBefore(hoy)){
                throw new NegocioException("Este cupon ya ha expirado");
            }
            
            //6. validar limite de usos
            if(cupon.getUsosActuales() >= cupon.getUsosMaximos()){
                throw new NegocioException("Este cupon ya alcanzo su limite de usos maximo");
            }
            
            // SI LLEGA AQUI DESPUES DE LAS VALIDACIONES QUIERE DECIR QUE ES VALIDO
            return new CuponDTO(cupon.getIdCupon(),cupon.getCodigo(), cupon.getDescuento());
            
            
        }catch (PersistenciaException ex){
            throw new NegocioException("Error de conexion al validar el cupon.", ex);
        }
    }
    
}
