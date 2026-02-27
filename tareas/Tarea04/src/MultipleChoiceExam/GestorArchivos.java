package MultipleChoiceExam;

import java.io.*;
import java.util.*;

public class GestorArchivos {

    public List<Pregunta> cargarExamen(File archivo) throws Exception {

        List<Pregunta> preguntas = new ArrayList<>();
        List<String> terminosA = new ArrayList<>();
        List<String> terminosB = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(archivo));

        String titulo = br.readLine();
        String encabezados = br.readLine();

        if (titulo == null || encabezados == null) {
            br.close();
            throw new Exception("El archivo no tiene formato válido.");
        }

        String linea;

        while ((linea = br.readLine()) != null) {

            String[] partes = linea.split(",");

            if (partes.length != 2) {
                br.close();
                throw new Exception("Formato incorrecto en línea: " + linea);
            }

            terminosA.add(partes[0].trim());
            terminosB.add(partes[1].trim());
        }

        br.close();

        if (terminosA.size() < 5) {
            throw new Exception("El archivo debe tener al menos 5 registros.");
        }

        for (int i = 0; i < terminosA.size(); i++) {
            String[] distractores = obtenerDistractores(terminosB, i);
            preguntas.add(new Pregunta(
                    terminosA.get(i),
                    terminosB.get(i),
                    distractores
            ));
        }

        return preguntas;
    }

    private String[] obtenerDistractores(List<String> lista, int indexCorrecto) {

        List<String> copia = new ArrayList<>(lista);
        copia.remove(indexCorrecto);

        Collections.shuffle(copia);

        return new String[]{
                copia.get(0),
                copia.get(1),
                copia.get(2)
        };
    }
}