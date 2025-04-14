package org.sanchez.pixup.repository.jdbc.impl;

import org.sanchez.pixup.model.Artista;
import org.sanchez.pixup.repository.jdbc.ArtistaJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArtistaJdbcImplTest {

    @Test
    void getInstance() {
        assertNotNull(ArtistaJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        ArtistaJdbc artistaJdbc = ArtistaJdbcImpl.getInstance();
        List<Artista> list = artistaJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() > 0);
        assertEquals(4, list.size());
        list.stream().forEach(System.out::println);
    }

    @Test
    void save() {
        Artista artista = new Artista();
        boolean res;
        ArtistaJdbc artistaJdbc = ArtistaJdbcImpl.getInstance();
        artista.setNombre("Maluma");
        res = artistaJdbc.save(artista);
        assertEquals(true, res);
    }

    @Test
    void update() {
        Artista artista = new Artista();
        boolean res;
        artista.setNombre("Chente");
        artista.setId(1);
        ArtistaJdbc artistaJdbc = ArtistaJdbcImpl.getInstance();
        res = artistaJdbc.update(artista);
        assertEquals(true, res);
    }

    @Test
    void delete() {
        Artista artista = new Artista();
        boolean res;
        artista.setId(4);
        ArtistaJdbc artistaJdbc = ArtistaJdbcImpl.getInstance();
        res = artistaJdbc.delete(artista);
        assertEquals(true, res);
    }

    @Test
    void findByID() {
        ArtistaJdbc artistaJdbc = ArtistaJdbcImpl.getInstance();
        Artista artista = artistaJdbc.findByID(1);
        assertNotNull(artista);
        assertEquals(1, artista.getId());
        assertTrue("Artista1".equals(artista.getNombre()));
        System.out.println(artista);
    }
}
