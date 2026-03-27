package controlador;

import modelo.Inventario;
import modelo.Producto;
import persistencia.ReporteVisor;
import vista.VistaReportes;

import javax.swing.*;
import java.util.ArrayList;

public class ControladorReportes {

    private VistaReportes vista;
    private Inventario inventario;
    private ReporteVisor reporte;

    public ControladorReportes(VistaReportes vista, Inventario inventario) {

        this.vista      = vista;
        this.inventario = inventario;
        this.reporte    = new ReporteVisor();

        eventos();
    }

    private void eventos() {
        vista.btnProductosGeneral.addActionListener(e   -> reporteGeneral());
        vista.btnProductosCategoria.addActionListener(e -> reporteCategoria());
        vista.btnStockBajo.addActionListener(e          -> reporteStockBajo());
        vista.btnValorInventario.addActionListener(e    -> reporteValorInventario());
        vista.btnProveedores.addActionListener(e        -> reporteProveedores());
        vista.btnMasVendidos.addActionListener(e        -> reporteMasVendidos());
    }

    private void reporteGeneral() {
        reporte.generarReporteGeneral(inventario.getLista());
    }

    private void reporteCategoria() {
        String categoria = vista.comboCategoria.getSelectedItem().toString();
        reporte.generarPorCategoria(inventario.getLista(), categoria);
    }

    private void reporteStockBajo() {
        ArrayList<Producto> bajos = inventario.filtrarPorStockMinimo(5);
        reporte.generarStockBajo(bajos, 5);
    }

    private void reporteValorInventario() {
        double valor = 0;
        for (Producto p : inventario.getLista()) {
            valor += p.getPrecioCompra() * p.getStock();
        }

        JOptionPane.showMessageDialog(vista,
                String.format("Valor total del inventario:\n\n$%.2f\n\n(%d productos registrados)",
                        valor, inventario.getLista().size()),
                "Valor del Inventario", JOptionPane.INFORMATION_MESSAGE);
    }

    private void reporteProveedores() {
        reporte.generarReporteProveedores(inventario.getProveedores());
    }

    private void reporteMasVendidos() {
        JOptionPane.showMessageDialog(vista,
                "Este reporte requiere historial de ventas.\n" +
                "Estara disponible cuando se registren ventas en el sistema.",
                "Productos Mas Vendidos", JOptionPane.INFORMATION_MESSAGE);
    }
}