package Parte1;

import java.awt.event.*;
import javax.swing.*;

public class Controlador02_b2 implements ActionListener {

    private Vista02_b2 vista;

    public Controlador02_b2(Vista02_b2 vista){
        this.vista = vista;
        this.vista.Bsalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(vista,"Saliendo con Alt + S");
        vista.dispose();
    }
}