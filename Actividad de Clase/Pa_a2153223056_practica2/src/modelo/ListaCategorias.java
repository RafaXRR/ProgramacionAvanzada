package modelo;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ListaCategorias {

    private ArrayList<Categoria> lista;

    public ListaCategorias() {
        lista = new ArrayList<>();
    }

    public boolean existe(int id) {
        return lista.stream().anyMatch(c -> c.getId() == id);
    }

    public void agregar(Categoria c) {
        lista.add(c);
    }

    public void eliminar(int id) {
        lista.removeIf(c -> c.getId() == id);
    }

    public DefaultTableModel getModeloTabla() {

        String[] columnas = {"ID", "Categoria"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Categoria c : lista) {
            modelo.addRow(new Object[]{c.getId(), c.getNombre()});
        }

        return modelo;
    }

    public String toArchivo() {
        StringBuilder sb = new StringBuilder();
        for (Categoria c : lista) {
            sb.append(c.toArchivo()).append("\n");
        }
        return sb.toString();
    }
}