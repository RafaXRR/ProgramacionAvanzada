package Parte2;

import java.awt.event.*;

public class Controlador03_a implements ActionListener {

    private Vista03_a vista;
    private ListaInsumos lista = new ListaInsumos();

    public Controlador03_a(Vista03_a vista){
        this.vista = vista;
        vista.Bagregar.addActionListener(this);
        vista.Beliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == vista.Bagregar){
            Insumo i = new Insumo(
                vista.Tid.getText(),
                vista.Tnombre.getText(),
                vista.combo.getSelectedItem().toString()
            );

            if(lista.agregar(i))
                actualizarArea();
        }

        if(e.getSource() == vista.Beliminar){
            lista.eliminar(vista.Tid.getText());
            actualizarArea();
        }
    }

    private void actualizarArea(){
        vista.area.setText("");
        for(Insumo i : lista.getLista()){
            vista.area.append(i.toString()+"\n");
        }
    }
}