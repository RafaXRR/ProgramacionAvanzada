package Parte2;

import Libreria.Archivotxt;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Practica03_c extends JFrame implements ActionListener {

    private JTextField Tid, Tcategoria;
    private JTextArea area;
    private JButton BGuardar, BEliminar, BCargar;

    private ArrayList<String> lista;
    private String ruta = "categorias.txt";

    public Practica03_c() {

        lista = new ArrayList<>();

        setTitle("Practica03_c - Archivo TXT");
        setLayout(null);
        setSize(500, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lid = new JLabel("ID:");
        lid.setBounds(20, 20, 100, 25);
        add(lid);

        Tid = new JTextField();
        Tid.setBounds(120, 20, 150, 25);
        add(Tid);

        JLabel lcat = new JLabel("Categoria:");
        lcat.setBounds(20, 60, 100, 25);
        add(lcat);

        Tcategoria = new JTextField();
        Tcategoria.setBounds(120, 60, 150, 25);
        add(Tcategoria);

        BGuardar = new JButton("Guardar");
        BGuardar.setBounds(20, 100, 100, 30);
        add(BGuardar);

        BEliminar = new JButton("Eliminar");
        BEliminar.setBounds(130, 100, 100, 30);
        add(BEliminar);

        BCargar = new JButton("Cargar");
        BCargar.setBounds(240, 100, 100, 30);
        add(BCargar);

        area = new JTextArea();
        JScrollPane sp = new JScrollPane(area);
        sp.setBounds(20, 150, 440, 220);
        add(sp);

        BGuardar.addActionListener(this);
        BEliminar.addActionListener(this);
        BCargar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == BGuardar) {

            if (!Tid.getText().isEmpty() && !Tcategoria.getText().isEmpty()) {

                String registro = Tid.getText() + "," + Tcategoria.getText();
                lista.add(registro);
                Archivotxt.guardar(ruta, lista);
                actualizarArea();
            }
        }

        if (e.getSource() == BEliminar) {
            lista.removeIf(c -> c.startsWith(Tid.getText() + ","));
            Archivotxt.guardar(ruta, lista);
            actualizarArea();
        }

        if (e.getSource() == BCargar) {
            lista = Archivotxt.cargar(ruta);
            actualizarArea();
        }
    }

    private void actualizarArea() {
        area.setText("");
        for (String c : lista) {
            area.append(c + "\n");
        }
    }

    public static void main(String[] args) {
        new Practica03_c().setVisible(true);
    }
}