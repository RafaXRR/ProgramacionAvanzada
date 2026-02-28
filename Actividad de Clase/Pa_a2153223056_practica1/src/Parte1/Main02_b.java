package Parte1;

public class Main02_b {
    public static void main(String[] args) {
        Vista02_b vista = new Vista02_b();
        new Controlador02_b(vista);
        vista.setVisible(true);
    }
}