package Modelo;

import java.util.Objects;

public class Asignaturas {

String carrera;
String materia;
String profesor;
String grupo;

public Asignaturas(String carrera, String materia, String profesor, String grupo) {
	this.carrera = carrera;
	this.materia = materia;
	this.profesor = profesor;
	this.grupo = grupo;
}

public String getCarrera() {
	return carrera;
}

public void setCarrera(String carrera) {
	this.carrera = carrera;
}

public String getMateria() {
	return materia;
}

public void setMateria(String materia) {
	this.materia = materia;
}

public String getProfesor() {
	return profesor;
}

public void setProfesor(String profesor) {
	this.profesor = profesor;
}

public String getGrupo() {
	return grupo;
}

public void setGrupo(String grupo) {
	this.grupo = grupo;
}

@Override
public String toString() {
	return this.grupo+" - "+this.getProfesor();
}

@Override
public int hashCode() {
	return Objects.hash(carrera, grupo, materia);
}

@Override
public boolean equals(Object obj) {

	if (this == obj)
		return true;

	if (obj == null)
		return false;

	if (getClass() != obj.getClass())
		return false;

	Asignaturas other = (Asignaturas) obj;

	return Objects.equals(carrera, other.carrera) &&
		   Objects.equals(grupo, other.grupo) &&
		   Objects.equals(materia, other.materia);
}

}