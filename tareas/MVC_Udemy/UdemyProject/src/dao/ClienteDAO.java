package dao;

import modelo.Cliente;
import java.io.*;
import java.util.ArrayList;

public class ClienteDAO {

    private String archivo = "clientes.txt";

    public void guardarCliente(Cliente cliente) {

        try {

            FileWriter fw = new FileWriter(archivo, true);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(cliente.getId() + "," +
                       cliente.getNombre() + "," +
                       cliente.getTelefono());

            pw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Cliente> listarClientes() {

        ArrayList<Cliente> lista = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;

            while ((linea = br.readLine()) != null) {

                String datos[] = linea.split(",");

                Cliente c = new Cliente();

                c.setId(Integer.parseInt(datos[0]));
                c.setNombre(datos[1]);
                c.setTelefono(datos[2]);

                lista.add(c);
            }

            br.close();

        } catch (Exception e) {
        }

        return lista;

    }

    public Cliente buscarCliente(int id) {

        ArrayList<Cliente> lista = listarClientes();

        for (Cliente c : lista) {

            if (c.getId() == id) {
                return c;
            }

        }

        return null;
    }

}