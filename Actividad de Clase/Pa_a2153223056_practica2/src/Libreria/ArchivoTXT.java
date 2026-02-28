package Libreria;

import java.io.*;

public class ArchivoTXT {

    private File archivo;

    public ArchivoTXT(String nombre) {
        archivo = new File(nombre);
    }

    public boolean existe() {
        return archivo.exists();
    }

    public void guardar(String datos) {
        try (FileWriter fw = new FileWriter(archivo)) {
            fw.write(datos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String cargar() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}