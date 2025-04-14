package org.sanchez.pixup.repository.jdbc.impl;

import org.sanchez.pixup.model.Usuario;
import org.sanchez.pixup.repository.jdbc.Conexion;
import org.sanchez.pixup.repository.jdbc.UsuarioJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioJdbcImpl extends Conexion<Usuario> implements UsuarioJdbc {
    private static UsuarioJdbc usuarioJdbc;

    private UsuarioJdbcImpl() {
    }

    public static UsuarioJdbc getInstance() {
        if (usuarioJdbc == null) {
            usuarioJdbc = new UsuarioJdbcImpl();
        }
        return usuarioJdbc;
    }

    @Override
    public List<Usuario> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Usuario> usuarios = null;
        String query = "SELECT * FROM TBL_USUARIO";

        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            usuarios = new ArrayList<>();
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt(1));
                usuario.setNombre(resultSet.getString(2));
                usuario.setPrimerApellido(resultSet.getString(3));
                usuario.setSegundoApellido(resultSet.getString(4));
                usuario.setPassword(resultSet.getString(5));
                usuario.setEmail(resultSet.getString(6));
                usuarios.add(usuario);
            }
            resultSet.close();
            statement.close();
            closeConnection();
            return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(Usuario usuario) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO TBL_USUARIO (NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, PASSWORD, EMAIL) VALUES (?, ?, ?, ?, ?)";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getPrimerApellido());
            preparedStatement.setString(3, usuario.getSegundoApellido());
            preparedStatement.setString(4, usuario.getPassword());
            preparedStatement.setString(5, usuario.getEmail());
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
    public boolean update(Usuario usuario) {
        PreparedStatement preparedStatement = null;
        String query = "UPDATE TBL_USUARIO SET NOMBRE = ?, PRIMER_APELLIDO = ?, SEGUNDO_APELLIDO = ?, PASSWORD = ?, EMAIL = ? WHERE ID = ?";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getPrimerApellido());
            preparedStatement.setString(3, usuario.getSegundoApellido());
            preparedStatement.setString(4, usuario.getPassword());
            preparedStatement.setString(5, usuario.getEmail());
            preparedStatement.setInt(6, usuario.getId());
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
    public boolean delete(Usuario usuario) {
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM TBL_USUARIO WHERE ID = ?";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, usuario.getId());
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
    public Usuario findByID(Integer id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Usuario usuario = null;
        String query = "SELECT * FROM TBL_USUARIO WHERE ID = ?";

        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usuario = new Usuario();
                usuario.setId(resultSet.getInt(1));
                usuario.setNombre(resultSet.getString(2));
                usuario.setPrimerApellido(resultSet.getString(3));
                usuario.setSegundoApellido(resultSet.getString(4));
                usuario.setPassword(resultSet.getString(5));
                usuario.setEmail(resultSet.getString(6));
            }
            resultSet.close();
            preparedStatement.close();
            closeConnection();
            return usuario;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
