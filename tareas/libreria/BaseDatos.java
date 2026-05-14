package libreria;
import java.sql.*;
import java.util.*;
import java.lang.reflect.*;

public class BaseDatos {

    private Connection conexion;

    public BaseDatos(Connection conexion) {
        this.conexion = conexion;
    }

    // =========================
    // consulta normal con ?
    // =========================
    public ArrayList<String[]> consultar(String sql, Object[] parametros) {
        ArrayList<String[]> resultados = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            // meter los valores en los ?
            if (parametros != null) {
                for (int i = 0; i < parametros.length; i++) {
                    ps.setObject(i + 1, parametros[i]);
                }
            }

            ResultSet rs = ps.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int columnas = meta.getColumnCount();

            // recorrer resultados
            while (rs.next()) {
                String[] fila = new String[columnas];

                for (int i = 0; i < columnas; i++) {
                    fila[i] = String.valueOf(rs.getObject(i + 1));
                }

                resultados.add(fila);
            }

        } catch (SQLException e) {
            System.out.println("Error en consultar: " + e.getMessage());
        }

        return resultados;
    }

    // =========================
    // consulta pero ya como objeto
    // =========================
    public <T> ArrayList<T> consultarAObjeto(String sql, Object[] parametros, Class<T> clase) {
        ArrayList<T> lista = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            // meter parametros
            if (parametros != null) {
                for (int i = 0; i < parametros.length; i++) {
                    ps.setObject(i + 1, parametros[i]);
                }
            }

            ResultSet rs = ps.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int columnas = meta.getColumnCount();

            Field[] campos = clase.getDeclaredFields();

            // recorrer filas
            while (rs.next()) {

                T objeto = clase.getDeclaredConstructor().newInstance();

                for (int i = 0; i < columnas; i++) {

                    String nombreColumna = meta.getColumnName(i + 1);
                    Object valor = rs.getObject(i + 1);

                    // buscar el campo que coincida
                    for (Field campo : campos) {

                        if (campo.getName().equalsIgnoreCase(nombreColumna)) {
                            campo.setAccessible(true);
                            campo.set(objeto, valor);
                            break;
                        }
                    }
                }

                lista.add(objeto);
            }

        } catch (Exception e) {
            System.out.println("Error en consultarAObjeto: " + e.getMessage());
        }

        return lista;
    }

    // =========================
    // actualizar varios campos
    // =========================
    public int modificar(String tabla, Map<String, Object> valores, String condicion, Object[] paramsCondicion) {

        if (valores == null || valores.isEmpty()) {
            return 0;
        }

        StringBuilder sql = new StringBuilder("UPDATE ");
        sql.append(tabla).append(" SET ");

        List<Object> parametros = new ArrayList<>();

        int i = 0;

        // armar SET campo = ?
        for (String campo : valores.keySet()) {

            sql.append(campo).append(" = ?");
            parametros.add(valores.get(campo));

            i++;
            if (i < valores.size()) {
                sql.append(", ");
            }
        }

        sql.append(" WHERE ").append(condicion);

        // agregar parametros del WHERE
        if (paramsCondicion != null) {
            parametros.addAll(Arrays.asList(paramsCondicion));
        }

        try (PreparedStatement ps = conexion.prepareStatement(sql.toString())) {

            // meter todos los valores
            for (int j = 0; j < parametros.size(); j++) {
                ps.setObject(j + 1, parametros.get(j));
            }

            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en modificar: " + e.getMessage());
            return 0;
        }
    }

    // =========================
    // insertar normal
    // =========================
    public int insertar(String sql, Object[] parametros) {

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            if (parametros != null) {
                for (int i = 0; i < parametros.length; i++) {
                    ps.setObject(i + 1, parametros[i]);
                }
            }

            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en insertar: " + e.getMessage());
            return 0;
        }
    }
}