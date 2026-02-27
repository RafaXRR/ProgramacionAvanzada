package Parte2;

import Libreria.Archivotxt;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Practica03_d extends JFrame implements ActionListener {

    private JTextField Tid, Tnombre;
    private JComboBox<String> ComboCategoria;
    private JTextArea area;
    private JButton BGuardar, BEliminar;

    private ArrayList<String> lista;
    private String ruta = "insumos.txt";

    public Practica03_d() {

        lista = Archivotxt.cargar(ruta);

        setTitle("Practica03_d");
        setLayout(null);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lid = new JLabel("ID:");
        lid.setBounds(20, 20, 100, 25);
        add(lid);

        Tid = new JTextField();
        Tid.setBounds(120, 20, 150, 25);
        add(Tid);

        JLabel lnom = new JLabel("Nombre:");
        lnom.setBounds(20, 60, 100, 25);
        add(lnom);

        Tnombre = new JTextField();
        Tnombre.setBounds(120, 60, 150, 25);
        add(Tnombre);

        ComboCategoria = new JComboBox<>();
        ComboCategoria.setBounds(120, 100, 150, 25);
        ComboCategoria.setEnabled(true);
        ComboCategoria.addItem("Bebidas");
        ComboCategoria.addItem("Comida");
        ComboCategoria.addItem("Limpieza");
        ComboCategoria.setSelectedIndex(0);
        add(ComboCategoria);

        BGuardar = new JButton("Guardar");
        BGuardar.setBounds(20, 150, 120, 30);
        add(BGuardar);

        BEliminar = new JButton("Eliminar");
        BEliminar.setBounds(160, 150, 120, 30);
        add(BEliminar);

        area = new JTextArea();
        JScrollPane sp = new JScrollPane(area);
        sp.setBounds(20, 200, 440, 220);
        add(sp);

        BGuardar.addActionListener(this);
        BEliminar.addActionListener(this);

        actualizarArea();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == BGuardar) {

            String registro = Tid.getText() + "," +
                              Tnombre.getText() + "," +
                              ComboCategoria.getSelectedItem().toString();

            lista.add(registro);
            Archivotxt.guardar(ruta, lista);
            actualizarArea();
        }

        if (e.getSource() == BEliminar) {
            lista.removeIf(i -> i.startsWith(Tid.getText() + ","));
            Archivotxt.guardar(ruta, lista);
            actualizarArea();
        }
    }

    private void actualizarArea() {
        area.setText("");
        for (String i : lista) {
            area.append(i + "\n");
        }
    }

    public static void main(String[] args) {
        new Practica03_d().setVisible(true);
    }
}
