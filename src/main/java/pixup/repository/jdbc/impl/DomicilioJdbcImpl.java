package pixup.repository.jdbc.impl;

import org.gerdoc.pixup.model.Domicilio;
import org.gerdoc.pixup.repository.jdbc.Conexion;
import org.gerdoc.pixup.repository.jdbc.DomicilioJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DomicilioJdbcImpl extends Conexion<Domicilio> implements DomicilioJdbc {
    private static DomicilioJdbc domicilioJdbc;

    private DomicilioJdbcImpl() {
    }

    public static DomicilioJdbc getInstance() {
        if (domicilioJdbc == null) {
            domicilioJdbc = new DomicilioJdbcImpl();
        }
        return domicilioJdbc;
    }

    @Override
    public List<Domicilio> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Domicilio> domicilios = null;
        Domicilio domicilio = null;
        String query = "SELECT * FROM TBL_DOMICILIO";

        try {
            if (openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            domicilios = new ArrayList<>();
            while (resultSet.next()) {
                domicilio = new Domicilio();
                domicilio.setId(resultSet.getInt(1));
                domicilio.setCalle(resultSet.getString(2));
                domicilio.setNumExterior(resultSet.getString(3));
                domicilio.setNumInterior(resultSet.getString(4));
                domicilio.setColoniaId(resultSet.getInt(5));
                domicilio.setUsuarioId(resultSet.getInt(6));
                domicilios.add(domicilio);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return domicilios;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        DomicilioJdbcImpl
                .getInstance()
                .findAll()
                .stream()
                .forEach(System.out::println);
    }
}
