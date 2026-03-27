package controlador;

import modelo.Inventario;
import modelo.Producto;
import vista.VistaPuntoVenta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ControladorPuntoVenta {

    private VistaPuntoVenta vista;
    private Inventario inventario;

    public ControladorPuntoVenta(VistaPuntoVenta vista, Inventario inventario) {

        this.vista      = vista;
        this.inventario = inventario;

        cargarProductos();
        eventos();
    }

    private void eventos() {
        vista.btnAgregar.addActionListener(e  -> agregarProducto());
        vista.btnEliminar.addActionListener(e -> eliminarProducto());
        vista.btnProcesar.addActionListener(e -> procesarPago());
        vista.btnLimpiar.addActionListener(e  -> limpiarCarrito());

        vista.comboProductos.addActionListener(e -> mostrarInfoProducto());
    }

    private void cargarProductos() {
        vista.comboProductos.removeAllItems();
        for (Producto p : inventario.getLista()) {
            vista.comboProductos.addItem(p.getCodigo() + " - " + p.getNombre());
        }
    }

    private void mostrarInfoProducto() {
        int index = vista.comboProductos.getSelectedIndex();
        if (index == -1) return;

        Producto p = inventario.getLista().get(index);

        vista.lblPrecio.setText(String.format("Precio: $%.2f", p.getPrecioVenta()));
        vista.lblUnidad.setText("Unidad: " + p.getUnidadMedida());

        // Mostrar imagen
        try {
            ImageIcon icono = new ImageIcon(p.getImagen());
            if (icono.getIconWidth() != -1) {
                Image img = icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                vista.lblImagen.setIcon(new ImageIcon(img));
            } else {
                vista.lblImagen.setIcon(null);
            }
        } catch (Exception e) {
            vista.lblImagen.setIcon(null);
        }
    }

    private void agregarProducto() {
        int index = vista.comboProductos.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(vista, "Selecciona un producto.");
            return;
        }

        try {
            int cantidad = Integer.parseInt(vista.txtCantidad.getText());
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(vista, "La cantidad debe ser mayor a 0.");
                return;
            }

            Producto p     = inventario.getLista().get(index);
            double precio  = p.getPrecioVenta();
            double total   = cantidad * precio;

            DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
            modelo.addRow(new Object[]{
                    p.getCodigo(),
                    p.getNombre(),
                    cantidad,
                    p.getUnidadMedida(),
                    String.format("$%.2f", precio),
                    String.format("$%.2f", total)
            });

            calcularTotales();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Cantidad inválida.");
        }
    }

    private void eliminarProducto() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Selecciona un producto del carrito.");
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.removeRow(fila);
        calcularTotales();
    }

    private void calcularTotales() {
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();

        double subtotal = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String totalStr = modelo.getValueAt(i, 5).toString().replace("$", "");
            subtotal += Double.parseDouble(totalStr);
        }

        double iva   = subtotal * 0.16;
        double total = subtotal + iva;

        vista.txtSubtotal.setText(String.format("$%.2f", subtotal));
        vista.txtIva.setText(String.format("$%.2f", iva));
        vista.txtTotal.setText(String.format("$%.2f", total));
    }

    private void procesarPago() {
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();

        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(vista, "El carrito está vacío.");
            return;
        }

        StringBuilder ticket = new StringBuilder();
        ticket.append("════════════════════════════\n");
        ticket.append("       TICKET DE VENTA      \n");
        ticket.append("════════════════════════════\n");

        for (int i = 0; i < modelo.getRowCount(); i++) {
            ticket.append(String.format("%-15s x%s %s\n",
                    modelo.getValueAt(i, 1),
                    modelo.getValueAt(i, 2),
                    modelo.getValueAt(i, 5)));
        }

        ticket.append("────────────────────────────\n");
        ticket.append("Subtotal : ").append(vista.txtSubtotal.getText()).append("\n");
        ticket.append("IVA 16%  : ").append(vista.txtIva.getText()).append("\n");
        ticket.append("TOTAL    : ").append(vista.txtTotal.getText()).append("\n");
        ticket.append("════════════════════════════");

        JOptionPane.showMessageDialog(vista, ticket.toString(),
                "Ticket de Venta", JOptionPane.INFORMATION_MESSAGE);

        limpiarCarrito();
    }

    private void limpiarCarrito() {
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0);
        vista.txtSubtotal.setText("");
        vista.txtIva.setText("");
        vista.txtTotal.setText("");
        vista.lblImagen.setIcon(null);
    }
}