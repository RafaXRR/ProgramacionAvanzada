package main;

import vista.*;
import controlador.*;

public class Main {

    public static void main(String[] args) {

        FrmMenu menu = new FrmMenu();
        new ControladorMenu(menu);

        menu.setVisible(true);
    }
}