package Parte1;

import javax.swing.*;

public class Vista02_a extends JFrame {

    public JButton boton = new JButton("Presionar");

    public Vista02_a(){

        setTitle("Practica02_a");
        setBounds(100,100,300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        boton.setBounds(80,60,120,30);
        add(boton);
    }
}