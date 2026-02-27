package Parte1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Practica02_c extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField Tnombre;
    private JTextArea area;
    private JSpinner spinner;
    private JSlider slider;
    private JComboBox<String> combo;
    private JButton boton;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Practica02_c frame = new Practica02_c();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Practica02_c() {
        setTitle("Practica02_c");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        Tnombre = new JTextField();
        Tnombre.setBounds(30, 30, 150, 25);
        contentPane.add(Tnombre);

        spinner = new JSpinner();
        spinner.setBounds(30, 70, 100, 25);
        contentPane.add(spinner);

        slider = new JSlider();
        slider.setBounds(30, 110, 200, 50);
        contentPane.add(slider);

        combo = new JComboBox<>();
        combo.addItem("Opción 1");
        combo.addItem("Opción 2");
        combo.addItem("Opción 3");
        combo.setBounds(30, 170, 120, 25);
        contentPane.add(combo);

        boton = new JButton("Mostrar");
        boton.setBounds(30, 210, 100, 25);
        contentPane.add(boton);
        boton.addActionListener(this);

        area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(250, 30, 200, 200);
        contentPane.add(scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String texto = "Nombre: " + Tnombre.getText();
        texto += "\nSpinner: " + spinner.getValue();
        texto += "\nSlider: " + slider.getValue();

        if (combo.getSelectedIndex() > -1) {
            texto += "\nCombo: " + combo.getSelectedItem().toString();
        }

        area.setText(texto);
    }
}
