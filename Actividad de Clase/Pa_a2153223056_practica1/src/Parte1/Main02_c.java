package Parte1;

public class Main02_c {
    public static void main(String[] args) {
        Vista02_c vista = new Vista02_c();
        new Controlador02_c(vista);
        vista.setVisible(true);
    }
}