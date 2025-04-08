package pixup.repository.jdbc.impl;

import org.gerdoc.pixup.model.Municipio;
import org.gerdoc.pixup.repository.jdbc.Conexion;
import org.gerdoc.pixup.repository.jdbc.MunicipioJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MunicipioJdbcImpl extends Conexion<Municipio> implements MunicipioJdbc {
    private static MunicipioJdbc municipioJdbc;

    private MunicipioJdbcImpl() {
    }

    public static MunicipioJdbc getInstance() {
        if (municipioJdbc == null) {
            municipioJdbc = new MunicipioJdbcImpl();
        }
        return municipioJdbc;
    }

    @Override
    public List<Municipio> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Municipio> municipios = null;
        Municipio municipio = null;
        String query = "SELECT * FROM TBL_MUNICIPIO";

        try {
            if (openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            municipios = new ArrayList<>();
            while (resultSet.next()) {
                municipio = new Municipio();
                municipio.setId(resultSet.getInt(1));
                municipio.setNombre(resultSet.getString(2));
                municipio.setEstadoId(resultSet.getInt(3));
                municipios.add(municipio);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return municipios;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        MunicipioJdbcImpl
                .getInstance()
                .findAll()
                .stream()
                .forEach(System.out::println);
    }
}
