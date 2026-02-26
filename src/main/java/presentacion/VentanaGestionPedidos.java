/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import negocio.BOs.IPedidoBO;
import negocio.BOs.PedidoBO;
import negocio.DTOs.PedidoDTO;
import negocio.excepciones.NegocioException;

/**
 *
 * @author Benjamin
 */
public class VentanaGestionPedidos extends JFrame{
    
    private JTable tablaPedidos;
    private JComboBox<String> cmbEstados;
    private JButton btnAplicar;
    
    private final IPedidoBO pedidoBO;
    
    public VentanaGestionPedidos(IPedidoBO pedidoBO){
        this.pedidoBO = pedidoBO;
        
        setTitle("Gestion de pedidos");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        iniciarComponentes();
        
        cargarTablaPedidos();
    }
    
    private void iniciarComponentes(){
        setLayout(new BorderLayout(10, 10)); //
        
        // Tabla 
        String[] columnas ={"ID Pedido", "ID Usuario", "Estado", "Fecha y Hora", "Total"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false; // evita que el empleado edite el texto de la table
            }
        };
        
        tablaPedidos = new JTable(modelo);
        JScrollPane scrollTabla = new JScrollPane(tablaPedidos);
        add(scrollTabla, BorderLayout.CENTER);
        
        // ZONA DERECHA CONTROLES
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
        panelDerecho.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));//margenes del panel
        
        // ETIQUETA
        JLabel lblEstado = new JLabel("Cambiar estado a:");
        lblEstado.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelDerecho.add(lblEstado);
        panelDerecho.add(Box.createVerticalStrut(10));
        
        // ComboBox con los ENUM exactos de tu base de datos
        String[] estados = {"pendiente", "listo", "entregado", "cancelado", "no reclamado"};
        cmbEstados = new JComboBox<>(estados);
        cmbEstados.setMaximumSize(new Dimension(150, 30));
        cmbEstados.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelDerecho.add(cmbEstados);
        panelDerecho.add(Box.createVerticalStrut(20)); // Espacio en blanco
        
        // Botón Aplicar
        btnAplicar = new JButton("Aplicar Cambio");
        btnAplicar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAplicar.setBackground(new Color(0, 102, 204)); // Azul
        btnAplicar.setForeground(Color.WHITE);
        
        // Evento del botón
        btnAplicar.addActionListener(e -> aplicarCambioEstadoAction());
        
        panelDerecho.add(btnAplicar);

        add(panelDerecho, BorderLayout.EAST);
    }
    
    private void aplicarCambioEstadoAction(){
        int filaSeleccionada = tablaPedidos.getSelectedRow();
        
        //1. validar que selecciono un pedido
        if(filaSeleccionada == -1){
            JOptionPane.showMessageDialog(this,
                "Por favor, selecciona un pedido de la tabla primero.",
                "Atencion", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //2. extraer el id del pedido (esta en la 
        int idPedido = Integer.parseInt(tablaPedidos.getValueAt(filaSeleccionada, 0).toString());
        
        //3. Extraer el estado seleccionado del combobox
        String nuevoEstado = cmbEstados.getSelectedItem().toString();
        
        //Confirmacion de seguridad
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Seguro que deseas cambiar el pedido #" + idPedido + "a estado" + nuevoEstado + " ?",
                "Confirmar actualizacion", JOptionPane.YES_NO_OPTION);
        
        if(confirmacion == JOptionPane.YES_OPTION){
            try{
                //llamamos al BO para actualizar en la base de datos
                pedidoBO.actualizarEstado(idPedido, nuevoEstado);
                
                JOptionPane.showMessageDialog(this, "Estado actualizado con exito");
                
                //recargamos la tabla para ver el cambio reflejado actualizado
                cargarTablaPedidos();
            }catch(NegocioException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void cargarTablaPedidos(){
        //obtenemos el modelo de la tabla para poder agregarla filas
        DefaultTableModel modelo = (DefaultTableModel) tablaPedidos.getModel();
        
        //limpiamos la tabla por si ya tenia datos de una busqueda anterior
        modelo.setRowCount(0);
        
        try{
            //1. pedimos la lista al "cerebro" (BO)
            List<PedidoDTO> listaPedidos = pedidoBO.obtenerPedidosOrdenadosPorFecha();
            
            //2. creamos un formateador para que la fecha se vea bien
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            
            //3. Recorremos la lista y agregamos cada pedido como una nueva fila
            for(PedidoDTO pedido : listaPedidos){
                
                //si el usuario es nulo, significa que es un pedido express
                String clienteFila = (pedido.getIdUsuario() != null) ? String.valueOf(pedido.getIdUsuario()) : "Invitado (Express)";
                
                //formateamos la fecha (si no es nula)
                String fechaFila = (pedido.getFecha() != null) ? pedido.getFecha().format(formatoFecha) : "Sin fecha";
                
                // le agregamos el simbolo de dinero al total
                String totalFila = String.format("$%.2f", pedido.getTotal());
                
                //agregamos la fila al modelo
                modelo.addRow(new Object[]{
                    pedido.getIdPedido(),
                    clienteFila,
                    pedido.getEstado(),
                    fechaFila,
                    totalFila
                });
            }
            
            
        }catch(NegocioException ex){
            ex.printStackTrace();
            
            JOptionPane.showMessageDialog(this,
            "Error al cargar los pedidos: " + ex.getMessage(),
            "Error de carga",
            JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
}
