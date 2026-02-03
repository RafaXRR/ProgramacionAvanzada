package Tarea01;

public class Main {

    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Vista vista = new Vista();
        new Controlador(modelo, vista);
        vista.setVisible(true);
    }
}

