package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.Proveedor;

import java.io.*;
import java.util.ArrayList;

public class ArchivoJSONProveedores {

    private final String ARCHIVO = "proveedores.json";
    private Gson gson;

    public ArchivoJSONProveedores() {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public void guardar(ArrayList<Proveedor> lista) {

        ProveedorJSON[] arreglo = new ProveedorJSON[lista.size()];

        for (int i = 0; i < lista.size(); i++) {
            Proveedor p        = lista.get(i);
            ProveedorJSON pj   = new ProveedorJSON();
            pj.id              = p.getId();
            pj.codigo          = p.getCodigo();
            pj.nombre          = p.getNombre();
            pj.contacto        = p.getContacto();
            pj.telefono        = p.getTelefono();
            pj.correo          = p.getCorreo();
            pj.direccion       = p.getDireccion();
            pj.rfc             = p.getRfc();
            pj.terminoPago     = p.getTerminoPago();
            arreglo[i]         = pj;
        }

        try (FileWriter writer = new FileWriter(ARCHIVO)) {
            gson.toJson(arreglo, writer);
        } catch (Exception e) {
            System.out.println("Error al guardar proveedores.json: " + e.getMessage());
        }
    }

    public ArrayList<Proveedor> cargar() {

        ArrayList<Proveedor> lista = new ArrayList<>();

        try (FileReader reader = new FileReader(ARCHIVO)) {

            ProveedorJSON[] arreglo = gson.fromJson(reader, ProveedorJSON[].class);

            if (arreglo == null) return lista;

            for (ProveedorJSON pj : arreglo) {
                lista.add(new Proveedor(pj.id, pj.codigo, pj.nombre,
                        pj.contacto, pj.telefono, pj.correo,
                        pj.direccion, pj.rfc, pj.terminoPago));
            }

        } catch (Exception e) {
            // Si no existe el archivo regresa lista vacía
        }

        return lista;
    }

    private static class ProveedorJSON {
        public int id;
        public String codigo;
        public String nombre;
        public String contacto;
        public String telefono;
        public String correo;
        public String direccion;
        public String rfc;
        public String terminoPago;
    }
}