package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaUnidades extends JInternalFrame {

    public JTextField txtClave;
    public JTextField txtNombre;

    public JButton btnGuardar;
    public JButton btnLimpiar;
    public JButton btnEliminar;

    public JTable tabla;

    public VistaUnidades() {

        super("Unidades de Medida", true, true, true, true);

        setSize(550, 400);
        setLayout(new BorderLayout());

        add(crearFormulario(), BorderLayout.WEST);
        add(crearTabla(),      BorderLayout.CENTER);
    }

    private JPanel crearFormulario() {

        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createTitledBorder("Nueva Unidad"));
        form.setPreferredSize(new Dimension(200, 0));

        GridBagConstraints c = new GridBagConstraints();
        c.insets  = new Insets(8, 8, 8, 8);
        c.fill    = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;

        txtClave  = new JTextField();
        txtNombre = new JTextField();

        btnGuardar  = new JButton("💾 Guardar");
        btnLimpiar  = new JButton("🧹 Limpiar");
        btnEliminar = new JButton("🗑 Eliminar");

        c.gridx = 0; c.gridy = 0; form.add(new JLabel("Clave (Ej: KG):"), c);
        c.gridy = 1; form.add(txtClave, c);
        c.gridy = 2; form.add(new JLabel("Nombre (Ej: Kilogramo):"), c);
        c.gridy = 3; form.add(txtNombre, c);
        c.gridy = 4; form.add(btnGuardar, c);
        c.gridy = 5; form.add(btnLimpiar, c);
        c.gridy = 6; form.add(btnEliminar, c);

        return form;
    }

    private JPanel crearTabla() {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Clave");
        modelo.addColumn("Nombre");

        tabla = new JTable(modelo);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scroll = new JScrollPane(tabla);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Unidades Registradas"));
        panel.add(scroll, BorderLayout.CENTER);

        return panel;
    }
}
