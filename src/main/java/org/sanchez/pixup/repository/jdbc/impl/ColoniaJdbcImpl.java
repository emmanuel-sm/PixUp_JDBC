package org.sanchez.pixup.repository.jdbc.impl;

import org.sanchez.pixup.model.Colonia;
import org.sanchez.pixup.repository.jdbc.ColoniaJdbc;
import org.sanchez.pixup.repository.jdbc.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ColoniaJdbcImpl extends Conexion<Colonia> implements ColoniaJdbc {
    private static ColoniaJdbc coloniaJdbc;

    private ColoniaJdbcImpl() {
    }

    public static ColoniaJdbc getInstance() {
        if (coloniaJdbc == null) {
            coloniaJdbc = new ColoniaJdbcImpl();
        }
        return coloniaJdbc;
    }

    @Override
    public List<Colonia> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Colonia> colonias = null;
        Colonia colonia = null;
        String query = "SELECT * FROM TBL_COLONIA";

        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            colonias = new ArrayList<>();
            while (resultSet.next()) {
                colonia = new Colonia();
                colonia.setId(resultSet.getInt(1));
                colonia.setNombre(resultSet.getString(2));
                colonia.setCodigoPostal(resultSet.getString(3));
                colonia.setMunicipioId(resultSet.getInt(4));
                colonias.add(colonia);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return colonias;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Colonia colonia) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO tbl_colonia (colonia, cp,tbl_municipio_id) VALUES (?, ?, ?)";
        int res = 0;
        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, colonia.getNombre());
            preparedStatement.setString(2, colonia.getCodigoPostal());
            preparedStatement.setInt(3, colonia.getMunicipioId());
            res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Colonia colonia) {
        PreparedStatement preparedStatement = null;
        String query = "UPDATE tbl_colonia SET colonia = ?, cp = ?, tbl_municipio_id = ? WHERE id = ?";
        int res = 0;
        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, colonia.getNombre());
            preparedStatement.setString(2, colonia.getCodigoPostal());
            preparedStatement.setInt(3, colonia.getMunicipioId());
            preparedStatement.setInt(4, colonia.getId());
            res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Colonia colonia) {
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM tbl_colonia WHERE id = ?";
        int res = 0;
        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, colonia.getId());
            res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Colonia findByID(Integer id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Colonia colonia = null;
        String query = "SELECT * FROM TBL_COLONIA WHERE id = ?";

        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                colonia = new Colonia();
                colonia.setId(resultSet.getInt(1));
                colonia.setNombre(resultSet.getString(2));
                colonia.setCodigoPostal(resultSet.getString(3));
                colonia.setMunicipioId(resultSet.getInt(4));
            }
            resultSet.close();
            preparedStatement.close();
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return colonia;
    }
}
