package Parte2;

import javax.swing.*;

public class Vista03_d extends JFrame {

    public JTextField Tid = new JTextField();
    public JTextField Tnombre = new JTextField();
    public JComboBox<String> ComboCategoria = new JComboBox<>();
    public JTextArea area = new JTextArea();

    public JButton Bagregar = new JButton("Agregar");
    public JButton Beliminar = new JButton("Eliminar");

    public Vista03_d(){
        setTitle("Practica03_d");
        setBounds(100,100,500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        Tid.setBounds(30,30,100,25);
        Tnombre.setBounds(150,30,150,25);
        ComboCategoria.setBounds(320,30,120,25);

        ComboCategoria.addItem("Categoria A");
        ComboCategoria.addItem("Categoria B");
        ComboCategoria.setEnabled(true);
        ComboCategoria.setSelectedIndex(0);

        Bagregar.setBounds(30,70,100,25);
        Beliminar.setBounds(150,70,100,25);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(30,120,410,200);

        add(Tid); add(Tnombre); add(ComboCategoria);
        add(Bagregar); add(Beliminar);
        add(scroll);
    }
}
