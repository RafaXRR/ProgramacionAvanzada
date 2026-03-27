package vista;

import javax.swing.*;
import java.awt.*;

public class VistaReportes extends JInternalFrame {

    public JButton btnProductosGeneral;
    public JButton btnProductosCategoria;
    public JButton btnStockBajo;
    public JButton btnValorInventario;
    public JButton btnProveedores;
    public JButton btnMasVendidos;

    public JComboBox<String> comboCategoria;

    public VistaReportes() {

        super("Reportes", true, true, true, true);

        setSize(500, 420);
        setLayout(new BorderLayout());

        add(crearContenido(), BorderLayout.CENTER);
    }

    private JPanel crearContenido() {

        JPanel contenido = new JPanel(new GridLayout(1, 2, 10, 0));
        contenido.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        contenido.add(crearSeccionProductos());
        contenido.add(crearSeccionOtros());

        return contenido;
    }

    private JPanel crearSeccionProductos() {

        JPanel panel = new JPanel(new GridLayout(5, 1, 0, 10));
        panel.setBorder(BorderFactory.createTitledBorder("📦 Productos"));

        comboCategoria = new JComboBox<>(new String[]{
                "Despensa Básica", "Lácteos y Huevo", "Bebidas y Líquidos",
                "Botanas y Dulces", "Frutas y Verduras", "Carnes y Salchichonería",
                "Cuidado del Hogar", "Higiene y Cuidado Personal",
                "Alimentos Preparados/Enlatados"
        });

        btnProductosGeneral   = new JButton("📊 Todos los Productos");
        btnProductosCategoria = new JButton("📋 Por Categoría");
        btnStockBajo          = new JButton("⚠ Productos Stock Bajo");
        btnValorInventario    = new JButton("💰 Valor del Inventario");

        estilizarBoton(btnProductosGeneral,   new Color(70, 130, 180));
        estilizarBoton(btnProductosCategoria, new Color(70, 130, 180));
        estilizarBoton(btnStockBajo,          new Color(200, 100, 50));
        estilizarBoton(btnValorInventario,    new Color(50, 150, 50));

        panel.add(comboCategoria);
        panel.add(btnProductosGeneral);
        panel.add(btnProductosCategoria);
        panel.add(btnStockBajo);
        panel.add(btnValorInventario);

        return panel;
    }

    private JPanel crearSeccionOtros() {

        JPanel panel = new JPanel(new GridLayout(5, 1, 0, 10));
        panel.setBorder(BorderFactory.createTitledBorder("🚚 Otros"));

        btnProveedores  = new JButton("🚚 Reporte Proveedores");
        btnMasVendidos  = new JButton("🏆 Productos Más Vendidos");

        estilizarBoton(btnProveedores, new Color(100, 70, 160));
        estilizarBoton(btnMasVendidos, new Color(180, 140, 0));

        panel.add(btnProveedores);
        panel.add(btnMasVendidos);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel("Reportes exportados a Excel (.xlsx)"));

        return panel;
    }

    private void estilizarBoton(JButton btn, Color color) {
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 12));
    }
}