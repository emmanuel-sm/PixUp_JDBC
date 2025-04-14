package org.sanchez.pixup.repository.jdbc.impl;

import org.sanchez.pixup.model.Estado;
import org.sanchez.pixup.repository.jdbc.Conexion;
import org.sanchez.pixup.repository.jdbc.EstadoJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstadoJdbcImpl extends Conexion<Estado> implements EstadoJdbc {
    private static EstadoJdbc estadoJdbc;

    private EstadoJdbcImpl() {
    }

    public static EstadoJdbc getInstance() {
        if (estadoJdbc == null) {
            estadoJdbc = new EstadoJdbcImpl();
        }
        return estadoJdbc;
    }

    @Override
    public List<Estado> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Estado> estados = null;
        Estado estado = null;
        String query = "SELECT * FROM TBL_ESTADO";

        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            estados = new ArrayList<>();
            while (resultSet.next()) {
                estado = new Estado();
                estado.setId(resultSet.getInt(1));
                estado.setNombre(resultSet.getString(2));
                estados.add(estado);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return estados;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Estado estado) {
        PreparedStatement preparedStatement = null;
        String query = "insert into tbl_estado (estado) values (?)";
        int res=0;
        try{
            if (!openConnection()) {
                System.out.println("Error en conexion");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,estado.getNombre());
            res= preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res==1;
        }
        catch(
                SQLException e)

        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Estado estado) {
        PreparedStatement preparedStatement = null;
        String query = "update tbl_estado set estado = ? where id = ?";
        int res=0;
        try{
            if (!openConnection()) {
                System.out.println("Error en conexion");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,estado.getNombre());
            preparedStatement.setInt(2,estado.getId());
            res= preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res==1;
        }
        catch(
                SQLException e)

        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Estado estado) {
        PreparedStatement preparedStatement = null;
        String query = "delete from tbl_estado where id = ?";
        int res=0;
        try{
            if (!openConnection()) {
                System.out.println("Error en conexion");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,estado.getNombre());
            res= preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res==1;
        }
        catch(
                SQLException e)

        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Estado findByID(Integer id) {
        Statement statement = null;
        ResultSet resultSet = null;
        Estado estado = null;
        String query = "SELECT * FROM TBL_ESTADO where id= ?";

        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            if (resultSet.next())
            {
                estado = new Estado();
                estado.setId(resultSet.getInt(1));
                estado.setNombre(resultSet.getString(2));
            }
            resultSet.close();
            statement.close();
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
/*
    public static void main( String args[] )
    {
        EstadoJdbcImpl
                .getInstance()
                .findAll()
                .stream()
                .forEach( System.out::println);


    }
*/
}
