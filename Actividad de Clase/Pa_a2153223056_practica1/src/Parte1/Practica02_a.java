package Parte1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class Practica02_a extends JFrame {

    private JPanel PanelPrincipal;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Practica02_a frame = new Practica02_a();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Practica02_a() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        setTitle("Practica02_a");

        PanelPrincipal = new JPanel();
        PanelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
        PanelPrincipal.setLayout(null);
        setContentPane(PanelPrincipal);

        JButton Bsalir = new JButton("Salir");
        Bsalir.setBounds(145, 124, 89, 23);
        PanelPrincipal.add(Bsalir);
    }
}