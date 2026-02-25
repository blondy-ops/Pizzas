/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import persistencia.Conexion.ConexionBD;
import persistencia.dominio.DetallesPedido;
import persistencia.dominio.Pedido;
import persistencia.dominio.PedidoProgramado;
import persistencia.excepciones.PersistenciaException;

/**
 *
 * @author Benjamin
 */
public class PedidoDAO implements IPedidoDAO{
    private ConexionBD conexionBD;
    
    public PedidoDAO(ConexionBD conexionBD){
    this.conexionBD = conexionBD;
    }
    @Override
    public int contarPedidosActivosPorCliente(int idUsuario) throws PersistenciaException {
        // usamos el IN para atrapar ambos estados activos
        String sql = "SELECT COUNT(idPedido) AS total FROM Pedidos WHERE idUsuario = ? AND estado IN ('pendiente', 'listo'";
        
        try (Connection conn = conexionBD.crearConexion();
            PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setInt(1, idUsuario);
            
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return rs.getInt("total"); //extraemos el conteo
                }
                return 0; //si no hay resultados tiene 0 pedidos
            }
        }catch(SQLException ex){
            throw new PersistenciaException("Error al contar los pedidos activos en la BD", ex);
        }
        
    }
    
    @Override
    public int insertarPedido(Pedido pedido) throws PersistenciaException {
        //se prepara la consulta sql
        String sql = "ISERT INTO Pedidos (idUsuario, notasEntrega, fecha, total) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = conexionBD.crearConexion();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
            //1. idUsuario puede ser nulo si es express
            //se asume que si no hay usuario, el objeto tiene un ID de 0 o es null
            if(pedido.getIdUsuario() != null && pedido.getIdUsuario() > 0){
                ps.setInt(1, pedido.getIdUsuario());
            }else{
                ps.setNull(1, Types.INTEGER); //se manda null a la base de datos 
            }
            
            //2. notas entrega
            ps.setString(2, pedido.getNotasEntrega());
            
            //3. fecha (Capturamos la fecha y hora exacta de este momento)
            ps.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
            
            //4. total
            ps.setDouble(4, pedido.getTotal());
            
            //se ejecuta el insert
            ps.executeUpdate();
            
            // se recupera el id magico
            try(ResultSet rs = ps.getGeneratedKeys()){
                if(rs.next()){
                    return rs.getInt(1); //se regresa la primer columna (el id generado)
                }else{
                    throw new PersistenciaException("No se pudo obtener el ID del pedido generado");
                }
            }
        } catch(SQLException ex){
            throw new PersistenciaException("Error al insertar el pedido en la BD");
        }
    }
    
    @Override
    public void agregarDetallePedido(DetallesPedido detallePedido) throws PersistenciaException {
        String comandoSQL = """
                          INSERT INTO DetallesPedidos(idPedido,idPizza,cantidad,notasPreparacion,precioUnitario)
                          VALUES(?,?,?,?,?)""";

        try (Connection con = conexionBD.crearConexion(); PreparedStatement ps = con.prepareStatement(comandoSQL)) {
            ps.setInt(1, detallePedido.getIdPedido());
            ps.setInt(2, detallePedido.getIdPizza());
            ps.setInt(3, detallePedido.getCantidad());
            if (detallePedido.getNotasPreparacion() != null) {
                ps.setString(4, detallePedido.getNotasPreparacion());
            } else {
                ps.setNull(4, java.sql.Types.VARCHAR);
            }
            ps.setDouble(5, detallePedido.getPrecioUnitario());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaException("Error al agregar detalle pedido", e);
        }
    }

    @Override
    public void agregarPedidoProgramado(PedidoProgramado pedidoProgramado) throws PersistenciaException {
        //preparamos la consulta sql
        String sql = "INSERT INTO PedidosProgramados (idPedido, idCupon) VALUES (?, ?)";
        
        try(Connection con = conexionBD.crearConexion();
                PreparedStatement ps = con.prepareStatement(sql)){
            //1. asignamos el idPedido 
            ps.setInt(1, pedidoProgramado.getIdPedido());
            
            //2. asignamos el idCupon (puede ser nulo)
            if(pedidoProgramado.getIdCupon() != null && pedidoProgramado.getIdCupon() > 0){
                ps.setInt(2, pedidoProgramado.getIdCupon());
            }else{
                ps.setNull(2, java.sql.Types.INTEGER); //se manda null al mysql si no hay cupon
            }
            
            //se ejecuta la insercion
            ps.executeUpdate();
        }catch(SQLException e){
            throw new PersistenciaException("Error al agregar el pedido programado a la BD", e);
        }
    }
    
    
    
}
