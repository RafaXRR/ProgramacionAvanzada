package vista;

import javax.swing.*;

public class IfrmCategorias extends JInternalFrame {

    public JTable tabla;
    public JButton btnAgregar, btnEliminar;

    public IfrmCategorias() {

        setTitle("Categorias");
        setClosable(true);
        setSize(400, 300);
        setLayout(new java.awt.BorderLayout());

        tabla = new JTable();
        add(new JScrollPane(tabla), java.awt.BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);

        add(panelBotones, java.awt.BorderLayout.SOUTH);
    }
}