package modelo;

public class ProductoDespensa extends Producto {

    public ProductoDespensa(int id, String codigo, String nombre,
                      double precioCompra, double porcentajeGanancia,
                      int stock, String imagen, String unidadMedida) {

        super(id, codigo, nombre, "Despensa Básica",
              precioCompra, porcentajeGanancia, stock, imagen, unidadMedida);
    }

    @Override
    public String getTipoConservacion() {
        return "No perecedero";
    }
}