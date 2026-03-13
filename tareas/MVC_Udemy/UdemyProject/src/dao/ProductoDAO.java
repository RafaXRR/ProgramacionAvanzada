package dao;

import modelo.Producto;
import java.io.*;
import java.util.ArrayList;

public class ProductoDAO {

    private String archivo = "productos.txt";

    public void guardarProducto(Producto producto){

        try{

            FileWriter fw = new FileWriter(archivo,true);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(producto.getId()+","+
                       producto.getNombre()+","+
                       producto.getPrecio());

            pw.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public ArrayList<Producto> listarProductos(){

        ArrayList<Producto> lista = new ArrayList<>();

        try{

            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;

            while((linea = br.readLine()) != null){

                String datos[] = linea.split(",");

                Producto p = new Producto();

                p.setId(Integer.parseInt(datos[0]));
                p.setNombre(datos[1]);
                p.setPrecio(Double.parseDouble(datos[2]));

                lista.add(p);

            }

            br.close();

        }catch(Exception e){
        }

        return lista;
    }

}