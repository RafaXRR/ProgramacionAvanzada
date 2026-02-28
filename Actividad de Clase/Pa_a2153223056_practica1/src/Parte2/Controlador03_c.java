package Parte2;

import java.awt.event.*;
import java.util.ArrayList;
import Libreria.ArchivoTxt;

public class Controlador03_c implements ActionListener {

    private Vista03_c vista;
    private ListaCategorias lista = new ListaCategorias();
    private final String RUTA = "categorias.txt";

    public Controlador03_c(Vista03_c vista){
        this.vista = vista;

        vista.Bagregar.addActionListener(this);
        vista.Beliminar.addActionListener(this);
        vista.Bguardar.addActionListener(this);
        vista.Bcargar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == vista.Bagregar){
            Categoria c = new Categoria(
                vista.Tid.getText(),
                vista.Tnombre.getText()
            );
            if(lista.agregar(c))
                actualizarArea();
        }

        if(e.getSource() == vista.Beliminar){
            lista.eliminar(vista.Tid.getText());
            actualizarArea();
        }

        if(e.getSource() == vista.Bguardar){
            guardarArchivo();
        }

        if(e.getSource() == vista.Bcargar){
            cargarArchivo();
        }
    }

    private void actualizarArea(){
        vista.area.setText("");
        for(Categoria c : lista.getLista()){
            vista.area.append(c.toString()+"\n");
        }
    }

    private void guardarArchivo(){
        ArrayList<String> datos = new ArrayList<>();
        for(Categoria c : lista.getLista()){
            datos.add(c.getId()+","+c.getNombre());
        }
        ArchivoTxt.guardar(RUTA, datos);
    }

    private void cargarArchivo(){
        lista.getLista().clear();
        for(String linea : ArchivoTxt.cargar(RUTA)){
            String[] p = linea.split(",");
            if(p.length == 2)
                lista.agregar(new Categoria(p[0],p[1]));
        }
        actualizarArea();
    }
}