package controlador;

import dao.ProductoDAO;
import modelo.Producto;
import java.util.ArrayList;

public class ProductoControl {

    private ProductoDAO productoDAO;

    public ProductoControl(){
        productoDAO = new ProductoDAO();
    }

    public void registrarProducto(int id,String nombre,double precio){

        Producto p = new Producto();

        p.setId(id);
        p.setNombre(nombre);
        p.setPrecio(precio);

        productoDAO.guardarProducto(p);

    }

    public ArrayList<Producto> obtenerProductos(){
        return productoDAO.listarProductos();
    }

}