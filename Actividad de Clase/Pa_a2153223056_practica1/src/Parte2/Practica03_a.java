package Parte2;

import javax.swing.*;
import java.awt.event.*;

public class Practica03_a extends JFrame implements ActionListener {

    private JTextField Tid, Tnombre;
    private JComboBox<String> ComboCategoria;
    private JTextArea area;
    private JButton BGuardar, BEliminar;

    private ListaInsumos lista;

    public Practica03_a() {

        lista = new ListaInsumos();

        setTitle("Practica03_a");
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
        ComboCategoria.addItem("Bebidas");
        ComboCategoria.addItem("Comida");
        ComboCategoria.addItem("Limpieza");
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == BGuardar) {

            if (!Tid.getText().isEmpty() && !Tnombre.getText().isEmpty()) {

                Insumo ins = new Insumo(
                        Tid.getText(),
                        Tnombre.getText(),
                        ComboCategoria.getSelectedItem().toString()
                );

                if (lista.agregar(ins)) {
                    area.setText(lista.mostrar());
                } else {
                    JOptionPane.showMessageDialog(this, "El ID ya existe");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Campos vacíos");
            }
        }

        if (e.getSource() == BEliminar) {
            lista.eliminar(Tid.getText());
            area.setText(lista.mostrar());
        }
    }

    public static void main(String[] args) {
        new Practica03_a().setVisible(true);
    }
}
