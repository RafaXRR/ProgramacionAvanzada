package Librerias;

import java.io.*;
import java.util.ArrayList;

public class Libreria {

public static boolean ExisteArchivo(String narchivo){

File archivo = new File(narchivo);

return archivo.exists();

}

public static ArrayList<String[]> LeerDatosCSV(String narchivo){

ArrayList<String[]> lista = new ArrayList<>();

try(BufferedReader lector = new BufferedReader(new FileReader(narchivo))){

String linea;

while((linea=lector.readLine())!=null){

String datos[]=linea.split(",");

lista.add(datos);

}

}catch(Exception e){

System.out.println("Error "+e.getMessage());

}

return lista;

}

}