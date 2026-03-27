package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaPuntoVenta extends JInternalFrame {

    public JComboBox<String> comboProductos;
    public JTextField txtCantidad;
    public JLabel lblImagen;
    public JLabel lblPrecio;
    public JLabel lblUnidad;

    public JButton btnAgregar;
    public JButton btnEliminar;
    public JButton btnProcesar;
    public JButton btnLimpiar;

    public JTable tabla;

    public JTextField txtSubtotal;
    public JTextField txtIva;
    public JTextField txtTotal;

    public VistaPuntoVenta() {

        super("Punto de Venta", true, true, true, true);

        setSize(950, 560);
        setLayout(new BorderLayout());

        add(crearSuperior(), BorderLayout.NORTH);
        add(crearTabla(),    BorderLayout.CENTER);
        add(crearInferior(), BorderLayout.SOUTH);
    }

    private JPanel crearSuperior() {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Seleccionar Producto"));

        // Controles
        JPanel controles = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));

        comboProductos = new JComboBox<>();
        comboProductos.setPreferredSize(new Dimension(280, 28));

        txtCantidad = new JTextField("1", 5);

        lblPrecio = new JLabel("Precio: $0.00");
        lblPrecio.setFont(new Font("Arial", Font.BOLD, 13));
        lblPrecio.setForeground(new Color(0, 100, 0));

        lblUnidad = new JLabel("Unidad: -");
        lblUnidad.setFont(new Font("Arial", Font.PLAIN, 12));

        btnAgregar  = new JButton("➕ Agregar");
        btnEliminar = new JButton("➖ Eliminar");
        btnLimpiar  = new JButton("🧹 Limpiar Todo");

        controles.add(new JLabel("Producto:"));
        controles.add(comboProductos);
        controles.add(new JLabel("Cantidad:"));
        controles.add(txtCantidad);
        controles.add(lblPrecio);
        controles.add(lblUnidad);
        controles.add(btnAgregar);
        controles.add(btnEliminar);
        controles.add(btnLimpiar);

        // Imagen
        lblImagen = new JLabel();
        lblImagen.setPreferredSize(new Dimension(100, 100));
        lblImagen.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        lblImagen.setHorizontalAlignment(JLabel.CENTER);

        panel.add(controles,  BorderLayout.CENTER);
        panel.add(lblImagen,  BorderLayout.EAST);

        return panel;
    }

    private JPanel crearTabla() {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };

        modelo.addColumn("Código");
        modelo.addColumn("Descripción");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Unidad");
        modelo.addColumn("P. Unitario");
        modelo.addColumn("Total");

        tabla = new JTable(modelo);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Carrito de Venta"));
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearInferior() {

        JPanel panel = new JPanel(new BorderLayout());

        // Totales
        JPanel totales = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 8));
        totales.setBackground(new Color(245, 245, 245));

        txtSubtotal = new JTextField(10); txtSubtotal.setEditable(false);
        txtIva      = new JTextField(10); txtIva.setEditable(false);
        txtTotal    = new JTextField(10); txtTotal.setEditable(false);

        txtTotal.setFont(new Font("Arial", Font.BOLD, 14));
        txtTotal.setForeground(new Color(0, 100, 0));

        totales.add(new JLabel("Subtotal:"));  totales.add(txtSubtotal);
        totales.add(new JLabel("IVA (16%):"));  totales.add(txtIva);
        totales.add(new JLabel("TOTAL:"));      totales.add(txtTotal);

        // Botón procesar
        btnProcesar = new JButton("💳 PROCESAR PAGO");
        btnProcesar.setBackground(new Color(34, 139, 34));
        btnProcesar.setForeground(Color.WHITE);
        btnProcesar.setFont(new Font("Arial", Font.BOLD, 14));
        btnProcesar.setPreferredSize(new Dimension(180, 40));

        panel.add(totales,     BorderLayout.CENTER);
        panel.add(btnProcesar, BorderLayout.EAST);

        return panel;
    }
}