package Parte2;

import javax.swing.*;

public class Vista03_b extends JFrame {

    public JTextField Tid = new JTextField();
    public JTextField Tnombre = new JTextField();
    public JTextArea area = new JTextArea();

    public JButton Bagregar = new JButton("Agregar");
    public JButton Beliminar = new JButton("Eliminar");

    public Vista03_b(){
        setTitle("Practica03_b");
        setBounds(100,100,450,350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        Tid.setBounds(30,30,100,25);
        Tnombre.setBounds(150,30,150,25);

        Bagregar.setBounds(30,70,100,25);
        Beliminar.setBounds(150,70,100,25);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(30,120,350,170);

        add(Tid); add(Tnombre);
        add(Bagregar); add(Beliminar);
        add(scroll);
    }
}