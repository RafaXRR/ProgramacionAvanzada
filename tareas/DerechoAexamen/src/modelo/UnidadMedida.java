package modelo;

public class UnidadMedida {

    private int id;
    private String clave;    // Ej: "PZA", "KG", "LT"
    private String nombre;   // Ej: "Pieza", "Kilogramo", "Litro"

    public UnidadMedida(int id, String clave, String nombre) {
        this.id = id;
        this.clave = clave;
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public String getClave() { return clave; }
    public String getNombre() { return nombre; }

    public void setClave(String clave) { this.clave = clave; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return clave + " - " + nombre;
    }
}