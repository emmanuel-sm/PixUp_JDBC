package pixup.repository.jdbc.impl;

import org.gerdoc.pixup.model.Orden;
import org.gerdoc.pixup.repository.jdbc.Conexion;
import org.gerdoc.pixup.repository.jdbc.OrdenJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdenJdbcImpl extends Conexion<Orden> implements OrdenJdbc {
    private static OrdenJdbc ordenJdbc;

    private OrdenJdbcImpl() {
    }

    public static OrdenJdbc getInstance() {
        if (ordenJdbc == null) {
            ordenJdbc = new OrdenJdbcImpl();
        }
        return ordenJdbc;
    }

    @Override
    public List<Orden> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Orden> ordenes = null;
        Orden orden = null;
        String query = "SELECT * FROM TBL_ORDEN";

        try {
            if (openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            ordenes = new ArrayList<>();
            while (resultSet.next()) {
                orden = new Orden();
                orden.setId(resultSet.getInt(1));
                orden.setCostoTotal(resultSet.getFloat(2));
                orden.setFecha(resultSet.getString(3));
                orden.setCantidadTotal(resultSet.getInt(4));
                orden.setEstatusEnvio(resultSet.getBoolean(5));
                orden.setCostoMax(resultSet.getFloat(6));
                orden.setUsuarioId(resultSet.getInt(7));
                orden.setDiscoId(resultSet.getInt(8));
                ordenes.add(orden);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return ordenes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        OrdenJdbcImpl
                .getInstance()
                .findAll()
                .stream()
                .forEach(System.out::println);
    }
}
