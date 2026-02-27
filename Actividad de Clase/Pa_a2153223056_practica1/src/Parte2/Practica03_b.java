package Parte2;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Practica03_b extends JFrame implements ActionListener {

    private JTextField Tid, Tcategoria;
    private JTextArea TareaCategoria;
    private JButton BGuardar, BEliminar;

    private ArrayList<String> listaCategorias;

    public Practica03_b() {

        listaCategorias = new ArrayList<>();

        setTitle("Practica03_b - Categorias");
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

        TareaCategoria = new JTextArea();
        TareaCategoria.setEditable(false);
        JScrollPane sp = new JScrollPane(TareaCategoria);
        sp.setBounds(20, 150, 440, 220);
        add(sp);

        BGuardar = new JButton("Guardar");
        BGuardar.setBounds(20, 100, 120, 30);
        add(BGuardar);

        BEliminar = new JButton("Eliminar");
        BEliminar.setBounds(160, 100, 120, 30);
        add(BEliminar);

        BGuardar.addActionListener(this);
        BEliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == BGuardar) {

            if (!Tid.getText().isEmpty() && !Tcategoria.getText().isEmpty()) {

                String registro = Tid.getText() + " - " + Tcategoria.getText();

                if (!listaCategorias.contains(registro)) {
                    listaCategorias.add(registro);
                    actualizarArea();
                } else {
                    JOptionPane.showMessageDialog(this, "Categoria ya existe");
                }
            }
        }

        if (e.getSource() == BEliminar) {
            listaCategorias.removeIf(c -> c.startsWith(Tid.getText() + " -"));
            actualizarArea();
        }
    }

    private void actualizarArea() {
        TareaCategoria.setText("");
        for (String c : listaCategorias) {
            TareaCategoria.append(c + "\n");
        }
    }

    public static void main(String[] args) {
        new Practica03_b().setVisible(true);
    }
}