package controlador;

import modelo.Inventario;
import modelo.UnidadMedida;
import vista.VistaUnidades;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class ControladorUnidades {

    private VistaUnidades vista;
    private Inventario inventario;

    public ControladorUnidades(VistaUnidades vista, Inventario inventario) {

        this.vista      = vista;
        this.inventario = inventario;

        cargarTabla();
        eventos();
    }

    private void eventos() {
        vista.btnGuardar.addActionListener(e  -> guardar());
        vista.btnLimpiar.addActionListener(e  -> limpiar());
        vista.btnEliminar.addActionListener(e -> eliminar());

        vista.tabla.getSelectionModel().addListSelectionListener(
                (ListSelectionEvent e) -> cargarDatosSeleccionados()
        );
    }

    private void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0);

        for (UnidadMedida u : inventario.getUnidades()) {
            modelo.addRow(new Object[]{
                    u.getId(),
                    u.getClave(),
                    u.getNombre()
            });
        }
    }

    private void cargarDatosSeleccionados() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) return;

        UnidadMedida u = inventario.getUnidades().get(fila);
        vista.txtClave.setText(u.getClave());
        vista.txtNombre.setText(u.getNombre());
    }

    private void guardar() {
        String clave  = vista.txtClave.getText().trim().toUpperCase();
        String nombre = vista.txtNombre.getText().trim();

        if (clave.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "La clave y el nombre son obligatorios.");
            return;
        }

        int fila = vista.tabla.getSelectedRow();

        if (fila != -1) {
            // Editar existente
            UnidadMedida u = inventario.getUnidades().get(fila);
            u.setClave(clave);
            u.setNombre(nombre);
        } else {
            // Nueva unidad
            int id = inventario.generarIdUnidad();
            inventario.agregarUnidad(new UnidadMedida(id, clave, nombre));
        }

        cargarTabla();
        limpiar();
        JOptionPane.showMessageDialog(vista, "Unidad guardada correctamente.");
    }

    private void eliminar() {
        int fila = vista.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Selecciona una unidad para eliminar.");
            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(vista,
                "¿Estás seguro de eliminar esta unidad?",
                "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            UnidadMedida u = inventario.getUnidades().get(fila);
            inventario.eliminarUnidad(u.getId());
            cargarTabla();
            limpiar();
        }
    }

    private void limpiar() {
        vista.txtClave.setText("");
        vista.txtNombre.setText("");
        vista.tabla.clearSelection();
    }
}