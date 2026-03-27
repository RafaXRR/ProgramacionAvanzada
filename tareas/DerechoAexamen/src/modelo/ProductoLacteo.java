package modelo;

public class ProductoLacteo extends Producto {

    public ProductoLacteo(int id, String codigo, String nombre,
                      double precioCompra, double porcentajeGanancia,
                      int stock, String imagen, String unidadMedida) {

        super(id, codigo, nombre, "Lácteos y Huevo",
              precioCompra, porcentajeGanancia, stock, imagen, unidadMedida);
    }

    @Override
    public String getTipoConservacion() {
        return "Cadena de frío";
    }
}