package MultipleChoiceExam;

import java.util.*;

public class Examen {

    private List<Pregunta> listaPreguntas;
    private int indiceActual;
    private int aciertos;
    private int intentos;

    public Examen(List<Pregunta> preguntas) {
        this.listaPreguntas = preguntas;
        Collections.shuffle(this.listaPreguntas);
        this.indiceActual = 0;
        this.aciertos = 0;
        this.intentos = 0;
    }

    public Pregunta obtenerSiguiente() {
        if (indiceActual < listaPreguntas.size()) {
            return listaPreguntas.get(indiceActual++);
        }
        return null;
    }

    public void registrarRespuesta(boolean correcta) {
        intentos++;
        if (correcta) {
            aciertos++;
        }
    }

    public double calcularPuntaje() {
        if (intentos == 0) return 0;
        return (double) aciertos / intentos * 100;
    }
}