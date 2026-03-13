package controlador;

import dao.ClienteDAO;
import modelo.Cliente;
import java.util.ArrayList;

public class ClienteControl {

    private ClienteDAO clienteDAO;

    public ClienteControl() {
        clienteDAO = new ClienteDAO();
    }

    public void registrarCliente(int id, String nombre, String telefono) {

        Cliente cliente = new Cliente();

        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);

        clienteDAO.guardarCliente(cliente);
    }

    public ArrayList<Cliente> obtenerClientes() {
        return clienteDAO.listarClientes();
    }

    public Cliente buscarCliente(int id) {
        return clienteDAO.buscarCliente(id);
    }

}