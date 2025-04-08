package pixup.repository.jdbc.impl;

import org.gerdoc.pixup.model.Usuario;
import org.gerdoc.pixup.repository.jdbc.Conexion;
import org.gerdoc.pixup.repository.jdbc.UsuarioJdbc;

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
        Usuario usuario = null;
        String query = "SELECT * FROM TBL_USUARIO";

        try {
            if (openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            usuarios = new ArrayList<>();
            while (resultSet.next()) {
                usuario = new Usuario();
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

    public static void main(String[] args) {
        UsuarioJdbcImpl
                .getInstance()
                .findAll()
                .stream()
                .forEach(System.out::println);
    }
}
