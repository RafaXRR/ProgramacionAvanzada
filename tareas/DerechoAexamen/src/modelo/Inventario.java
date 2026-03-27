package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventario {

    private ArrayList<Producto> productos;
    private ArrayList<Proveedor> proveedores;
    private ArrayList<UnidadMedida> unidades;

    public Inventario() {
        productos  = new ArrayList<>();
        proveedores = new ArrayList<>();
        unidades   = new ArrayList<>();
        cargarUnidadesPredeterminadas();
    }

    // ── UNIDADES PREDETERMINADAS ──────────────────────────────────

    private void cargarUnidadesPredeterminadas() {
        unidades.add(new UnidadMedida(1, "PZA", "Pieza"));
        unidades.add(new UnidadMedida(2, "KG",  "Kilogramo"));
        unidades.add(new UnidadMedida(3, "GR",  "Gramo"));
        unidades.add(new UnidadMedida(4, "LT",  "Litro"));
        unidades.add(new UnidadMedida(5, "ML",  "Mililitro"));
        unidades.add(new UnidadMedida(6, "CJA", "Caja"));
        unidades.add(new UnidadMedida(7, "PAQ", "Paquete"));
        unidades.add(new UnidadMedida(8, "DOC", "Docena"));
        unidades.add(new UnidadMedida(9, "LTA", "Lata"));
        unidades.add(new UnidadMedida(10,"BOL", "Bolsa"));
    }

    // ── PRODUCTOS ────────────────────────────────────────────────

    public ArrayList<Producto> getLista() { return productos; }

    public void agregar(Producto p) { productos.add(p); }

    public Producto buscarProducto(int id) {
        for (Producto p : productos)
            if (p.getId() == id) return p;
        return null;
    }

    public boolean eliminarProducto(int id) {
        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) { it.remove(); return true; }
        }
        return false;
    }

    public boolean actualizarProducto(Producto nuevo) {
        for (Producto p : productos) {
            if (p.getId() == nuevo.getId()) {
                p.setNombre(nuevo.getNombre());
                p.setPrecioCompra(nuevo.getPrecioCompra());
                p.setPorcentajeGanancia(nuevo.getPorcentajeGanancia());
                p.setStock(nuevo.getStock());
                p.setUnidadMedida(nuevo.getUnidadMedida());
                return true;
            }
        }
        return false;
    }

    public int generarIdProducto() {
        int max = 0;
        for (Producto p : productos) if (p.getId() > max) max = p.getId();
        return max + 1;
    }

    public ArrayList<Producto> filtrarPorCategoria(String categoria) {
        ArrayList<Producto> filtrados = new ArrayList<>();
        for (Producto p : productos)
            if (p.getCategoria().equals(categoria)) filtrados.add(p);
        return filtrados;
    }

    public ArrayList<Producto> filtrarPorStockMinimo(int minimo) {
        ArrayList<Producto> filtrados = new ArrayList<>();
        for (Producto p : productos)
            if (p.getStock() <= minimo) filtrados.add(p);
        return filtrados;
    }

    // ── PROVEEDORES ───────────────────────────────────────────────

    public ArrayList<Proveedor> getProveedores() { return proveedores; }

    public void agregarProveedor(Proveedor prov) { proveedores.add(prov); }

    public Proveedor buscarProveedor(int id) {
        for (Proveedor prov : proveedores)
            if (prov.getId() == id) return prov;
        return null;
    }

    public boolean eliminarProveedor(int id) {
        Iterator<Proveedor> it = proveedores.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) { it.remove(); return true; }
        }
        return false;
    }

    public int generarIdProveedor() {
        int max = 0;
        for (Proveedor prov : proveedores) if (prov.getId() > max) max = prov.getId();
        return max + 1;
    }

    // ── UNIDADES DE MEDIDA ────────────────────────────────────────

    public ArrayList<UnidadMedida> getUnidades() { return unidades; }

    public void agregarUnidad(UnidadMedida u) { unidades.add(u); }

    public boolean eliminarUnidad(int id) {
        Iterator<UnidadMedida> it = unidades.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) { it.remove(); return true; }
        }
        return false;
    }

    public int generarIdUnidad() {
        int max = 0;
        for (UnidadMedida u : unidades) if (u.getId() > max) max = u.getId();
        return max + 1;
    }

    public String[] getClaveUnidades() {
        String[] claves = new String[unidades.size()];
        for (int i = 0; i < unidades.size(); i++)
            claves[i] = unidades.get(i).getClave();
        return claves;
    }
}