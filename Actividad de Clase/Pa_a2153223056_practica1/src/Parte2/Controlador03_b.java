package Parte2;

import java.awt.event.*;

public class Controlador03_b implements ActionListener {

    private Vista03_b vista;
    private ListaCategorias lista = new ListaCategorias();

    public Controlador03_b(Vista03_b vista){
        this.vista = vista;
        vista.Bagregar.addActionListener(this);
        vista.Beliminar.addActionListener(this);
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
    }

    private void actualizarArea(){
        vista.area.setText("");
        for(Categoria c : lista.getLista()){
            vista.area.append(c.toString()+"\n");
        }
    }
}