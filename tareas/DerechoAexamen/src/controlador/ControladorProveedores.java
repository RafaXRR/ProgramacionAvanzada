package controlador;

import modelo.Inventario;
import modelo.Proveedor;
import persistencia.ArchivoJSONProveedores;
import vista.VistaProveedores;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class ControladorProveedores {

    private VistaProveedores vista;
    private Inventario inventario;
    private ArchivoJSONProveedores archivo;

    public ControladorProveedores(VistaProveedores vista, Inventario inventario) {

        this.vista      = vista;
        this.inventario = inventario;
        this.archivo    = new ArchivoJSONProveedores();

        cargarTabla();
        eventos();
    }

    private void eventos() {
        vista.btnGuardar.addActionListener(e  -> guardar());
        vista.btnLimpiar.addActionListener(e  -> limpiar());
        vista.btnEliminar.addActionListener(e -> eliminar());
        vista.btnBuscar.addActionListener(e   -> buscar());

        vista.tabla.getSelectionModel().addListSelectionListener(
                (ListSelectionEvent e) -> cargarDatosSeleccionados()
        );
    }

    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0);

        for (Proveedor p : inventario.getProveedores()) {
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
    }

    private void cargarDatosSeleccionados() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) return;

        Proveedor p = inventario.getProveedores().get(fila);

        vista.txtNombre.setText(p.getNombre());
        vista.txtContacto.setText(p.getContacto());
        vista.txtTelefono.setText(p.getTelefono());
        vista.txtCorreo.setText(p.getCorreo());
        vista.txtDireccion.setText(p.getDireccion());
        vista.txtRfc.setText(p.getRfc());
        vista.comboTermino.setSelectedItem(p.getTerminoPago());
    }

    private void guardar() {
        try {
            String nombre   = vista.txtNombre.getText().trim();
            String contacto = vista.txtContacto.getText().trim();
            String telefono = vista.txtTelefono.getText().trim();
            String correo   = vista.txtCorreo.getText().trim();
            String direccion = vista.txtDireccion.getText().trim();
            String rfc      = vista.txtRfc.getText().trim();
            String termino  = vista.comboTermino.getSelectedItem().toString();

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "El nombre no puede estar vacío.");
                return;
            }

            int fila = vista.tabla.getSelectedRow();

            if (fila != -1) {
                // Editar existente
                Proveedor p = inventario.getProveedores().get(fila);
                p.setNombre(nombre);
                p.setContacto(contacto);
                p.setTelefono(telefono);
                p.setCorreo(correo);
                p.setDireccion(direccion);
                p.setRfc(rfc);
                p.setTerminoPago(termino);
            } else {
                // Nuevo proveedor
                int id     = inventario.generarIdProveedor();
                String cod = "PROV" + String.format("%03d", id);

                Proveedor p = new Proveedor(id, cod, nombre, contacto,
                        telefono, correo, direccion, rfc, termino);
                inventario.agregarProveedor(p);
            }

            archivo.guardar(inventario.getProveedores());
            cargarTabla();
            limpiar();
            JOptionPane.showMessageDialog(vista, "Proveedor guardado correctamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error al guardar el proveedor.");
        }
    }

    private void eliminar() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Selecciona un proveedor para eliminar.");
            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(vista,
                "¿Estás seguro de eliminar este proveedor?",
                "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            Proveedor p = inventario.getProveedores().get(fila);
            inventario.eliminarProveedor(p.getId());
            archivo.guardar(inventario.getProveedores());
            cargarTabla();
            limpiar();
        }
    }

    private void buscar() {
        String texto = vista.txtBuscar.getText().trim().toLowerCase();
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0);

        for (Proveedor p : inventario.getProveedores()) {
            if (p.getNombre().toLowerCase().contains(texto) ||
                p.getCodigo().toLowerCase().contains(texto) ||
                p.getRfc().toLowerCase().contains(texto)) {

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
        }
    }

    private void limpiar() {
        vista.txtNombre.setText("");
        vista.txtContacto.setText("");
        vista.txtTelefono.setText("");
        vista.txtCorreo.setText("");
        vista.txtDireccion.setText("");
        vista.txtRfc.setText("");
        vista.comboTermino.setSelectedIndex(0);
        vista.tabla.clearSelection();
    }
}