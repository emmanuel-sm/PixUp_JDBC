package org.sanchez.pixup.repository.jdbc.impl;

import org.sanchez.pixup.model.Usuario;
import org.sanchez.pixup.repository.jdbc.UsuarioJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioJdbcImplTest {

    @Test
    void getInstance() {
        assertNotNull(UsuarioJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        UsuarioJdbc usuarioJdbc = UsuarioJdbcImpl.getInstance();
        List<Usuario> list = usuarioJdbc.findAll();
        assertNotNull(list); // Verifica que la lista no sea nula
        assertTrue(list.size() > 0); // Comprueba que existan registros en la tabla
        list.stream().forEach(System.out::println); // Imprime los resultados para referencia
    }

    @Test
    void save() {
        Usuario usuario = new Usuario();
        boolean res;
        UsuarioJdbc usuarioJdbc = UsuarioJdbcImpl.getInstance();
        usuario.setNombre("John"); // Nombre de prueba
        usuario.setPrimerApellido("Doe"); // Primer apellido de prueba
        usuario.setSegundoApellido("Smith"); // Segundo apellido de prueba
        usuario.setPassword("securepassword123"); // Contraseña de prueba
        usuario.setEmail("john.doe@example.com"); // Email de prueba
        res = usuarioJdbc.save(usuario);
        assertEquals(true, res); // Verifica que la operación sea exitosa
    }

    @Test
    void update() {
        Usuario usuario = new Usuario();
        boolean res;
        usuario.setId(1); // ID de usuario existente
        usuario.setNombre("Jane"); // Nuevo nombre
        usuario.setPrimerApellido("Doe"); // Nuevo primer apellido
        usuario.setSegundoApellido("Johnson"); // Nuevo segundo apellido
        usuario.setPassword("newsecurepassword123"); // Nueva contraseña
        usuario.setEmail("jane.doe@example.com"); // Nuevo email
        UsuarioJdbc usuarioJdbc = UsuarioJdbcImpl.getInstance();
        res = usuarioJdbc.update(usuario);
        assertEquals(true, res); // Verifica que la operación sea exitosa
    }

    @Test
    void delete() {
        Usuario usuario = new Usuario();
        boolean res;
        usuario.setId(5); // ID del usuario a eliminar
        UsuarioJdbc usuarioJdbc = UsuarioJdbcImpl.getInstance();
        res = usuarioJdbc.delete(usuario);
        assertEquals(true, res); // Verifica que la operación sea exitosa
    }

    @Test
    void findByID() {
        UsuarioJdbc usuarioJdbc = UsuarioJdbcImpl.getInstance();
        Usuario usuario = usuarioJdbc.findByID(1); // Ajusta el ID según tus datos reales
        assertNotNull(usuario); // Verifica que no sea nulo
        assertEquals(1, usuario.getId()); // Verifica que el ID coincida
        assertTrue("Jane".equals(usuario.getNombre())); // Ajusta el valor esperado
        System.out.println(usuario); // Imprime los datos del usuario para referencia
    }
}
