package controlador;

import dao.VentaDAO;
import modelo.Venta;

public class VentaControl {

    private VentaDAO ventaDAO;

    public VentaControl(){
        ventaDAO = new VentaDAO();
    }

    public void registrarVenta(int idVenta,int idCliente,double total){

        Venta v = new Venta();

        v.setIdVenta(idVenta);
        v.setIdCliente(idCliente);
        v.setTotal(total);

        ventaDAO.guardarVenta(v);

    }

}