package MultipleChoiceExam;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.util.List;

public class VentanaPrincipal extends JFrame {

    private Examen examen;
    private Pregunta preguntaActual;

    private JLabel lblPregunta;
    private JRadioButton[] opciones;
    private ButtonGroup grupo;
    private JButton btnSiguiente;

    public VentanaPrincipal() {

        setTitle("Sistema de Examen");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // MENÚ
        JMenuBar barra = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem abrir = new JMenuItem("Abrir");
        JMenuItem salir = new JMenuItem("Salir");

        menuArchivo.add(abrir);
        menuArchivo.add(salir);
        barra.add(menuArchivo);

        setJMenuBar(barra);

        // PANEL
        JPanel panel = new JPanel(new GridLayout(6, 1));

        lblPregunta = new JLabel("Abra un archivo para comenzar", SwingConstants.CENTER);
        panel.add(lblPregunta);

        opciones = new JRadioButton[4];
        grupo = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            opciones[i] = new JRadioButton();
            grupo.add(opciones[i]);
            panel.add(opciones[i]);
        }

        btnSiguiente = new JButton("Responder");
        btnSiguiente.setEnabled(false);
        panel.add(btnSiguiente);

        add(panel, BorderLayout.CENTER);

        // EVENTOS
        abrir.addActionListener(e -> cargarArchivo());
        salir.addActionListener(e -> System.exit(0));
        btnSiguiente.addActionListener(e -> responder());

        setVisible(true);
    }

    private void cargarArchivo() {

        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Archivos CSV", "csv"));

        int resultado = chooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            try {

                File archivo = chooser.getSelectedFile();
                GestorArchivos gestor = new GestorArchivos();
                List<Pregunta> lista = gestor.cargarExamen(archivo);

                examen = new Examen(lista);
                btnSiguiente.setEnabled(true);

                mostrarPregunta();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                        "Error al cargar archivo:\n" + e.getMessage());
            }
        }
    }

    private void mostrarPregunta() {

        preguntaActual = examen.obtenerSiguiente();

        if (preguntaActual == null) {

            double puntaje = examen.calcularPuntaje();

            JOptionPane.showMessageDialog(this,
                    "Examen terminado\nPuntaje: " + puntaje + "%");

            btnSiguiente.setEnabled(false);
            lblPregunta.setText("Examen finalizado");

            for (JRadioButton r : opciones) {
                r.setText("");
            }

            return;
        }

        lblPregunta.setText(preguntaActual.getEnunciado());

        String[] ops = preguntaActual.getOpciones();

        for (int i = 0; i < 4; i++) {
            opciones[i].setText(ops[i]);
        }

        grupo.clearSelection();
    }

    private void responder() {

        if (grupo.getSelection() == null) {
            JOptionPane.showMessageDialog(this,
                    "Debe seleccionar una opción.");
            return;
        }

        String seleccion = "";

        for (JRadioButton r : opciones) {
            if (r.isSelected()) {
                seleccion = r.getText();
            }
        }

        boolean correcta = seleccion.equals(
                preguntaActual.getRespuestaCorrecta()
        );

        examen.registrarRespuesta(correcta);

        mostrarPregunta();
    }

    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}