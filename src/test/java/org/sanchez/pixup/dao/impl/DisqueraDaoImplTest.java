package org.sanchez.pixup.dao.impl;

import org.junit.jupiter.api.Test;
import org.sanchez.pixup.dao.DisqueraDao;
import org.sanchez.pixup.model.Disquera;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisqueraDaoImplTest {

    @Test
    void getInstance() {
        DisqueraDao disqueraDao = DisqueraDaoImpl.getInstance();
        assertNotNull(disqueraDao);
    }

    @Test
    void findAll() {
        List<Disquera> disqueras = null;
        DisqueraDao disqueraDao = DisqueraDaoImpl.getInstance();
        disqueras = disqueraDao.findAll();
        assertNotNull(disqueras);
        assertFalse(disqueras.isEmpty());
        disqueras.forEach(System.out::println);
    }

    @Test
    void save() {
        DisqueraDao disqueraDao = DisqueraDaoImpl.getInstance();
        Disquera disquera = new Disquera();
        disquera.setNombre("Nueva Disquera");
        boolean res = disqueraDao.save(disquera);
        assertTrue(res);

        // Verificar que la disquera se haya guardado correctamente
        List<Disquera> disqueras = disqueraDao.findAll();
        assertTrue(disqueras.stream().anyMatch(d -> d.getNombre().equals("Nueva Disquera")));
    }

    @Test
    void update() {
        DisqueraDao disqueraDao = DisqueraDaoImpl.getInstance();
        Disquera disquera = disqueraDao.findById(1); // ID existente
        assertNotNull(disquera);
        disquera.setNombre("Disquera Actualizada");
        boolean res = disqueraDao.update(disquera);
        assertTrue(res);

        // Verificar que los cambios se hayan aplicado
        Disquera updatedDisquera = disqueraDao.findById(1);
        assertEquals("Disquera Actualizada", updatedDisquera.getNombre());
    }

    @Test
    void delete() {
        DisqueraDao disqueraDao = DisqueraDaoImpl.getInstance();
        Disquera disquera = disqueraDao.findById(2); // ID existente para eliminar
        assertNotNull(disquera);
        boolean res = disqueraDao.delete(disquera);
        assertTrue(res);

        // Verificar que la disquera haya sido eliminada correctamente
        Disquera deletedDisquera = disqueraDao.findById(2);
        assertNull(deletedDisquera);
    }

    @Test
    void findById() {
        DisqueraDao disqueraDao = DisqueraDaoImpl.getInstance();
        Disquera disquera = disqueraDao.findById(1); // ID existente
        assertNotNull(disquera);
        assertEquals(1, disquera.getId());
        assertEquals("Disquera Ejemplo", disquera.getNombre()); // Ajustar según los datos esperados
    }
}
