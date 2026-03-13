package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal(){

        setTitle("Sistema de Ventas");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1,10,10));

        JButton btnClientes = new JButton("Clientes");
        JButton btnProductos = new JButton("Productos");
        JButton btnVentas = new JButton("Ventas");
        JButton btnSalir = new JButton("Salir");

        panel.add(btnClientes);
        panel.add(btnProductos);
        panel.add(btnVentas);
        panel.add(btnSalir);

        add(panel);

        // ABRIR CLIENTES
        btnClientes.addActionListener(e -> {

            VentanaCliente v = new VentanaCliente();
            v.setVisible(true);

        });

        // ABRIR PRODUCTOS
        btnProductos.addActionListener(e -> {

            VentanaProducto v = new VentanaProducto();
            v.setVisible(true);

        });

        // ABRIR VENTAS
        btnVentas.addActionListener(e -> {

            VentanaVenta v = new VentanaVenta();
            v.setVisible(true);

        });

        // SALIR
        btnSalir.addActionListener(e -> {

            System.exit(0);

        });

    }

}