package vista;

import javax.swing.*;

public class FrmMenu extends JFrame {

    public JDesktopPane escritorio;
    public JMenuItem mCategorias;

    public FrmMenu() {

        setTitle("Sistema");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        escritorio = new JDesktopPane();
        add(escritorio);

        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Catalogos");

        mCategorias = new JMenuItem("Categorias");

        menu.add(mCategorias);
        barra.add(menu);

        setJMenuBar(barra);
    }
}