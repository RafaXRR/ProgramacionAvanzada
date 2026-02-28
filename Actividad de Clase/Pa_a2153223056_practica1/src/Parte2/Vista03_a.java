package Parte2;

import javax.swing.*;

public class Vista03_a extends JFrame {

    public JTextField Tid = new JTextField();
    public JTextField Tnombre = new JTextField();
    public JComboBox<String> combo = new JComboBox<>();
    public JTextArea area = new JTextArea();
    public JButton Bagregar = new JButton("Agregar");
    public JButton Beliminar = new JButton("Eliminar");

    public Vista03_a(){
        setTitle("Practica03_a");
        setBounds(100,100,500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        Tid.setBounds(30,30,100,25);
        Tnombre.setBounds(150,30,150,25);
        combo.setBounds(320,30,120,25);

        combo.addItem("Categoria A");
        combo.addItem("Categoria B");

        Bagregar.setBounds(30,70,100,25);
        Beliminar.setBounds(150,70,100,25);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(30,120,410,200);

        add(Tid); add(Tnombre); add(combo);
        add(Bagregar); add(Beliminar);
        add(scroll);
    }
}