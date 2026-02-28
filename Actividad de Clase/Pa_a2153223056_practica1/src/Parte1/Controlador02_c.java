package Parte1;

import java.awt.event.*;

public class Controlador02_c implements ActionListener {

    private Vista02_c vista;

    public Controlador02_c(Vista02_c vista){
        this.vista = vista;
        this.vista.boton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String texto = "Nombre: " + vista.Tnombre.getText();
        texto += "\nSpinner: " + vista.spinner.getValue();
        texto += "\nSlider: " + vista.slider.getValue();
        texto += "\nCombo: " + vista.combo.getSelectedItem();

        vista.area.setText(texto);
    }
}