package Parte1;

import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Practica02_b2 extends JFrame implements ActionListener {

    private JPanel PanelPrincipal;
    private JButton Bsalir;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Practica02_b2 frame = new Practica02_b2();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Practica02_b2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        setTitle("Practica02_b2");

        PanelPrincipal = new JPanel();
        PanelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
        PanelPrincipal.setLayout(null);
        setContentPane(PanelPrincipal);

        Bsalir = new JButton("Salir");
        Bsalir.setBounds(145, 124, 89, 23);

        Bsalir.setMnemonic(KeyEvent.VK_S);
        Bsalir.setDisplayedMnemonicIndex(0);

        PanelPrincipal.add(Bsalir);
        Bsalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Bsalir) {
            JOptionPane.showMessageDialog(this, "Saliendo con Alt + S");
            dispose();
        }
    }
}
