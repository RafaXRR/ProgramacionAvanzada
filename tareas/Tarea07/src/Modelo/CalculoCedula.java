package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class CalculoCedula {

public static ArrayList<CedulaAcademia> calcular(ArrayList<IndicadorGrupo> indicadores){

HashMap<String,ArrayList<IndicadorGrupo>> mapa = new HashMap<>();

ArrayList<CedulaAcademia> resultado = new ArrayList<>();

for(IndicadorGrupo ind : indicadores){

String asignatura = ind.getAsignatura();

if(!mapa.containsKey(asignatura)){
mapa.put(asignatura,new ArrayList<>());
}

mapa.get(asignatura).add(ind);

}

for(String asignatura : mapa.keySet()){

ArrayList<IndicadorGrupo> lista = mapa.get(asignatura);

int grupos = lista.size();

double sumaProm = 0;
double sumaReprob = 0;
int profesores = lista.size();
int gruposArribaProm = 0;

for(IndicadorGrupo ind : lista){

sumaProm += ind.getPromedio();
sumaReprob += ind.getPorcentajeReprobados();

}

double promedio = sumaProm / grupos;

for(IndicadorGrupo ind : lista){

if(ind.getPromedio() > promedio){
gruposArribaProm++;
}

}

double porcentajeMayorPromedio = ((double)gruposArribaProm / grupos) * 100;
double porcentajeReprobacion = sumaReprob / grupos;

CedulaAcademia c = new CedulaAcademia(
asignatura,
grupos,
promedio,
porcentajeMayorPromedio,
porcentajeReprobacion,
profesores
);

resultado.add(c);

}

return resultado;

}

}