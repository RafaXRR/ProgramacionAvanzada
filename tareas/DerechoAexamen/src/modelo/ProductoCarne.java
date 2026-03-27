package modelo;

public class ProductoCarne extends Producto {

    public ProductoCarne(int id, String codigo, String nombre,
                      double precioCompra, double porcentajeGanancia,
                      int stock, String imagen, String unidadMedida) {

        super(id, codigo, nombre, "Carnes y Salchichonería",
              precioCompra, porcentajeGanancia, stock, imagen, unidadMedida);
    }

    @Override
    public String getTipoConservacion() {
        return "Congelado / Fresco";
    }
}