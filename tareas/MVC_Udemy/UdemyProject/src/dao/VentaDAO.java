package dao;

import modelo.Venta;
import java.io.FileWriter;
import java.io.PrintWriter;

public class VentaDAO {

    private String archivo = "ventas.txt";

    public void guardarVenta(Venta venta){

        try{

            FileWriter fw = new FileWriter(archivo,true);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(
                    venta.getIdVenta() + "," +
                    venta.getIdCliente() + "," +
                    venta.getTotal()
            );

            pw.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}