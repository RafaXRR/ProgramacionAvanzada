package Tarea01;

public class Controlador {

    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.btnAgregar.addActionListener(e -> registrar());
        vista.comboTipo.addActionListener(e ->
                modelo.setTipoUsuario(
                        (String) vista.comboTipo.getSelectedItem()
                )
        );
        vista.chkEspecial.addActionListener(e ->
                modelo.setAccesoEspecial(
                        vista.chkEspecial.isSelected()
                )
        );
        vista.itemLimpiar.addActionListener(e -> limpiar());
    }

    private void registrar() {
        modelo.registrarVisita(vista.txtNombre.getText());
        actualizarLista();
        vista.txtNombre.setText("");
    }

    private void limpiar() {
        modelo.limpiarVisitas();
        actualizarLista();
    }

    private void actualizarLista() {
        vista.listModel.clear();
        for (String v : modelo.getVisitas()) {
            vista.listModel.addElement(v);
        }
    }
}
