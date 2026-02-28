package Parte1;

import javax.swing.*;

public class Vista02_c extends JFrame {

    public JTextField Tnombre = new JTextField();
    public JSpinner spinner = new JSpinner();
    public JSlider slider = new JSlider();
    public JComboBox<String> combo = new JComboBox<>();
    public JTextArea area = new JTextArea();
    public JButton boton = new JButton("Mostrar");

    public Vista02_c() {
        setTitle("Practica02_c");
        setBounds(100,100,500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        Tnombre.setBounds(30,30,150,25);
        spinner.setBounds(30,70,100,25);
        slider.setBounds(30,110,200,50);
        combo.setBounds(30,170,120,25);
        boton.setBounds(30,210,100,25);

        combo.addItem("Opción 1");
        combo.addItem("Opción 2");
        combo.addItem("Opción 3");

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(250,30,200,200);

        add(Tnombre);
        add(spinner);
        add(slider);
        add(combo);
        add(boton);
        add(scroll);
    }
}
