package controlador;

import modelo.*;
import vista.*;

import javax.swing.JOptionPane;

import Libreria.*;

import java.awt.event.*;

public class ControladorCategorias implements ActionListener {

    private ListaCategorias modelo;
    private IfrmCategorias vista;
    private ArchivoTXT archivo;

    public ControladorCategorias(ListaCategorias m, IfrmCategorias v) {

        this.modelo = m;
        this.vista = v;
        this.archivo = new ArchivoTXT("categorias.txt");

        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);

        cargarDatos();
        actualizarTabla();
    }

    private void actualizarTabla() {
        vista.tabla.setModel(modelo.getModeloTabla());
    }

    private void cargarDatos() {

        if (archivo.existe()) {
            String datos = archivo.cargar();
            String[] lineas = datos.split("\n");

            for (String l : lineas) {
                if (!l.isEmpty()) {
                    String[] partes = l.split(";");
                    modelo.agregar(new Categoria(
                            Integer.parseInt(partes[0]),
                            partes[1]
                    ));
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnAgregar) {

            String nombre = JOptionPane.showInputDialog("Nombre categoria:");
            int id = modelo.getModeloTabla().getRowCount() + 1;

            if (!modelo.existe(id)) {
                modelo.agregar(new Categoria(id, nombre));
                archivo.guardar(modelo.toArchivo());
                actualizarTabla();
            }
        }

        if (e.getSource() == vista.btnEliminar) {

            int fila = vista.tabla.getSelectedRow();
            if (fila != -1) {
                int id = (int) vista.tabla.getValueAt(fila, 0);
                modelo.eliminar(id);
                archivo.guardar(modelo.toArchivo());
                actualizarTabla();
            }
        }
    }
}