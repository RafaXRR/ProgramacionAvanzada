package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.*;

import java.io.*;
import java.util.ArrayList;

public class ArchivoJSONProductos {

    private final String ARCHIVO = "productos.json";
    private Gson gson;

    public ArchivoJSONProductos() {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public void guardar(ArrayList<Producto> lista) {

        ArrayList<ProductoJSON> jsons = new ArrayList<>();

        for (Producto p : lista) {
            ProductoJSON pj       = new ProductoJSON();
            pj.id                 = p.getId();
            pj.codigo             = p.getCodigo();
            pj.nombre             = p.getNombre();
            pj.categoria          = p.getCategoria();
            pj.precioCompra       = p.getPrecioCompra();
            pj.porcentajeGanancia = p.getPorcentajeGanancia();
            pj.stock              = p.getStock();
            pj.imagen             = p.getImagen();
            pj.unidadMedida       = p.getUnidadMedida();
            jsons.add(pj);
        }

        try (FileWriter writer = new FileWriter(ARCHIVO)) {
            gson.toJson(jsons, writer);
        } catch (Exception e) {
            System.out.println("Error al guardar productos.json: " + e.getMessage());
        }
    }

    public ArrayList<Producto> cargar() {

        ArrayList<Producto> lista = new ArrayList<>();

        try (FileReader reader = new FileReader(ARCHIVO)) {

            // Usamos array en lugar de TypeToken para evitar problemas con Java moderno
            ProductoJSON[] arreglo = gson.fromJson(reader, ProductoJSON[].class);

            if (arreglo == null) return lista;

            for (ProductoJSON pj : arreglo) {
                Producto p = crearProducto(pj);
                if (p != null) lista.add(p);
            }

        } catch (Exception e) {
            // Si no existe el archivo regresa lista vacía
        }

        return lista;
    }

    private Producto crearProducto(ProductoJSON pj) {
        switch (pj.categoria) {
            case "Despensa Básica":                return new ProductoDespensa(pj.id, pj.codigo, pj.nombre, pj.precioCompra, pj.porcentajeGanancia, pj.stock, pj.imagen, pj.unidadMedida);
            case "Lácteos y Huevo":                return new ProductoLacteo(pj.id, pj.codigo, pj.nombre, pj.precioCompra, pj.porcentajeGanancia, pj.stock, pj.imagen, pj.unidadMedida);
            case "Bebidas y Líquidos":             return new ProductoBebida(pj.id, pj.codigo, pj.nombre, pj.precioCompra, pj.porcentajeGanancia, pj.stock, pj.imagen, pj.unidadMedida);
            case "Botanas y Dulces":               return new ProductoBotana(pj.id, pj.codigo, pj.nombre, pj.precioCompra, pj.porcentajeGanancia, pj.stock, pj.imagen, pj.unidadMedida);
            case "Frutas y Verduras":              return new ProductoFrutaVerdura(pj.id, pj.codigo, pj.nombre, pj.precioCompra, pj.porcentajeGanancia, pj.stock, pj.imagen, pj.unidadMedida);
            case "Carnes y Salchichonería":        return new ProductoCarne(pj.id, pj.codigo, pj.nombre, pj.precioCompra, pj.porcentajeGanancia, pj.stock, pj.imagen, pj.unidadMedida);
            case "Cuidado del Hogar":              return new ProductoHogar(pj.id, pj.codigo, pj.nombre, pj.precioCompra, pj.porcentajeGanancia, pj.stock, pj.imagen, pj.unidadMedida);
            case "Higiene y Cuidado Personal":     return new ProductoHigiene(pj.id, pj.codigo, pj.nombre, pj.precioCompra, pj.porcentajeGanancia, pj.stock, pj.imagen, pj.unidadMedida);
            case "Alimentos Preparados/Enlatados": return new ProductoEnlatado(pj.id, pj.codigo, pj.nombre, pj.precioCompra, pj.porcentajeGanancia, pj.stock, pj.imagen, pj.unidadMedida);
            default: return null;
        }
    }
}