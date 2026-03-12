package Modelo;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class ModeloTabla {

DefaultTableModel modelo;

String columnas[]={
"D.A.",
"P.EDUCATIVO",
"LETRA",
"PROFESOR",
"MATERIA",
"Periodo",
"Materia",
"No.ACTA",
"MATRICULA",
"ALUMNO",
"CALIFICACION",
"OP.INS.",
"OP.EXA.",
"MES",
"CICLO ESCOLAR"
};

ArrayList<String[]> datos;

public ModeloTabla(ArrayList<String[]> datos){

modelo = new DefaultTableModel(columnas,0);

this.datos = datos;

for(String[] fila : datos){
modelo.addRow(fila);
}

}

public DefaultTableModel getModelo(){
return modelo;
}

private ArrayList getCarreras(){

ListaObjetos listacarreras = new ListaObjetos();

for(int i=1;i<modelo.getRowCount();i++){

String carrera = (String) modelo.getValueAt(i,1);

Carreras c = new Carreras();

c.setCarrera(carrera);

listacarreras.Insertar(c);

}

return listacarreras.getLista();

}

public DefaultListModel getModeloCarreras(){

DefaultListModel<Carreras> modeloCarreras = new DefaultListModel<>();

for(Object carrera : getCarreras())
modeloCarreras.addElement((Carreras)carrera);

return modeloCarreras;

}

private ArrayList getMaterias(){

ListaObjetos listamaterias = new ListaObjetos();

for(String[] fila : datos){

String materia = fila[4];
String carrera = fila[1];

Materias c = new Materias(materia,carrera);

listamaterias.Insertar(c);

}

return listamaterias.getLista();

}

public DefaultListModel getModeloMaterias(Carreras carrera){

DefaultListModel<Materias> modeloMaterias = new DefaultListModel<>();

for(Object materia : getMaterias()){

if(((Materias)materia).getCarrera().equals(carrera.getCarrera()))
modeloMaterias.addElement((Materias)materia);

}

return modeloMaterias;

}

private ArrayList getAsignaturas(){

ListaObjetos listaasignaturas = new ListaObjetos();

for(String[] fila : datos){

String materia = fila[4];
String carrera = fila[1];
String profesor = fila[3];
String grupo = fila[2];

Asignaturas c =
new Asignaturas(carrera,materia,profesor,grupo);

listaasignaturas.Insertar(c);

}

return listaasignaturas.getLista();

}

public DefaultListModel getModeloAsignaturas(Materias materia){

DefaultListModel<Asignaturas> modeloAsignaturas =
new DefaultListModel<>();

for(Object asignaturas : getAsignaturas()){

if(((Asignaturas)asignaturas).getCarrera().equals(materia.getCarrera()))
if(((Asignaturas)asignaturas).getMateria().equals(materia.getMateria()))
modeloAsignaturas.addElement((Asignaturas)asignaturas);

}

return modeloAsignaturas;

}

}