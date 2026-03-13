package vista;

import controlador.ProductoControl;
import modelo.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class VentanaProducto extends JFrame {

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTable tabla;

    private ProductoControl control;

    public VentanaProducto(){

        control = new ProductoControl();

        setTitle("Productos");
        setSize(500,400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(4,2));

        panelForm.add(new JLabel("ID"));
        txtId = new JTextField();
        panelForm.add(txtId);

        panelForm.add(new JLabel("Nombre"));
        txtNombre = new JTextField();
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("Precio"));
        txtPrecio = new JTextField();
        panelForm.add(txtPrecio);

        JButton btnGuardar = new JButton("Guardar");
        panelForm.add(btnGuardar);

        add(panelForm,BorderLayout.NORTH);

        tabla = new JTable();
        JScrollPane scroll = new JScrollPane(tabla);

        add(scroll,BorderLayout.CENTER);

        btnGuardar.addActionListener(e -> guardarProducto());

        cargarTabla();

    }

    private void guardarProducto(){

        int id = Integer.parseInt(txtId.getText());
        String nombre = txtNombre.getText();
        double precio = Double.parseDouble(txtPrecio.getText());

        control.registrarProducto(id,nombre,precio);

        JOptionPane.showMessageDialog(null,"Producto guardado");

        cargarTabla();

    }

    private void cargarTabla(){

        String columnas[] = {"ID","Nombre","Precio"};

        DefaultTableModel modelo = new DefaultTableModel(null,columnas);

        ArrayList<Producto> lista = control.obtenerProductos();

        for(Producto p : lista){

            Object fila[] = {
                    p.getId(),
                    p.getNombre(),
                    p.getPrecio()
            };

            modelo.addRow(fila);

        }

        tabla.setModel(modelo);

    }

}