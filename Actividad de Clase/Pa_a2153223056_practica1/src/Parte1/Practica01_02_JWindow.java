package Parte1;

import javax.swing.*;
import java.awt.*;

public class Practica01_02_JWindow extends JWindow {

    public Practica01_02_JWindow() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Ventana JWindow"));
        getContentPane().add(panel);
        setBounds(200, 200, 300, 200);
    }

    public static void main(String[] args) {
        Practica01_02_JWindow window = new Practica01_02_JWindow();
        window.setVisible(true);
    }
}