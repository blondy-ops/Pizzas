/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import fabricas.BO.FabricaBOs;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import negocio.BOs.ICarritoBO;
import negocio.BOs.ICuponBO;
import negocio.BOs.IUsuarioBO;
import negocio.BOs.UsuarioBO;
import negocio.DTOs.CarritoDTO;
import negocio.DTOs.CuponDTO;
import negocio.DTOs.UsuarioDTO;
import negocio.excepciones.NegocioException;
import persistencia.Conexion.ConexionBD;
import persistencia.dominio.Pedido;

/**
 *
 * @author Benjamin
 */
public class VentanaRealizarPago extends JFrame {

    //referencia actual al pedido que se esta procesando
    private ICarritoBO carritoBO;
    private IUsuarioBO usuario;

    //componentes que se usaran para la interfaz
    private JTable tablaResumen;
    private JTextField txtCupon;
    private JLabel lblTotalMonto;
    private JButton btnPagar;

    /**
     * Creates new form VentanaRealizarPago
     */
    public VentanaRealizarPago(ICarritoBO carritoBO) {
        ConexionBD conn = new ConexionBD();
        this.carritoBO = carritoBO;
        usuario=new UsuarioBO(conn);

        //definir tamaño y comportamiento al cerrarse
        setTitle("Realizar Pago");//titulo
        setSize(900, 600); //tamaño
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //para cerrar solo esta ventana no la app

        //llamamos al metodo para iniciar componenets
        iniciarComponentes();

        //METODOS QUE SE IMPLEMENTAN DESPUES PARA QUE FUNCIONE
        cargarDatosDelPedidoEnLaTabla();
        calcularYMostrarTotal();
    }

    private void iniciarComponentes() {
        //se pone el layout principal de la ventana para acomodarla
        setLayout(new BorderLayout());

        tablaResumen = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaResumen);
        add(scrollPane, BorderLayout.CENTER);

        // ZONA SUR
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));

        //Fila 1: Cupon (Usamos flowlayout que acomoda de izquierda a derecha por defecto
        JPanel panelCupon = new JPanel();
        panelCupon.add(new JLabel("Codigo de cupon:"));
        txtCupon = new JTextField(10); //campo de texto de 10 columnas de ancho
        panelCupon.add(txtCupon);

        //BOTON CUPON-------------------------------------------------------------------------
        JButton btnAplicarCupon = new JButton("Aplicar");

        //agregamos el evento
        btnAplicarCupon.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarCuponAction(); // Llamamos a un método separado para tenerlo ordenado
            }
        });

        panelCupon.add(btnAplicarCupon);

        // FIla 2 total
        JPanel panelTotal = new JPanel();
        //se hace la fuente del total mas grande y en negrita para que resalte
        Font fuenteTotal = new Font("Arial", Font.BOLD, 18);
        JLabel lblTextoTotal = new JLabel("Total a pagar: $");
        lblTextoTotal.setFont(fuenteTotal);

        lblTotalMonto = new JLabel("0.00");
        lblTotalMonto.setFont(fuenteTotal);

        panelTotal.add(lblTextoTotal);
        panelTotal.add(lblTotalMonto);

        //Fila 3 Boton de pagar
        JPanel panelBotonPagar = new JPanel();
        btnPagar = new JButton("PAGAR ORDEN");
        btnPagar.setFont(new Font("Arial", Font.BOLD, 14));
        btnPagar.setBackground(new Color(34, 139, 34)); // Color verde oscuro
        btnPagar.setForeground(Color.WHITE); // Texto blanco

        btnPagar.addActionListener(e -> {
            UsuarioDTO usDTO=UsuarioBO.obtenerUsuarioRegistrado();
            if (usDTO == null) {
                System.out.println("Pedido expres");
            } else {
                System.out.println("Es pedido programado");
                UsuarioDTO us=UsuarioBO.obtenerUsuarioRegistrado();
                System.out.println(us.getIdUsuario());
            }
            Pedido p1 = new Pedido();
            new VentanaEstadoPedido(p1);
            dispose();
        });
        panelBotonPagar.add(btnPagar);

        //se aplica las 3 filas en el panel inferior
        panelInferior.add(panelCupon);
        panelInferior.add(panelTotal);
        panelInferior.add(panelBotonPagar);

        //agregamos el panel inferior al sur de la ventana
        add(panelInferior, BorderLayout.SOUTH);

    }

    private void aplicarCuponAction() {
        // 1. Extraemos el texto y le quitamos espacios en blanco extra
        String codigoIngresado = txtCupon.getText().trim();

        // Validamos que no esté vacío
        if (codigoIngresado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un código de cupón.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            //1. Llamamos al cerebro (BO)
            ICuponBO cuponBO = FabricaBOs.obtenerCuponBO(); //PONERLO BIEN EN LA FABRICA PARA QUE SIRVA

            //si el cupon es malo tira la excepcion el BO y la cacha el catch
            //si el cupon es bueno nos regresa el DTO con el descuento
            CuponDTO cuponValido = cuponBO.validarYObtenerCupon(codigoIngresado);

            //2. Calculamos el descuento 
            double descuentoPorcentaje = cuponValido.getDescuento() / 100.0;

            double cantidadDescontada = carritoBO.calcularTotal() * descuentoPorcentaje;
            double nuevoTotal = carritoBO.calcularTotal() - cantidadDescontada;

            //se le asigna el id del cupon usado al pedido
            //pedidoActual.setIdCupon(cuponValido.getIdCupon()); (no)
            calcularYMostrarTotal();

            JOptionPane.showMessageDialog(this,
                    "¡Cupón aplicado!\nSe descontaron: $" + String.format("%.2f", cantidadDescontada),
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);

            txtCupon.setEditable(false);

        } catch (Exception ex) {
            // MOSTRAMOS ALERTA DE ERROR
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Cupón Inválido", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarDatosDelPedidoEnLaTabla() {
        // 1. Definimos los nombres de las columnas
        String[] nombresColumnas = {"Pizza", "Cantidad", "Precio Unitario", "Subtotal"};

        // 2. Creamos el modelo (el 0 significa que inicia sin filas)
        DefaultTableModel modeloTabla = new DefaultTableModel(nombresColumnas, 0);

        // 3. Le asignamos este modelo a nuestra tabla visual
        tablaResumen.setModel(modeloTabla);

        // 4. Si el pedido existe y tiene detalles, los agregamos
        // (Asegúrate de tener el método ge
        List<CarritoDTO> pizzas;
        try {
            pizzas = carritoBO.obtenerCarrito();
            for (CarritoDTO x : pizzas) {

                Object[] fila = {
                    x.getNombre(),
                    x.getCantidad(),
                    String.format("$%.2f", x.getPrecioUnitario()),
                    String.format("$%.2f", x.getSubtotal())
                };
                modeloTabla.addRow(fila);
            }

        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(this, "Error: No se pudo obtener el carrito.");
        }

    }

    private void calcularYMostrarTotal() {

        try {
            // 2. Extraemos el total (que es double)
            double total = carritoBO.calcularTotal();

            // 3. Lo convertimos a texto con formato de 2 decimales
            String totalTexto = String.format("%.2f", total);

            // 4. Se lo pasamos a la etiqueta
            lblTotalMonto.setText(totalTexto);
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(this, "Error: Error al calcular el total");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 909, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
