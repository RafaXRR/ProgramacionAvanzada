package Parte1;

import javax.swing.*;

public class Vista02_b extends JFrame {

    public JButton Bsalir = new JButton("Salir");

    public Vista02_b() {
        setTitle("Practica02_b");
        setBounds(100,100,400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        Bsalir.setBounds(145,124,89,23);
        add(Bsalir);
    }
}