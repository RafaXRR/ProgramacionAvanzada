package controlador;

import vista.*;
import modelo.*;

import java.awt.event.*;

public class ControladorMenu implements ActionListener {

    private FrmMenu vista;

    public ControladorMenu(FrmMenu v) {

        this.vista = v;
        this.vista.mCategorias.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        IfrmCategorias ifrm = new IfrmCategorias();
        ListaCategorias modelo = new ListaCategorias();
        new ControladorCategorias(modelo, ifrm);

        vista.escritorio.add(ifrm);
        ifrm.setVisible(true);
    }
}