package vista;

import controlador.VentaControl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class VentanaVenta extends JFrame {

    private JTextField txtIdVenta;
    private JTextField txtIdCliente;
    private JTextField txtTotal;
    private JTable tabla;

    private VentaControl control;

    public VentanaVenta(){

        control = new VentaControl();

        setTitle("Ventas");
        setSize(500,400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // FORMULARIO
        JPanel panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(4,2));

        panelForm.add(new JLabel("ID Venta"));
        txtIdVenta = new JTextField();
        panelForm.add(txtIdVenta);

        panelForm.add(new JLabel("ID Cliente"));
        txtIdCliente = new JTextField();
        panelForm.add(txtIdCliente);

        panelForm.add(new JLabel("Total"));
        txtTotal = new JTextField();
        panelForm.add(txtTotal);

        JButton btnGuardar = new JButton("Guardar Venta");
        panelForm.add(btnGuardar);

        add(panelForm, BorderLayout.NORTH);

        // TABLA
        tabla = new JTable();
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);

        // EVENTO
        btnGuardar.addActionListener(e -> guardarVenta());

        cargarTabla();
    }

    private void guardarVenta(){

        int idVenta = Integer.parseInt(txtIdVenta.getText());
        int idCliente = Integer.parseInt(txtIdCliente.getText());
        double total = Double.parseDouble(txtTotal.getText());

        control.registrarVenta(idVenta,idCliente,total);

        JOptionPane.showMessageDialog(null,"Venta guardada");

        cargarTabla();
    }

    private void cargarTabla(){

        String columnas[] = {"ID Venta","ID Cliente","Total"};

        DefaultTableModel modelo = new DefaultTableModel(null,columnas);

        try{

            BufferedReader br = new BufferedReader(new FileReader("ventas.txt"));
            String linea;

            while((linea = br.readLine()) != null){

                String datos[] = linea.split(",");

                Object fila[] = {
                        datos[0],
                        datos[1],
                        datos[2]
                };

                modelo.addRow(fila);
            }

            br.close();

        }catch(Exception e){
        }

        tabla.setModel(modelo);
    }

}