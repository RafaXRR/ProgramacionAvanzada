package controlador;
import persistencia.ReporteVisor;

import modelo.Inventario;
import modelo.Producto;

import vista.VistaInventario;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ControladorInventario {

    private VistaInventario vista;
    private Inventario inventario;
    private ReporteVisor reporte;

    public ControladorInventario(VistaInventario vista, Inventario inventario) {

        this.vista      = vista;
        this.inventario = inventario;
        this.reporte    = new ReporteVisor();

        cargarTabla(inventario.getLista());
        eventos();
    }

    private void eventos() {
        vista.btnBuscar.addActionListener(e    -> buscar());
        vista.btnTodos.addActionListener(e     -> cargarTabla(inventario.getLista()));
        vista.btnStockBajo.addActionListener(e -> mostrarStockBajo());
        vista.btnReporte.addActionListener(e   -> generarReporte());
    }

    private void cargarTabla(ArrayList<Producto> lista) {
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0);

        double valorTotal = 0;

        for (Producto p : lista) {
            String estado = p.getStock() == 0 ? "⛔ Agotado"
                          : p.getStock() <= 5  ? "⚠ Stock Bajo"
                          : "✅ Disponible";

            modelo.addRow(new Object[]{
                    p.getCodigo(),
                    p.getNombre(),
                    p.getCategoria(),
                    p.getUnidadMedida(),
                    String.format("$%.2f", p.getPrecioCompra()),
                    String.format("$%.2f", p.getPrecioVenta()),
                    p.getStock(),
                    estado
            });

            valorTotal += p.getPrecioCompra() * p.getStock();
        }

        vista.lblTotalProductos.setText("Total productos: " + lista.size());
        vista.lblValorInventario.setText(String.format("Valor inventario: $%.2f", valorTotal));
    }

    private void buscar() {
        String texto     = vista.txtBuscar.getText().trim().toLowerCase();
        String categoria = vista.comboCategoria.getSelectedItem().toString();

        ArrayList<Producto> filtrados = new ArrayList<>();

        for (Producto p : inventario.getLista()) {
            boolean coincideTexto = texto.isEmpty()
                    || p.getNombre().toLowerCase().contains(texto)
                    || p.getCodigo().toLowerCase().contains(texto);

            boolean coincideCategoria = categoria.equals("Todas")
                    || p.getCategoria().equals(categoria);

            if (coincideTexto && coincideCategoria) filtrados.add(p);
        }

        cargarTabla(filtrados);
    }

    private void mostrarStockBajo() {
        try {
            int minimo = Integer.parseInt(vista.txtStockMinimo.getText());
            ArrayList<Producto> bajos = inventario.filtrarPorStockMinimo(minimo);
            cargarTabla(bajos);
        } catch (Exception e) {
            cargarTabla(inventario.filtrarPorStockMinimo(5));
        }
    }

    private void generarReporte() {
        reporte.generarReporteGeneral(inventario.getLista());
        javax.swing.JOptionPane.showMessageDialog(vista,
                "Reporte generado en reporte_general.xlsx");
    }
}