package modelo;

public class ProductoFrutaVerdura extends Producto {

    public ProductoFrutaVerdura(int id, String codigo, String nombre,
                      double precioCompra, double porcentajeGanancia,
                      int stock, String imagen, String unidadMedida) {

        super(id, codigo, nombre, "Frutas y Verduras",
              precioCompra, porcentajeGanancia, stock, imagen, unidadMedida);
    }

    @Override
    public String getTipoConservacion() {
        return "Perecedero";
    }
}