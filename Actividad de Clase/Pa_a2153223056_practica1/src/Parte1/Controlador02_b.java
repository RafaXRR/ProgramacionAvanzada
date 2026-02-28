package Parte1;

import java.awt.event.*;
import javax.swing.*;

public class Controlador02_b implements ActionListener {

    private Vista02_b vista;

    public Controlador02_b(Vista02_b vista){
        this.vista = vista;
        this.vista.Bsalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(vista,"Saliendo...");
        vista.dispose();
    }
}