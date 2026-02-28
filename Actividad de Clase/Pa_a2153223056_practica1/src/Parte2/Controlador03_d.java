package Parte2;

import java.awt.event.*;
import java.util.ArrayList;
import Libreria.ArchivoTxt;

public class Controlador03_d implements ActionListener {

    private Vista03_d vista;
    private ListaInsumos lista = new ListaInsumos();
    private final String RUTA = "insumos.txt";

    public Controlador03_d(Vista03_d vista){
        this.vista = vista;

        vista.Bagregar.addActionListener(this);
        vista.Beliminar.addActionListener(this);

        cargarArchivo();
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == vista.Bagregar){

            Insumo i = new Insumo(
                vista.Tid.getText(),
                vista.Tnombre.getText(),
                vista.ComboCategoria.getSelectedItem().toString()
            );

            if(lista.agregar(i)){
                actualizarArea();
            }
        }

        if(e.getSource() == vista.Beliminar){
            lista.eliminar(vista.Tid.getText());
            actualizarArea();
        }
    }

    private void actualizarArea(){
        vista.area.setText("");
        ArrayList<String> datos = new ArrayList<>();

        for(Insumo i : lista.getLista()){
            vista.area.append(i.toString()+"\n");
            datos.add(i.getId()+","+i.getNombre()+","+i.getCategoria());
        }

        ArchivoTxt.guardar(RUTA, datos);
    }

    private void cargarArchivo(){

        for(String linea : ArchivoTxt.cargar(RUTA)){
            String[] p = linea.split(",");
            if(p.length == 3){
                lista.agregar(new Insumo(p[0],p[1],p[2]));
            }
        }
        actualizarArea();
    }
}