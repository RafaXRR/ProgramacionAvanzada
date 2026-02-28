package Parte2;

import java.util.ArrayList;

public class ListaCategorias {

    private ArrayList<Categoria> lista = new ArrayList<>();

    public boolean agregar(Categoria c){
        for(Categoria cat : lista){
            if(cat.getId().equals(c.getId()))
                return false;
        }
        lista.add(c);
        return true;
    }

    public void eliminar(String id){
        lista.removeIf(c -> c.getId().equals(id));
    }

    public ArrayList<Categoria> getLista(){
        return lista;
    }
}