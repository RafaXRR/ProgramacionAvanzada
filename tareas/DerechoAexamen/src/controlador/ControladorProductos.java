package controlador;
import persistencia.ReporteVisor;

import modelo.*;
import persistencia.ArchivoJSONProductos;

import vista.VistaProductos;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;

public class ControladorProductos {

    private VistaProductos vista;
    private Inventario inventario;
    private ArchivoJSONProductos archivo;
    private ReporteVisor reporte;

    private String imagenSeleccionada = "imagenes/default.png";

    public ControladorProductos(VistaProductos vista, Inventario inventario) {

        this.vista     = vista;
        this.inventario = inventario;
        this.archivo   = new ArchivoJSONProductos();
        this.reporte   = new ReporteVisor();

        cargarUnidades();
        cargarTabla();
        eventos();
    }

    private void eventos() {

        vista.btnGuardar.addActionListener(e          -> guardar());
        vista.btnLimpiar.addActionListener(e          -> limpiar());
        vista.btnEliminar.addActionListener(e         -> eliminar());
        vista.btnImagen.addActionListener(e           -> seleccionarImagen());
        vista.btnReporteGeneral.addActionListener(e   -> reporteGeneral());
        vista.btnReporteCategoria.addActionListener(e -> reporteCategoria());
        vista.btnBuscar.addActionListener(e           -> buscar());

        // Calcular precio venta al cambiar precio compra o porcentaje
        vista.txtPrecioCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent e) { calcularPrecioVenta(); }
        });
        vista.txtPorcentaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent e) { calcularPrecioVenta(); }
        });

        // Cargar datos al seleccionar fila
        vista.tabla.getSelectionModel().addListSelectionListener(
                (ListSelectionEvent e) -> cargarDatosSeleccionados()
        );
    }

    private void cargarUnidades() {
        vista.comboUnidad.removeAllItems();
        for (UnidadMedida u : inventario.getUnidades()) {
            vista.comboUnidad.addItem(u.getClave());
        }
    }

    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0);

        for (Producto p : inventario.getLista()) {
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
    }

    private void cargarDatosSeleccionados() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) return;

        Producto p = inventario.getLista().get(fila);

        vista.txtCodigo.setText(p.getCodigo());
        vista.txtNombre.setText(p.getNombre());
        vista.txtPrecioCompra.setText(String.valueOf(p.getPrecioCompra()));
        vista.txtPorcentaje.setText(String.valueOf(p.getPorcentajeGanancia()));
        vista.txtPrecioVenta.setText(String.format("$%.2f", p.getPrecioVenta()));
        vista.txtStock.setText(String.valueOf(p.getStock()));
        vista.comboCategoria.setSelectedItem(p.getCategoria());
        vista.comboUnidad.setSelectedItem(p.getUnidadMedida());

        imagenSeleccionada = p.getImagen();
        mostrarImagen(p.getImagen());
    }

    private void calcularPrecioVenta() {
        try {
            double compra     = Double.parseDouble(vista.txtPrecioCompra.getText());
            double porcentaje = Double.parseDouble(vista.txtPorcentaje.getText());
            double venta      = compra * (1 + porcentaje / 100.0);
            vista.txtPrecioVenta.setText(String.format("$%.2f", venta));
        } catch (Exception e) {
            vista.txtPrecioVenta.setText("");
        }
    }

    private void guardar() {
        try {
            String nombre    = vista.txtNombre.getText().trim();
            String categoria = vista.comboCategoria.getSelectedItem().toString();
            String unidad    = vista.comboUnidad.getSelectedItem().toString();
            double compra    = Double.parseDouble(vista.txtPrecioCompra.getText());
            double porcen    = Double.parseDouble(vista.txtPorcentaje.getText());
            int stock        = Integer.parseInt(vista.txtStock.getText());

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "El nombre no puede estar vacío.");
                return;
            }

            // Si hay una fila seleccionada, es edición
            int fila = vista.tabla.getSelectedRow();
            if (fila != -1) {
                Producto p = inventario.getLista().get(fila);
                p.setNombre(nombre);
                p.setPrecioCompra(compra);
                p.setPorcentajeGanancia(porcen);
                p.setStock(stock);
                p.setUnidadMedida(unidad);
                p.setImagen(imagenSeleccionada);
            } else {
                int id     = inventario.generarIdProducto();
                String cod = "P" + id;
                Producto p = crearProducto(id, cod, nombre, categoria,
                                           compra, porcen, stock,
                                           imagenSeleccionada, unidad);
                if (p != null) inventario.agregar(p);
            }

            archivo.guardar(inventario.getLista());
            cargarTabla();
            limpiar();
            JOptionPane.showMessageDialog(vista, "Producto guardado correctamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Verifica que los campos numéricos sean correctos.");
        }
    }

    private void eliminar() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Selecciona un producto para eliminar.");
            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(vista,
                "¿Estás seguro de eliminar este producto?",
                "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            Producto p = inventario.getLista().get(fila);
            inventario.eliminarProducto(p.getId());
            archivo.guardar(inventario.getLista());
            cargarTabla();
            limpiar();
        }
    }

    private void seleccionarImagen() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccionar imagen del producto");
        int resultado = chooser.showOpenDialog(vista);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();
            imagenSeleccionada = archivo.getPath();
            mostrarImagen(imagenSeleccionada);
        }
    }

    private void mostrarImagen(String ruta) {
        try {
            ImageIcon icono = new ImageIcon(ruta);
            if (icono.getIconWidth() == -1) {
                vista.lblImagen.setIcon(null);
                return;
            }
            Image img = icono.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            vista.lblImagen.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            vista.lblImagen.setIcon(null);
        }
    }

    private void buscar() {
        String texto = vista.txtBuscar.getText().trim().toLowerCase();
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0);

        for (Producto p : inventario.getLista()) {
            if (p.getNombre().toLowerCase().contains(texto) ||
                p.getCodigo().toLowerCase().contains(texto) ||
                p.getCategoria().toLowerCase().contains(texto)) {

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
        }
    }

    private void limpiar() {
        vista.txtCodigo.setText("");
        vista.txtNombre.setText("");
        vista.txtPrecioCompra.setText("");
        vista.txtPorcentaje.setText("");
        vista.txtPrecioVenta.setText("");
        vista.txtStock.setText("");
        vista.lblImagen.setIcon(null);
        vista.tabla.clearSelection();
        imagenSeleccionada = "imagenes/default.png";
    }

    private void reporteGeneral() {
        reporte.generarReporteGeneral(inventario.getLista());
        JOptionPane.showMessageDialog(vista, "Reporte general generado en reporte_general.xlsx");
    }

    private void reporteCategoria() {
        String categoria = vista.comboCategoria.getSelectedItem().toString();
        reporte.generarPorCategoria(inventario.getLista(), categoria);
        JOptionPane.showMessageDialog(vista, "Reporte de " + categoria + " generado.");
    }

    private Producto crearProducto(int id, String codigo, String nombre,
                                   String categoria, double compra, double porcen,
                                   int stock, String imagen, String unidad) {
        switch (categoria) {
            case "Despensa Básica":               return new ProductoDespensa(id, codigo, nombre, compra, porcen, stock, imagen, unidad);
            case "Lácteos y Huevo":               return new ProductoLacteo(id, codigo, nombre, compra, porcen, stock, imagen, unidad);
            case "Bebidas y Líquidos":            return new ProductoBebida(id, codigo, nombre, compra, porcen, stock, imagen, unidad);
            case "Botanas y Dulces":              return new ProductoBotana(id, codigo, nombre, compra, porcen, stock, imagen, unidad);
            case "Frutas y Verduras":             return new ProductoFrutaVerdura(id, codigo, nombre, compra, porcen, stock, imagen, unidad);
            case "Carnes y Salchichonería":       return new ProductoCarne(id, codigo, nombre, compra, porcen, stock, imagen, unidad);
            case "Cuidado del Hogar":             return new ProductoHogar(id, codigo, nombre, compra, porcen, stock, imagen, unidad);
            case "Higiene y Cuidado Personal":    return new ProductoHigiene(id, codigo, nombre, compra, porcen, stock, imagen, unidad);
            case "Alimentos Preparados/Enlatados": return new ProductoEnlatado(id, codigo, nombre, compra, porcen, stock, imagen, unidad);
            default: return null;
        }
    }
}