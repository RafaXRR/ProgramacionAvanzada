package Parte2;

import javax.swing.*;

public class Vista03_c extends JFrame {

    public JTextField Tid = new JTextField();
    public JTextField Tnombre = new JTextField();
    public JTextArea area = new JTextArea();

    public JButton Bagregar = new JButton("Agregar");
    public JButton Beliminar = new JButton("Eliminar");
    public JButton Bguardar = new JButton("Guardar");
    public JButton Bcargar = new JButton("Cargar");

    public Vista03_c(){
        setTitle("Practica03_c");
        setBounds(100,100,500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        Tid.setBounds(30,30,100,25);
        Tnombre.setBounds(150,30,150,25);

        Bagregar.setBounds(30,70,100,25);
        Beliminar.setBounds(150,70,100,25);
        Bguardar.setBounds(270,70,100,25);
        Bcargar.setBounds(380,70,100,25);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(30,120,430,220);

        add(Tid); add(Tnombre);
        add(Bagregar); add(Beliminar);
        add(Bguardar); add(Bcargar);
        add(scroll);
    }
}