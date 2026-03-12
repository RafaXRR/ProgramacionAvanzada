package Modelo;

public class IndicadorGrupo {

private String profesor;
private String asignatura;
private String grupo;

private double promedio;
private int alumnos;
private int reprobados;

private double porcentajeAprobados;
private double porcentajeReprobados;
private double promedioAprobados;

public IndicadorGrupo(String profesor, String asignatura, String grupo,
double promedio, int alumnos, int reprobados,
double porcentajeAprobados, double porcentajeReprobados,
double promedioAprobados) {

this.profesor = profesor;
this.asignatura = asignatura;
this.grupo = grupo;
this.promedio = promedio;
this.alumnos = alumnos;
this.reprobados = reprobados;
this.porcentajeAprobados = porcentajeAprobados;
this.porcentajeReprobados = porcentajeReprobados;
this.promedioAprobados = promedioAprobados;

}

public String getProfesor() {
return profesor;
}

public String getAsignatura() {
return asignatura;
}

public String getGrupo() {
return grupo;
}

public double getPromedio() {
return promedio;
}

public int getAlumnos() {
return alumnos;
}

public int getReprobados() {
return reprobados;
}

public double getPorcentajeAprobados() {
return porcentajeAprobados;
}

public double getPorcentajeReprobados() {
return porcentajeReprobados;
}

public double getPromedioAprobados() {
return promedioAprobados;
}

}