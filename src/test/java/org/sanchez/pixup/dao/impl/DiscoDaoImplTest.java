package org.sanchez.pixup.dao.impl;

import org.junit.jupiter.api.Test;
import org.sanchez.pixup.dao.DiscoDao;
import org.sanchez.pixup.model.Disco;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiscoDaoImplTest {

    @Test
    void getInstance() {
        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        assertNotNull(discoDao);
    }

    @Test
    void findAll() {
        List<Disco> discos = null;
        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        discos = discoDao.findAll();
        assertNotNull(discos);
        assertFalse(discos.isEmpty());
        discos.forEach(System.out::println);
    }

    @Test
    void save() {
        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        Disco disco = new Disco();
        disco.setTitulo("Nuevo Disco");
        disco.setPrecio(199.99f);
        disco.setExistencia(100);
        disco.setDescuento(10.0f);
        disco.setFechaLanzamiento("2025-01-01");
        disco.setImagen("imagen.jpg");
        disco.setArtistaId(1);
        disco.setDisqueraId(1);
        boolean res = discoDao.save(disco);
        assertTrue(res);

        // Verificar que el disco se haya guardado correctamente
        List<Disco> discos = discoDao.findAll();
        assertTrue(discos.stream().anyMatch(d -> d.getTitulo().equals("Nuevo Disco")));
    }

    @Test
    void update() {
        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        Disco disco = discoDao.findById(1); // ID existente
        assertNotNull(disco);
        disco.setTitulo("Disco Actualizado");
        disco.setPrecio(150.0f);
        boolean res = discoDao.update(disco);
        assertTrue(res);

        // Verificar que los cambios se hayan aplicado
        Disco updatedDisco = discoDao.findById(1);
        assertEquals("Disco Actualizado", updatedDisco.getTitulo());
        assertEquals(150.0f, updatedDisco.getPrecio());
    }

    @Test
    void delete() {
        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        Disco disco = discoDao.findById(2); // ID existente para eliminar
        assertNotNull(disco);
        boolean res = discoDao.delete(disco);
        assertTrue(res);

        // Verificar que el disco haya sido eliminado correctamente
        Disco deletedDisco = discoDao.findById(2);
        assertNull(deletedDisco);
    }

    @Test
    void findById() {
        DiscoDao discoDao = DiscoDaoImpl.getInstance();
        Disco disco = discoDao.findById(1); // ID existente
        assertNotNull(disco);
        assertEquals(1, disco.getId());
        assertEquals("Disco Ejemplo", disco.getTitulo()); // Ajustar según datos esperados
    }
}
