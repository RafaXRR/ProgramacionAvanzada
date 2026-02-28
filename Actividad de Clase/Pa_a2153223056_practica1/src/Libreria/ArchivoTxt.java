package Libreria;

import java.io.*;
import java.util.ArrayList;

public class ArchivoTxt {

    public static void guardar(String ruta, ArrayList<String> datos){
        try(PrintWriter pw = new PrintWriter(new FileWriter(ruta))){
            for(String linea : datos)
                pw.println(linea);
        }catch(Exception e){ e.printStackTrace(); }
    }

    public static ArrayList<String> cargar(String ruta){
        ArrayList<String> lista = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(ruta))){
            String linea;
            while((linea = br.readLine()) != null)
                lista.add(linea);
        }catch(Exception e){}
        return lista;
    }
}