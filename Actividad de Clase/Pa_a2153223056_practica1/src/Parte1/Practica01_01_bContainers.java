package Parte1;

import javax.swing.*;

public class Practica01_01_bContainers extends JFrame {

    public Practica01_01_bContainers() {

        setTitle("Practica01_01_b");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panel1 = new JPanel();
        tabbedPane.addTab("Panel", panel1);

        JTextArea area = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(area);
        tabbedPane.addTab("Scroll", scrollPane);

        JDesktopPane desktopPane = new JDesktopPane();
        JInternalFrame internal = new JInternalFrame("Interna", true, true, true, true);
        internal.setBounds(20, 20, 200, 150);
        internal.setVisible(true);
        desktopPane.add(internal);
        tabbedPane.addTab("Desktop", desktopPane);

        setContentPane(tabbedPane);
    }

    public static void main(String[] args) {
        new Practica01_01_bContainers().setVisible(true);
    }
}
