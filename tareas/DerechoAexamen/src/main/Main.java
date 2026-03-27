package main;

import modelo.Inventario;
import modelo.Producto;
import modelo.Proveedor;
import modelo.DatosIniciales;
import persistencia.ArchivoJSONProductos;
import persistencia.ArchivoJSONProveedores;
import vista.VentanaPrincipal;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Inventario inventario = new Inventario();

        // ── CARGAR PRODUCTOS ──────────────────────────────────────
        ArchivoJSONProductos archivoProductos = new ArchivoJSONProductos();
        ArrayList<Producto> productos = archivoProductos.cargar();

        if (productos.isEmpty()) {
            DatosIniciales.cargarProductos(inventario);
            archivoProductos.guardar(inventario.getLista());
        } else {
            inventario.getLista().addAll(productos);
        }

        // ── CARGAR PROVEEDORES ────────────────────────────────────
        ArchivoJSONProveedores archivoProveedores = new ArchivoJSONProveedores();
        ArrayList<Proveedor> proveedores = archivoProveedores.cargar();

        if (proveedores.isEmpty()) {
            DatosIniciales.cargarProveedoresEjemplo(inventario);
            archivoProveedores.guardar(inventario.getProveedores());
        } else {
            inventario.getProveedores().addAll(proveedores);
        }

        // ── ABRIR SISTEMA ─────────────────────────────────────────
        VentanaPrincipal ventana = new VentanaPrincipal(inventario);
        ventana.setVisible(true);
    }
}