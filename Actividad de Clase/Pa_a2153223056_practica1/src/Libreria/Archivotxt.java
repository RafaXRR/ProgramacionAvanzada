package Libreria;

import java.io.*;
import java.util.ArrayList;

public class Archivotxt {

    public static void guardar(String ruta, ArrayList<String> datos) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (String linea : datos) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> cargar(String ruta) {

        ArrayList<String> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }
}