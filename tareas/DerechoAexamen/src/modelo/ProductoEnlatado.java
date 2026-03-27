package modelo;

public class ProductoEnlatado extends Producto {

    public ProductoEnlatado(int id, String codigo, String nombre,
                      double precioCompra, double porcentajeGanancia,
                      int stock, String imagen, String unidadMedida) {

        super(id, codigo, nombre, "Alimentos Preparados/Enlatados",
              precioCompra, porcentajeGanancia, stock, imagen, unidadMedida);
    }

    @Override
    public String getTipoConservacion() {
        return "No perecedero";
    }
}