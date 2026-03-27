package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaInventario extends JInternalFrame {

    public JTextField txtBuscar;
    public JComboBox<String> comboCategoria;
    public JTextField txtStockMinimo;

    public JButton btnBuscar;
    public JButton btnTodos;
    public JButton btnStockBajo;
    public JButton btnReporte;

    public JTable tabla;
    public JLabel lblTotalProductos;
    public JLabel lblValorInventario;

    public VistaInventario() {

        super("Inventario", true, true, true, true);

        setSize(900, 550);
        setLayout(new BorderLayout());

        add(crearFiltros(), BorderLayout.NORTH);
        add(crearTabla(),   BorderLayout.CENTER);
        add(crearPie(),     BorderLayout.SOUTH);
    }

    private JPanel crearFiltros() {

        JPanel filtros = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 8));
        filtros.setBorder(BorderFactory.createTitledBorder("Filtros"));

        txtBuscar = new JTextField(15);

        comboCategoria = new JComboBox<>(new String[]{
                "Todas", "Despensa Básica", "Lácteos y Huevo",
                "Bebidas y Líquidos", "Botanas y Dulces", "Frutas y Verduras",
                "Carnes y Salchichonería", "Cuidado del Hogar",
                "Higiene y Cuidado Personal", "Alimentos Preparados/Enlatados"
        });

        txtStockMinimo = new JTextField("5", 4);

        btnBuscar   = new JButton("🔍 Buscar");
        btnTodos    = new JButton("📋 Todos");
        btnStockBajo = new JButton("⚠ Stock Bajo");
        btnReporte  = new JButton("📊 Reporte Excel");

        filtros.add(new JLabel("Buscar:"));
        filtros.add(txtBuscar);
        filtros.add(new JLabel("Categoría:"));
        filtros.add(comboCategoria);
        filtros.add(new JLabel("Stock mínimo:"));
        filtros.add(txtStockMinimo);
        filtros.add(btnBuscar);
        filtros.add(btnTodos);
        filtros.add(btnStockBajo);
        filtros.add(btnReporte);

        return filtros;
    }

    private JPanel crearTabla() {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };

        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Categoría");
        modelo.addColumn("Unidad");
        modelo.addColumn("P. Compra");
        modelo.addColumn("P. Venta");
        modelo.addColumn("Stock");
        modelo.addColumn("Estado");

        tabla = new JTable(modelo);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.getTableHeader().setReorderingAllowed(false);

        JScrollPane scroll = new JScrollPane(tabla);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Productos en Inventario"));
        panel.add(scroll, BorderLayout.CENTER);

        return panel;
    }

    private JPanel crearPie() {

        JPanel pie = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 5));
        pie.setBackground(new Color(245, 245, 245));

        lblTotalProductos  = new JLabel("Total productos: 0");
        lblValorInventario = new JLabel("Valor inventario: $0.00");

        lblTotalProductos.setFont(new Font("Arial", Font.BOLD, 12));
        lblValorInventario.setFont(new Font("Arial", Font.BOLD, 12));
        lblValorInventario.setForeground(new Color(0, 128, 0));

        pie.add(lblTotalProductos);
        pie.add(new JSeparator(JSeparator.VERTICAL));
        pie.add(lblValorInventario);

        return pie;
    }
}