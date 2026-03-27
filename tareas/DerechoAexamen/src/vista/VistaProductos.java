package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaProductos extends JInternalFrame {

    public JTextField txtCodigo;
    public JTextField txtNombre;
    public JTextField txtPrecioCompra;
    public JTextField txtPorcentaje;
    public JTextField txtPrecioVenta;
    public JTextField txtStock;

    public JComboBox<String> comboCategoria;
    public JComboBox<String> comboUnidad;

    public JLabel lblImagen;
    public JButton btnImagen;

    public JButton btnGuardar;
    public JButton btnLimpiar;
    public JButton btnEliminar;
    public JButton btnReporteGeneral;
    public JButton btnReporteCategoria;

    public JTable tabla;

    public JTextField txtBuscar;
    public JButton btnBuscar;

    public VistaProductos() {

        super("Productos", true, true, true, true);

        setSize(1000, 600);
        setLayout(new BorderLayout());

        add(crearFormulario(), BorderLayout.WEST);
        add(crearTabla(),      BorderLayout.CENTER);
    }

    private JPanel crearFormulario() {

        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));
        form.setPreferredSize(new Dimension(280, 0));

        GridBagConstraints c = new GridBagConstraints();
        c.insets  = new Insets(4, 5, 4, 5);
        c.fill    = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;

        txtCodigo      = new JTextField();
        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new Color(230, 230, 230));

        txtNombre        = new JTextField();
        txtPrecioCompra  = new JTextField();
        txtPorcentaje    = new JTextField();

        txtPrecioVenta   = new JTextField();
        txtPrecioVenta.setEditable(false);
        txtPrecioVenta.setBackground(new Color(230, 230, 230));

        txtStock = new JTextField();

        comboCategoria = new JComboBox<>(new String[]{
                "Despensa Básica", "Lácteos y Huevo", "Bebidas y Líquidos",
                "Botanas y Dulces", "Frutas y Verduras", "Carnes y Salchichonería",
                "Cuidado del Hogar", "Higiene y Cuidado Personal",
                "Alimentos Preparados/Enlatados"
        });

        comboUnidad = new JComboBox<>();

        // Imagen
        lblImagen = new JLabel();
        lblImagen.setPreferredSize(new Dimension(120, 120));
        lblImagen.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        lblImagen.setHorizontalAlignment(JLabel.CENTER);

        btnImagen = new JButton("Seleccionar Imagen");

        btnGuardar         = new JButton("💾 Guardar");
        btnLimpiar         = new JButton("🧹 Limpiar");
        btnEliminar        = new JButton("🗑 Eliminar");
        btnReporteGeneral  = new JButton("📊 Reporte General");
        btnReporteCategoria = new JButton("📋 Reporte Categoría");

        // ── AGREGAR COMPONENTES ───────────────────────────────────
        int fila = 0;

        agregar(form, c, new JLabel("Código:"),         0, fila);
        agregar(form, c, txtCodigo,                     1, fila++);

        agregar(form, c, new JLabel("Nombre:"),         0, fila);
        agregar(form, c, txtNombre,                     1, fila++);

        agregar(form, c, new JLabel("Categoría:"),      0, fila);
        agregar(form, c, comboCategoria,                1, fila++);

        agregar(form, c, new JLabel("Unidad:"),         0, fila);
        agregar(form, c, comboUnidad,                   1, fila++);

        agregar(form, c, new JLabel("Precio Compra:"),  0, fila);
        agregar(form, c, txtPrecioCompra,               1, fila++);

        agregar(form, c, new JLabel("% Ganancia:"),     0, fila);
        agregar(form, c, txtPorcentaje,                 1, fila++);

        agregar(form, c, new JLabel("Precio Venta:"),   0, fila);
        agregar(form, c, txtPrecioVenta,                1, fila++);

        agregar(form, c, new JLabel("Stock:"),          0, fila);
        agregar(form, c, txtStock,                      1, fila++);

        // Imagen centrada
        c.gridx = 0; c.gridy = fila; c.gridwidth = 2;
        form.add(lblImagen, c);
        fila++;

        c.gridx = 0; c.gridy = fila; c.gridwidth = 2;
        form.add(btnImagen, c);
        fila++;

        c.gridwidth = 1;
        agregar(form, c, btnGuardar,  0, fila);
        agregar(form, c, btnLimpiar,  1, fila++);

        agregar(form, c, btnEliminar, 0, fila);
        fila++;

        c.gridx = 0; c.gridy = fila; c.gridwidth = 2;
        form.add(btnReporteGeneral, c);
        fila++;

        c.gridx = 0; c.gridy = fila; c.gridwidth = 2;
        form.add(btnReporteCategoria, c);

        return form;
    }

    private JPanel crearTabla() {

        // Barra de búsqueda
        JPanel barraBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtBuscar = new JTextField(15);
        btnBuscar = new JButton("🔍 Buscar");
        barraBusqueda.add(new JLabel("Buscar:"));
        barraBusqueda.add(txtBuscar);
        barraBusqueda.add(btnBuscar);

        // Tabla
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };

        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Categoría");
        modelo.addColumn("Unidad");
        modelo.addColumn("P. Compra");
        modelo.addColumn("% Gan.");
        modelo.addColumn("P. Venta");
        modelo.addColumn("Stock");

        tabla = new JTable(modelo);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.getTableHeader().setReorderingAllowed(false);

        JScrollPane scroll = new JScrollPane(tabla);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Lista de Productos"));
        panel.add(barraBusqueda, BorderLayout.NORTH);
        panel.add(scroll,        BorderLayout.CENTER);

        return panel;
    }

    // Método auxiliar para agregar componentes al GridBag
    private void agregar(JPanel panel, GridBagConstraints c,
                         Component comp, int x, int y) {
        c.gridx    = x;
        c.gridy    = y;
        c.gridwidth = 1;
        panel.add(comp, c);
    }
}