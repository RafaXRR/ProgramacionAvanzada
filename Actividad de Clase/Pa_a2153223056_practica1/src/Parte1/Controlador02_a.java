package Parte1;

import java.awt.event.*;

public class Controlador02_a implements ActionListener {

    private Vista02_a vista;

    public Controlador02_a(Vista02_a vista){
        this.vista = vista;
        vista.boton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.boton){
            System.out.println("Botón presionado");
        }
    }
}