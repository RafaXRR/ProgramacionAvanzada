package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JButton;

public class Vista_datos extends JFrame {

private JPanel contentPane;

private JList listacarrera;
private JList listamateria;
private JList listaAsignatura;

private JTable table;

private JButton btnCalcular;
private JButton btnCedula;

public Vista_datos() {

setTitle("Sistema de Calificaciones");
setBounds(100,100,900,600);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

contentPane = new JPanel();
setContentPane(contentPane);
contentPane.setLayout(null);

/* LISTAS */

listacarrera = new JList();
listacarrera.setBounds(10,10,250,150);
contentPane.add(listacarrera);

listamateria = new JList();
listamateria.setBounds(270,10,250,150);
contentPane.add(listamateria);

listaAsignatura = new JList();
listaAsignatura.setBounds(530,10,200,150);
contentPane.add(listaAsignatura);

/* BOTON CALCULAR */

btnCalcular = new JButton("Calcular Promedios");
btnCalcular.setBounds(740,30,140,40);
contentPane.add(btnCalcular);

/* BOTON CEDULA */

btnCedula = new JButton("Generar Cedula 3.3.2");
btnCedula.setBounds(740,90,140,40);
contentPane.add(btnCedula);

/* TABLA */

JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(10,180,870,380);
contentPane.add(scrollPane);

table = new JTable();
scrollPane.setViewportView(table);

}

/* GETTERS */

public JList getListacarrera() {
return listacarrera;
}

public JList getListamateria() {
return listamateria;
}

public JList getListaAsignatura() {
return listaAsignatura;
}

public JTable getTable() {
return table;
}

public JButton getBtnCalcular() {
return btnCalcular;
}

public JButton getBtnCedula() {
return btnCedula;
}

}