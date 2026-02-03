package Tarea01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Modelo {

    private ArrayList<String> visitas;
    private String tipoUsuario;
    private boolean accesoEspecial;

    private DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Modelo() {
        visitas = new ArrayList<>();
        tipoUsuario = "General";
        accesoEspecial = false;
    }

    public void registrarVisita(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) return;

        String registro = nombre + " | " +
                tipoUsuario + " | " +
                LocalDateTime.now().format(formato) +
                (accesoEspecial ? " | Acceso especial" : "");

        visitas.add(registro);
    }

    public ArrayList<String> getVisitas() {
        return visitas;
    }

    public void limpiarVisitas() {
        visitas.clear();
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setAccesoEspecial(boolean accesoEspecial) {
        this.accesoEspecial = accesoEspecial;
    }
}
