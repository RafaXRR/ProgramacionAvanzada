package vista;

import controlador.ClienteControl;
import modelo.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class VentanaCliente extends JFrame {

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtTelefono;
    private JTable tabla;

    private ClienteControl control;

    public VentanaCliente() {

        control = new ClienteControl();

        setTitle("Clientes");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // PANEL FORMULARIO
        JPanel panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(4,2));

        panelForm.add(new JLabel("ID"));
        txtId = new JTextField();
        panelForm.add(txtId);

        panelForm.add(new JLabel("Nombre"));
        txtNombre = new JTextField();
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("Telefono"));
        txtTelefono = new JTextField();
        panelForm.add(txtTelefono);

        JButton btnGuardar = new JButton("Guardar");
        panelForm.add(btnGuardar);

        add(panelForm, BorderLayout.NORTH);

        // TABLA
        tabla = new JTable();
        JScrollPane scroll = new JScrollPane(tabla);

        add(scroll, BorderLayout.CENTER);

        // EVENTO BOTON
        btnGuardar.addActionListener(e -> guardarCliente());

        cargarTabla();

    }

    private void guardarCliente(){

        int id = Integer.parseInt(txtId.getText());
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();

        control.registrarCliente(id,nombre,telefono);

        JOptionPane.showMessageDialog(null,"Cliente guardado");

        cargarTabla();

    }

    private void cargarTabla(){

        String columnas[] = {"ID","Nombre","Telefono"};

        DefaultTableModel modelo = new DefaultTableModel(null,columnas);

        ArrayList<Cliente> lista = control.obtenerClientes();

        for(Cliente c : lista){

            Object fila[] = {
                    c.getId(),
                    c.getNombre(),
                    c.getTelefono()
            };

            modelo.addRow(fila);

        }

        tabla.setModel(modelo);

    }

}