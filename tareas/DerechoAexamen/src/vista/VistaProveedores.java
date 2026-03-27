package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaProveedores extends JInternalFrame {

    public JTextField txtNombre;
    public JTextField txtContacto;
    public JTextField txtTelefono;
    public JTextField txtCorreo;
    public JTextField txtDireccion;
    public JTextField txtRfc;
    public JComboBox<String> comboTermino;

    public JButton btnGuardar;
    public JButton btnLimpiar;
    public JButton btnEliminar;

    public JTable tabla;
    public JTextField txtBuscar;
    public JButton btnBuscar;

    public VistaProveedores() {

        super("Proveedores", true, true, true, true);

        setSize(950, 550);
        setLayout(new BorderLayout());

        add(crearFormulario(), BorderLayout.WEST);
        add(crearTabla(),      BorderLayout.CENTER);
    }

    private JPanel crearFormulario() {

        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createTitledBorder("Datos del Proveedor"));
        form.setPreferredSize(new Dimension(270, 0));

        GridBagConstraints c = new GridBagConstraints();
        c.insets  = new Insets(5, 5, 5, 5);
        c.fill    = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;

        txtNombre    = new JTextField();
        txtContacto  = new JTextField();
        txtTelefono  = new JTextField();
        txtCorreo    = new JTextField();
        txtDireccion = new JTextField();
        txtRfc       = new JTextField();

        comboTermino = new JComboBox<>(new String[]{
                "Contado", "15 días", "30 días", "60 días"
        });

        btnGuardar  = new JButton("💾 Guardar");
        btnLimpiar  = new JButton("🧹 Limpiar");
        btnEliminar = new JButton("🗑 Eliminar");

        int fila = 0;
        agregar(form, c, new JLabel("Nombre:"),       0, fila);
        agregar(form, c, txtNombre,                   1, fila++);

        agregar(form, c, new JLabel("Contacto:"),     0, fila);
        agregar(form, c, txtContacto,                 1, fila++);

        agregar(form, c, new JLabel("Teléfono:"),     0, fila);
        agregar(form, c, txtTelefono,                 1, fila++);

        agregar(form, c, new JLabel("Correo:"),       0, fila);
        agregar(form, c, txtCorreo,                   1, fila++);

        agregar(form, c, new JLabel("Dirección:"),    0, fila);
        agregar(form, c, txtDireccion,                1, fila++);

        agregar(form, c, new JLabel("RFC:"),          0, fila);
        agregar(form, c, txtRfc,                      1, fila++);

        agregar(form, c, new JLabel("Término Pago:"), 0, fila);
        agregar(form, c, comboTermino,                1, fila++);

        agregar(form, c, btnGuardar,  0, fila);
        agregar(form, c, btnLimpiar,  1, fila++);

        c.gridx = 0; c.gridy = fila; c.gridwidth = 2;
        form.add(btnEliminar, c);

        return form;
    }

    private JPanel crearTabla() {

        JPanel barraBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtBuscar = new JTextField(15);
        btnBuscar = new JButton("🔍 Buscar");
        barraBusqueda.add(new JLabel("Buscar:"));
        barraBusqueda.add(txtBuscar);
        barraBusqueda.add(btnBuscar);

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };

        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Contacto");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Correo");
        modelo.addColumn("RFC");
        modelo.addColumn("Término");

        tabla = new JTable(modelo);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.getTableHeader().setReorderingAllowed(false);

        JScrollPane scroll = new JScrollPane(tabla);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Lista de Proveedores"));
        panel.add(barraBusqueda, BorderLayout.NORTH);
        panel.add(scroll,        BorderLayout.CENTER);

        return panel;
    }

    private void agregar(JPanel panel, GridBagConstraints c,
                         Component comp, int x, int y) {
        c.gridx    = x;
        c.gridy    = y;
        c.gridwidth = 1;
        panel.add(comp, c);
    }
}