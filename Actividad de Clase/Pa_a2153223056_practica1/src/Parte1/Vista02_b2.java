package Parte1;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Vista02_b2 extends JFrame {

    public JButton Bsalir = new JButton("Salir");

    public Vista02_b2() {
        setTitle("Practica02_b2");
        setBounds(100,100,400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        Bsalir.setBounds(145,124,89,23);
        Bsalir.setMnemonic(KeyEvent.VK_S);
        Bsalir.setDisplayedMnemonicIndex(0);
        add(Bsalir);
    }
}