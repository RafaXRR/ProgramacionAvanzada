package modelo;

public class Venta {

    private int idVenta;
    private int idCliente;
    private double total;

    public Venta() {
    }

    public Venta(int idVenta, int idCliente, double total) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.total = total;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}