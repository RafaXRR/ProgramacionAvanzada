package Modelo;

public class CedulaAcademia {

private String asignatura;
private int grupos;
private double promedio;
private double porcentajeMayorPromedio;
private double porcentajeReprobacion;
private int profesores;

public CedulaAcademia(String asignatura,int grupos,double promedio,double porcentajeMayorPromedio,double porcentajeReprobacion,int profesores){

this.asignatura = asignatura;
this.grupos = grupos;
this.promedio = promedio;
this.porcentajeMayorPromedio = porcentajeMayorPromedio;
this.porcentajeReprobacion = porcentajeReprobacion;
this.profesores = profesores;

}

public String getAsignatura() {
return asignatura;
}

public int getGrupos() {
return grupos;
}

public double getPromedio() {
return promedio;
}

public double getPorcentajeMayorPromedio() {
return porcentajeMayorPromedio;
}

public double getPorcentajeReprobacion() {
return porcentajeReprobacion;
}

public int getProfesores() {
return profesores;
}

}