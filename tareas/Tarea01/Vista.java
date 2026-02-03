package Tarea01;

import javax.swing.*;
import java.awt.*;

public class Vista extends JFrame {

    private static final long serialVersionUID = 1L;

    public JTextField txtNombre;
    public JButton btnAgregar;
    public JCheckBox chkEspecial;
    public JComboBox<String> comboTipo;
    public JList<String> listVisitas;
    public DefaultListModel<String> listModel;
    public JMenuItem itemLimpiar;

    public Vista() {
        setTitle("Registro de Visitas - Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        // ===== COMPONENTES =====
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(15);

        JLabel lblTipo = new JLabel("Tipo de usuario:");
        comboTipo = new JComboBox<>(new String[]{
                "General", "Estudiante", "Docente", "Investigador"
        });

        chkEspecial = new JCheckBox("Acceso especial");
        btnAgregar = new JButton("Registrar visita");

        listModel = new DefaultListModel<>();
        listVisitas = new JList<>(listModel);

        // ===== CONSTRAINTS =====
        GridBagConstraints gbc;

        // Nombre label
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(lblNombre, gbc);

        // Nombre textfield
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(txtNombre, gbc);

        // Tipo label
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(lblTipo, gbc);

        // Combo tipo
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(comboTipo, gbc);

        // Checkbox
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(chkEspecial, gbc);

        // Botón
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(btnAgregar, gbc);

        // Lista
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(5,5,5,5);
        panel.add(new JScrollPane(listVisitas), gbc);

        setContentPane(panel);

        // ===== MENÚ =====
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        itemLimpiar = new JMenuItem("Limpiar visitas");

        menu.add(itemLimpiar);
        bar.add(menu);
        setJMenuBar(bar);
    }
}

