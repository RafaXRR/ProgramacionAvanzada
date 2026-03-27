package modelo;

public abstract class Producto {

    protected int id;
    protected String codigo;
    protected String nombre;
    protected String categoria;
    protected double precioCompra;
    protected double porcentajeGanancia;
    protected int stock;
    protected String imagen;
    protected String unidadMedida;

    public Producto(int id, String codigo, String nombre, String categoria,
                    double precioCompra, double porcentajeGanancia,
                    int stock, String imagen, String unidadMedida) {

        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioCompra = precioCompra;
        this.porcentajeGanancia = porcentajeGanancia;
        this.stock = stock;
        this.imagen = imagen;
        this.unidadMedida = unidadMedida;
    }

    // Precio de venta calculado automáticamente
    public double getPrecioVenta() {
        return precioCompra * (1 + porcentajeGanancia / 100.0);
    }

    // Método abstracto — cada categoría puede definir su conservación
    public abstract String getTipoConservacion();

    // ── GETTERS ──────────────────────────────────────────────────

    public int getId() { return id; }
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public double getPrecioCompra() { return precioCompra; }
    public double getPorcentajeGanancia() { return porcentajeGanancia; }
    public int getStock() { return stock; }
    public String getImagen() { return imagen; }
    public String getUnidadMedida() { return unidadMedida; }

    // ── SETTERS ──────────────────────────────────────────────────

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecioCompra(double precioCompra) { this.precioCompra = precioCompra; }
    public void setPorcentajeGanancia(double porcentajeGanancia) { this.porcentajeGanancia = porcentajeGanancia; }
    public void setStock(int stock) { this.stock = stock; }
    public void setImagen(String imagen) { this.imagen = imagen; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }
}