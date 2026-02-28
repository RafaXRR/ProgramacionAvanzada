package Parte2;

import java.util.ArrayList;

public class ListaInsumos {

    private ArrayList<Insumo> lista = new ArrayList<>();

    public boolean agregar(Insumo insumo) {
        for (Insumo i : lista) {
            if (i.getId().equals(insumo.getId())) {
                return false;
            }
        }
        lista.add(insumo);
        return true;
    }

    public boolean eliminar(String id) {
        return lista.removeIf(i -> i.getId().equals(id));
    }

    public String mostrar() {
        StringBuilder sb = new StringBuilder();
        for (Insumo i : lista) {
            sb.append(i.getId())
              .append(" - ")
              .append(i.getNombre())
              .append(" - ")
              .append(i.getCategoria())
              .append("\n");
        }
        return sb.toString();
    }

    public ArrayList<Insumo> getLista() {
        return lista;
    }
}