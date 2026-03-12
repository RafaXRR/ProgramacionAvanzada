package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class CalculoIndicadores {

	public static ArrayList<IndicadorGrupo> calcular(ArrayList<String[]> datos){

		ArrayList<IndicadorGrupo> resultados = new ArrayList<>();

		double suma = 0;
		int alumnos = 0;
		int reprobados = 0;
		double sumaAprobados = 0;
		int aprobados = 0;

		for(int i=1;i<datos.size();i++){

		String calificacion = datos.get(i)[10]; // columna calificacion

		if(calificacion == null || calificacion.equals("") || calificacion.equals("NP"))
		continue;

		double cal = Double.parseDouble(calificacion);

		suma += cal;
		alumnos++;

		if(cal < 7){
		reprobados++;
		}else{
		aprobados++;
		sumaAprobados += cal;
		}

		}

		if(alumnos == 0) alumnos = 1;

		double promedio = suma / alumnos;

		double porcentajeAprobados = (double)aprobados / alumnos * 100;
		double porcentajeReprobados = (double)reprobados / alumnos * 100;

		double promedioAprobados = 0;

		if(aprobados > 0)
		promedioAprobados = sumaAprobados / aprobados;

		IndicadorGrupo indicador = new IndicadorGrupo(
		"Profesor",
		"Materia",
		"Grupo",
		promedio,
		alumnos,
		reprobados,
		porcentajeAprobados,
		porcentajeReprobados,
		promedioAprobados
		);

		resultados.add(indicador);

		return resultados;

		}

}