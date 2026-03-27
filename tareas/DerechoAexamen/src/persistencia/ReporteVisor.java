package persistencia;

import modelo.Producto;
import modelo.Proveedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ReporteVisor {

    // ── REPORTE GENERAL DE PRODUCTOS ─────────────────────────────

    public void generarReporteGeneral(ArrayList<Producto> lista) {

        JInternalFrame frame = crearVentana("Reporte General de Productos", 900, 500);

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Categoría");
        modelo.addColumn("Unidad");
        modelo.addColumn("P. Compra");
        modelo.addColumn("% Ganancia");
        modelo.addColumn("P. Venta");
        modelo.addColumn("Stock");

        for (Producto p : lista) {
            modelo.addRow(new Object[]{
                    p.getCodigo(),
                    p.getNombre(),
                    p.getCategoria(),
                    p.getUnidadMedida(),
                    String.format("$%.2f", p.getPrecioCompra()),
                    p.getPorcentajeGanancia() + "%",
                    String.format("$%.2f", p.getPrecioVenta()),
                    p.getStock()
            });
        }

        JLabel lblTotal = new JLabel("Total de productos: " + lista.size());
        lblTotal.setFont(new Font("Arial", Font.BOLD, 12));
        lblTotal.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));

        frame.add(new JScrollPane(new JTable(modelo)), BorderLayout.CENTER);
        frame.add(lblTotal, BorderLayout.SOUTH);

        mostrar(frame);
    }

    // ── REPORTE POR CATEGORÍA ─────────────────────────────────────

    public void generarPorCategoria(ArrayList<Producto> lista, String categoria) {

        JInternalFrame frame = crearVentana("Reporte: " + categoria, 800, 450);

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Unidad");
        modelo.addColumn("P. Compra");
        modelo.addColumn("% Ganancia");
        modelo.addColumn("P. Venta");
        modelo.addColumn("Stock");

        int total = 0;
        for (Producto p : lista) {
            if (p.getCategoria().equals(categoria)) {
                modelo.addRow(new Object[]{
                        p.getCodigo(),
                        p.getNombre(),
                        p.getUnidadMedida(),
                        String.format("$%.2f", p.getPrecioCompra()),
                        p.getPorcentajeGanancia() + "%",
                        String.format("$%.2f", p.getPrecioVenta()),
                        p.getStock()
                });
                total++;
            }
        }

        JLabel lblTotal = new JLabel("Productos en " + categoria + ": " + total);
        lblTotal.setFont(new Font("Arial", Font.BOLD, 12));
        lblTotal.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));

        frame.add(new JScrollPane(new JTable(modelo)), BorderLayout.CENTER);
        frame.add(lblTotal, BorderLayout.SOUTH);

        mostrar(frame);
    }

    // ── REPORTE STOCK BAJO ────────────────────────────────────────

    public void generarStockBajo(ArrayList<Producto> lista, int minimo) {

        JInternalFrame frame = crearVentana("Reporte: Productos con Stock Bajo", 750, 400);

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Categoría");
        modelo.addColumn("Stock");
        modelo.addColumn("Estado");

        for (Producto p : lista) {
            String estado = p.getStock() == 0 ? "⛔ Agotado" : "⚠ Stock Bajo";
            modelo.addRow(new Object[]{
                    p.getCodigo(),
                    p.getNombre(),
                    p.getCategoria(),
                    p.getStock(),
                    estado
            });
        }

        JLabel lblAviso = new JLabel("⚠ " + lista.size() + " productos con stock ≤ " + minimo);
        lblAviso.setFont(new Font("Arial", Font.BOLD, 12));
        lblAviso.setForeground(new Color(200, 80, 0));
        lblAviso.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));

        frame.add(new JScrollPane(new JTable(modelo)), BorderLayout.CENTER);
        frame.add(lblAviso, BorderLayout.SOUTH);

        mostrar(frame);
    }

    // ── REPORTE DE PROVEEDORES ────────────────────────────────────

    public void generarReporteProveedores(ArrayList<Proveedor> lista) {

        JInternalFrame frame = crearVentana("Reporte de Proveedores", 850, 400);

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Contacto");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Correo");
        modelo.addColumn("RFC");
        modelo.addColumn("Término Pago");

        for (Proveedor p : lista) {
            modelo.addRow(new Object[]{
                    p.getCodigo(),
                    p.getNombre(),
                    p.getContacto(),
                    p.getTelefono(),
                    p.getCorreo(),
                    p.getRfc(),
                    p.getTerminoPago()
            });
        }

        JLabel lblTotal = new JLabel("Total de proveedores: " + lista.size());
        lblTotal.setFont(new Font("Arial", Font.BOLD, 12));
        lblTotal.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));

        frame.add(new JScrollPane(new JTable(modelo)), BorderLayout.CENTER);
        frame.add(lblTotal, BorderLayout.SOUTH);

        mostrar(frame);
    }

    // ── HELPERS ───────────────────────────────────────────────────

    private JInternalFrame crearVentana(String titulo, int ancho, int alto) {
        JInternalFrame frame = new JInternalFrame(titulo, true, true, true, true);
        frame.setSize(ancho, alto);
        frame.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("  " + titulo, JLabel.LEFT);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBackground(new Color(34, 139, 34));
        lblTitulo.setOpaque(true);
        lblTitulo.setPreferredSize(new Dimension(0, 35));

        frame.add(lblTitulo, BorderLayout.NORTH);

        return frame;
    }

    private void mostrar(JInternalFrame frame) {
        // Buscar el JDesktopPane activo para agregar la ventana
        for (java.awt.Window w : java.awt.Window.getWindows()) {
            if (w instanceof JFrame) {
                JFrame jf = (JFrame) w;
                for (Component c : jf.getContentPane().getComponents()) {
                    if (c instanceof JDesktopPane) {
                        JDesktopPane desktop = (JDesktopPane) c;
                        desktop.add(frame);
                        frame.setVisible(true);
                        return;
                    }
                }
            }
        }
    }
}