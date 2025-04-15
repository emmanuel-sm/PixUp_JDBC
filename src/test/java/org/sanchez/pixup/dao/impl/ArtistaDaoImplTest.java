package org.sanchez.pixup.dao.impl;

import org.junit.jupiter.api.Test;
import org.sanchez.pixup.dao.ArtistaDao;
import org.sanchez.pixup.model.Artista;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArtistaDaoImplTest {

    @Test
    void getInstance() {
        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        assertNotNull(artistaDao);
    }

    @Test
    void findAll() {
        List<Artista> list = null;
        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        list = artistaDao.findAll();
        assertNotNull(list);
        assertFalse(list.isEmpty());
        list.forEach(System.out::println);
    }

    @Test
    void save() {
        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        Artista artista = new Artista();
        artista.setNombre("Nuevo Artista");
        boolean res = artistaDao.save(artista);
        assertTrue(res);

        // Verificar que el artista se haya guardado correctamente
        List<Artista> artistas = artistaDao.findAll();
        assertTrue(artistas.stream().anyMatch(a -> a.getNombre().equals("Nuevo Artista")));
    }

    @Test
    void update() {
        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        Artista artista = artistaDao.findById(1);
        assertNotNull(artista);
        artista.setNombre("Artista Actualizado");
        boolean res = artistaDao.update(artista);
        assertTrue(res);

        // Verificar que el nombre se haya actualizado correctamente
        Artista updatedArtista = artistaDao.findById(1);
        assertEquals("Artista Actualizado", updatedArtista.getNombre());
    }

    @Test
    void delete() {
        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        Artista artista = artistaDao.findById(2);
        assertNotNull(artista);
        boolean res = artistaDao.delete(artista);
        assertTrue(res);

        // Verificar que el artista se haya eliminado correctamente
        Artista deletedArtista = artistaDao.findById(2);
        assertNull(deletedArtista);
    }

    @Test
    void findById() {
        ArtistaDao artistaDao = ArtistaDaoImpl.getInstance();
        Artista artista = artistaDao.findById(1);
        assertNotNull(artista);
        assertEquals(1, artista.getId());
        assertEquals("Artista Ejemplo", artista.getNombre()); // Ajustar según el dato esperado
    }
}
