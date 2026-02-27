package MultipleChoiceExam;

import java.util.*;

public class Pregunta {

    private String enunciado;
    private String respuestaCorrecta;
    private String[] opciones;

    public Pregunta(String enunciado, String respuestaCorrecta, String[] distractores) {
        this.enunciado = enunciado;
        this.respuestaCorrecta = respuestaCorrecta;
        this.opciones = new String[4];

        opciones[0] = respuestaCorrecta;
        System.arraycopy(distractores, 0, opciones, 1, 3);

        List<String> lista = Arrays.asList(opciones);
        Collections.shuffle(lista);
        lista.toArray(opciones);
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public String[] getOpciones() {
        return opciones;
    }
}