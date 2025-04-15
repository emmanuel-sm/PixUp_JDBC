package org.sanchez.pixup.dao.impl;

import org.junit.jupiter.api.Test;
import org.sanchez.pixup.dao.UsuarioDao;
import org.sanchez.pixup.model.Usuario;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDaoImplTest {

    @Test
    void getInstance() {
        UsuarioDao usuarioDao = UsuarioDaoImpl.getInstance();
        assertNotNull(usuarioDao);
    }

    @Test
    void findAll() {
        List<Usuario> usuarios = null;
        UsuarioDao usuarioDao = UsuarioDaoImpl.getInstance();
        usuarios = usuarioDao.findAll();
        assertNotNull(usuarios);
        assertFalse(usuarios.isEmpty());
        usuarios.forEach(System.out::println);
    }

    @Test
    void save() {
        UsuarioDao usuarioDao = UsuarioDaoImpl.getInstance();
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setPrimerApellido("Pérez");
        usuario.setSegundoApellido("López");
        usuario.setPassword("password123");
        usuario.setEmail("juan.perez@example.com");
        boolean res = usuarioDao.save(usuario);
        assertTrue(res);

        // Verificar que el usuario se haya guardado correctamente
        List<Usuario> usuarios = usuarioDao.findAll();
        assertTrue(usuarios.stream().anyMatch(u -> u.getEmail().equals("juan.perez@example.com")));
    }

    @Test
    void update() {
        UsuarioDao usuarioDao = UsuarioDaoImpl.getInstance();
        Usuario usuario = usuarioDao.findById(1); // ID existente
        assertNotNull(usuario);
        usuario.setNombre("Juan Actualizado");
        usuario.setEmail("juan.actualizado@example.com");
        boolean res = usuarioDao.update(usuario);
        assertTrue(res);

        // Verificar que los cambios se hayan aplicado
        Usuario updatedUsuario = usuarioDao.findById(1);
        assertEquals("Juan Actualizado", updatedUsuario.getNombre());
        assertEquals("juan.actualizado@example.com", updatedUsuario.getEmail());
    }

    @Test
    void delete() {
        UsuarioDao usuarioDao = UsuarioDaoImpl.getInstance();
        Usuario usuario = usuarioDao.findById(2); // ID existente para eliminar
        assertNotNull(usuario);
        boolean res = usuarioDao.delete(usuario);
        assertTrue(res);

        // Verificar que el usuario haya sido eliminado correctamente
        Usuario deletedUsuario = usuarioDao.findById(2);
        assertNull(deletedUsuario);
    }

    @Test
    void findById() {
        UsuarioDao usuarioDao = UsuarioDaoImpl.getInstance();
        Usuario usuario = usuarioDao.findById(1); // ID existente
        assertNotNull(usuario);
        assertEquals(1, usuario.getId());
        assertEquals("Juan", usuario.getNombre()); // Ajustar según los datos esperados
    }
}
