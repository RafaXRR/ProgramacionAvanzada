package Controlador;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Librerias.Libreria;
import Modelo.CalculoCedula;
import Modelo.CalculoIndicadores;
import Modelo.Carreras;
import Modelo.CedulaAcademia;
import Modelo.IndicadorGrupo;
import Modelo.Materias;
import Modelo.ModeloTabla;
import Vista.Vista_datos;

public class Cejemplotabla {

String archivo = "ReporteInscripcionCalificaciones_2025_1.csv";

ModeloTabla modelo;
Vista_datos vista;
ArrayList<String[]> datos;

public Cejemplotabla() {

datos = new ArrayList<>();

if (Libreria.ExisteArchivo(archivo)) {
datos = Libreria.LeerDatosCSV(archivo);
}

modelo = new ModeloTabla(datos);

vista = new Vista_datos();
vista.setVisible(true);

/* LISTA CARRERAS */

vista.getListacarrera().setModel(modelo.getModeloCarreras());

vista.getListacarrera().addListSelectionListener(e -> {

if (!e.getValueIsAdjusting()) {

Carreras carrera = (Carreras) vista.getListacarrera().getSelectedValue();

vista.getListamateria().setModel(modelo.getModeloMaterias(carrera));

}

});

/* LISTA MATERIAS */

vista.getListamateria().addListSelectionListener(e -> {

if (!e.getValueIsAdjusting()) {

Materias materia = (Materias) vista.getListamateria().getSelectedValue();

vista.getListaAsignatura().setModel(modelo.getModeloAsignaturas(materia));

}

});

/* BOTON CALCULAR PROMEDIOS */

vista.getBtnCalcular().addActionListener(e -> {

ArrayList<IndicadorGrupo> indicadores = CalculoIndicadores.calcular(datos);

mostrarIndicadores(indicadores);

});

/* BOTON CEDULA 3.3.2 */

vista.getBtnCedula().addActionListener(e -> {

ArrayList<IndicadorGrupo> indicadores = CalculoIndicadores.calcular(datos);

ArrayList<CedulaAcademia> cedula = CalculoCedula.calcular(indicadores);

mostrarCedula(cedula);

});

}

/* TABLA INDICADORES */

private void mostrarIndicadores(ArrayList<IndicadorGrupo> indicadores) {

String columnas[] = {
"Profesor",
"Asignatura",
"Grupo",
"Promedio",
"Alumnos",
"Reprobados",
"% Aprobados",
"% Reprobados",
"Promedio Aprobados"
};

DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

for (IndicadorGrupo i : indicadores) {

Object fila[] = {
i.getProfesor(),
i.getAsignatura(),
i.getGrupo(),
i.getPromedio(),
i.getAlumnos(),
i.getReprobados(),
i.getPorcentajeAprobados(),
i.getPorcentajeReprobados(),
i.getPromedioAprobados()
};

modeloTabla.addRow(fila);

}

vista.getTable().setModel(modeloTabla);

}

/* TABLA CEDULA */

private void mostrarCedula(ArrayList<CedulaAcademia> datosCedula) {

String columnas[] = {
"Asignatura",
"Grupos",
"Promedio",
"% Mayor Promedio",
"% Reprobacion",
"Profesores"
};

DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

for (CedulaAcademia c : datosCedula) {

Object fila[] = {
c.getAsignatura(),
c.getGrupos(),
c.getPromedio(),
c.getPorcentajeMayorPromedio(),
c.getPorcentajeReprobacion(),
c.getProfesores()
};

modeloTabla.addRow(fila);

}

vista.getTable().setModel(modeloTabla);

}

}