package Parte1;

import javax.swing.*;

public class Practica01_03_JDialog extends JDialog {

    public Practica01_03_JDialog() {
        setTitle("Ventana JDialog");
        setBounds(200, 200, 300, 200);
        setModal(true);
        add(new JLabel("Este es un JDialog", JLabel.CENTER));
    }

    public static void main(String[] args) {
        Practica01_03_JDialog dialog = new Practica01_03_JDialog();
        dialog.setVisible(true);
    }
}