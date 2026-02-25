/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import negocio.BOs.CarritoBO;
import negocio.BOs.ICarritoBO;
import negocio.BOs.IPizzasBO;
import negocio.BOs.PizzasBO;
import negocio.DTOs.CarritoDTO;
import negocio.DTOs.PizzaDTO;
import negocio.excepciones.NegocioException;
import persistencia.Conexion.ConexionBD;
import persistencia.DAO.IPizzaDAO;
import persistencia.DAO.PizzasDAO;
import persistencia.dominio.Pedido;

/**
 *
 * @author jorge
 */
public class InterfazPedidosProgramados extends JFrame {

    private JPanel panelLista;
    private JLabel lblTotal;
    private ICarritoBO carritoBO;
    private IPizzasBO pizzasBO;

    public InterfazPedidosProgramados() throws NegocioException {

        ConexionBD conn = new ConexionBD();
        IPizzaDAO pizzasDAO = new PizzasDAO(conn);
        pizzasBO = new PizzasBO(pizzasDAO);
        carritoBO = new CarritoBO();

        setTitle("Menu Pizzas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(950, 650);
        setLayout(new BorderLayout());
        interfazFrame();
        setVisible(true);

    }

    public void interfazFrame() throws NegocioException {

        //Creamos el panel Principal y le asignamos un borderlatout
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        //lo agrego al frame 
        add(panelPrincipal);

        //Creo un label con el titulo
        JLabel titulo = new JLabel("PIZZAS");
        //Le agrego una letra y un tamaño 
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        //le agregamos un border al titulo 
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
        //Agregamos el titulo al panel Principal 
        panelPrincipal.add(titulo, BorderLayout.NORTH);

        int numpiz;

        try {
            numpiz = pizzasBO.ContarPizzasBO();
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            numpiz = 0;
        }

        int filas = (int) Math.ceil(numpiz / 3.0);

        //creamos un panel central y tendra un numero de filas que depende de cuantos registros hay 
        JPanel panelCentro = new JPanel(new GridLayout(filas, 3, 20, 20));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //creamos un scroll
        JScrollPane scroll = new JScrollPane(panelCentro);

        // le ponemos velocidad del scroll porque el default esta muy lento 
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        // Agregamos el scroll al centro
        panelPrincipal.add(scroll, BorderLayout.CENTER);

        //creamos el manel donde se generara el ticket 
        JPanel contenedorDerecha = new JPanel(new BorderLayout());
        contenedorDerecha.setPreferredSize(new Dimension(320, 0));
        contenedorDerecha.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.add(contenedorDerecha, BorderLayout.EAST);

        JPanel panelDerecha = new JPanel();
        panelDerecha.setLayout(new BoxLayout(panelDerecha, BoxLayout.Y_AXIS));
        panelDerecha.setBackground(new Color(240, 240, 240));
        panelDerecha.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        contenedorDerecha.add(panelDerecha);

        JLabel lblTotalTitulo = new JLabel("Total");
        lblTotalTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTotalTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblTotal = new JLabel("$0");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 35));
        lblTotal.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelLista = new JPanel();
        panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));

        JScrollPane scrollTicket = new JScrollPane(panelLista);
        scrollTicket.getVerticalScrollBar().setUnitIncrement(16);

        JButton btnPagar = new JButton("Pagar");
        btnPagar.setBackground(new Color(40, 40, 40));
        btnPagar.setForeground(Color.white);
        btnPagar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPagar.setMaximumSize(new Dimension(200, 40));

        panelDerecha.add(lblTotalTitulo);
        panelDerecha.add(Box.createRigidArea(new Dimension(0, 15)));
        panelDerecha.add(lblTotal);
        panelDerecha.add(Box.createRigidArea(new Dimension(0, 20)));
        panelDerecha.add(scrollTicket);
        panelDerecha.add(Box.createVerticalGlue());
        panelDerecha.add(btnPagar);

        btnPagar.addActionListener(e -> {
            VentanaRealizarPago ventana = new VentanaRealizarPago(carritoBO);
            ventana.setVisible(true);
        });

        //ocupo un bo y dto 
        List<PizzaDTO> pizzas = new ArrayList<>();
        try {
            pizzas = pizzasBO.obtenerPizzasDisponibles();
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(this, "No se pudo obtener la listade pizza");
        }

        for (PizzaDTO x : pizzas) {
            String rutaImg = "/imagenes/" + x.getImagen();
            panelCentro.add(CrearPizza(
                    x.getIdPizza(),
                    x.getNombre(),
                    x.getPrecio(),
                    x.getTamano().toString(),
                    rutaImg
            ));
        }
    }

    public void agregegarCarrito(int idPizza, String nombrePizza, String tamano, double precioUnitario) {
        String cantidadStrin = JOptionPane.showInputDialog(this, "Cuantas pizzas desea agregar?");

        if (cantidadStrin == null) {
            return;
        }

        int cantidad;

        try {
            cantidad = Integer.parseInt(cantidadStrin);
            if (cantidad <= 0) {
                throw new NumberFormatException("Cantidad invalida 2");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cantidad invalida");
            return;
        }

        double subtotal = precioUnitario * cantidad;
        double total = 0;

        CarritoDTO carritoDTO = new CarritoDTO(idPizza,nombrePizza,tamano,cantidad,precioUnitario,subtotal);
        System.out.println("ID PIZZA GUARDADO: " + carritoDTO.getIdPizza());
        try {
            carritoBO.agregarCarrito(carritoDTO);
            total = carritoBO.calcularTotal();
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(this, "No se pudo agregar el producto al carrito.");
        }

        JPanel panelItem = new JPanel();
        panelItem.setLayout(new BorderLayout());
        panelItem.setMaximumSize(new Dimension(280, 60));

        JLabel lblItem = new JLabel(
                "<html> - " + nombrePizza
                + " | Tamaño: " + tamano
                + " | Cant: " + cantidad
                + "<br> $" + precioUnitario
                + " c/u | Subtotal: $" + subtotal
                + "</html>"
        );

        JButton btnCancelar = new JButton("X");
        btnCancelar.setBackground(Color.RED);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setPreferredSize(new Dimension(45, 30));

        btnCancelar.addActionListener(e -> {
            try {
                carritoBO.aliminarProduco(carritoDTO);
                panelLista.remove(panelItem);

                double nuevoTotal = carritoBO.calcularTotal();
                lblTotal.setText("$" + nuevoTotal + " pesos");

                panelLista.revalidate();
                panelLista.repaint();
            } catch (NegocioException ex) {
                JOptionPane.showMessageDialog(this, "No se pudo cancelar el producto");
            }
        });

        panelItem.add(lblItem, BorderLayout.CENTER);
        panelItem.add(btnCancelar, BorderLayout.EAST);

        panelLista.add(panelItem);
        panelLista.add(Box.createRigidArea(new Dimension(0, 5)));

        lblTotal.setText("$" + total + " pesos");

        panelLista.revalidate();
        panelLista.repaint();

    }

    public JPanel CrearPizza(int idPizza, String nombre, double Precio, String tamano, String rutaImg) {
        //creamos un panel que contendra  todo 
        JPanel panel = new JPanel();
        // le aagregamos un border layout 
        panel.setLayout(new BorderLayout());
        // le agregamos un borde al panel 
        panel.setBorder(BorderFactory.createLineBorder(Color.black));

        //creamos un label donde se mostrara el nombre 
        JLabel Lblnombre = new JLabel(nombre);
        // le ponemos una fuente, tamaño y tipo de letra 
        Lblnombre.setFont(new Font("Arial", Font.BOLD, 14));
        //agregamos el panel al norte
        panel.add(Lblnombre, BorderLayout.NORTH);

        //creamos una panel que tendra la imagen, el tamaño y el precio 
        JPanel panelCentro = new JPanel();
        //le agregamos un boxlayout al panel centro 
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        // le ponemos un borde al panel centro 
        panelCentro.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        URL url = getClass().getResource(rutaImg);

        JLabel Lblimagen;

        if (url != null) {
            ImageIcon icono = new ImageIcon(url);
            Image img = icono.getImage().getScaledInstance(120, 100, Image.SCALE_SMOOTH);
            Lblimagen = new JLabel(new ImageIcon(img));
        } else {
            System.out.println("No se encontró la imagen: " + rutaImg);
            Lblimagen = new JLabel("Sin imagen");
        }
        //alineamos la imagen 
        Lblimagen.setAlignmentX(Component.CENTER_ALIGNMENT);

        //creamos el label del tamaño
        JLabel lblTamano = new JLabel("Tamaño: " + tamano);
        //lo alineo horizontalmente 
        lblTamano.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel Lblprecio = new JLabel("Precio: $" + Precio);
        Lblprecio.setAlignmentX(Component.CENTER_ALIGNMENT);

        //agregamos los componentes creados al centro 
        panelCentro.add(Lblimagen);
        panelCentro.add(lblTamano);
        panelCentro.add(Lblprecio);
        panel.add(panelCentro, BorderLayout.CENTER);

        //creamos el boton de agregar 
        JButton btnagregar = new JButton("AGREGAR");
        //le agregamos un fondo rojo 
        btnagregar.setBackground(Color.red);
        //agregamos un color de letra blanco 
        btnagregar.setForeground(Color.white);

        //agregamos el boton al panel principal 
        panel.add(btnagregar, BorderLayout.SOUTH);

        btnagregar.addActionListener(e -> {
            agregegarCarrito(idPizza, nombre, tamano, Precio);
        });
        return panel;
    }
}
