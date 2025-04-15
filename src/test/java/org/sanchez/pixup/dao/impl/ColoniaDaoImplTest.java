package org.sanchez.pixup.dao.impl;

import org.junit.jupiter.api.Test;
import org.sanchez.pixup.dao.ColoniaDao;
import org.sanchez.pixup.model.Colonia;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColoniaDaoImplTest {

    @Test
    void getInstance() {
        ColoniaDao coloniaDao = ColoniaDaoImpl.getInstance();
        assertNotNull(coloniaDao);
    }

    @Test
    void findAll() {
        List<Colonia> colonias = null;
        ColoniaDao coloniaDao = ColoniaDaoImpl.getInstance();
        colonias = coloniaDao.findAll();
        assertNotNull(colonias);
        assertFalse(colonias.isEmpty());
        colonias.forEach(System.out::println);
    }

    @Test
    void save() {
        ColoniaDao coloniaDao = ColoniaDaoImpl.getInstance();
        Colonia colonia = new Colonia();
        colonia.setNombre("Nueva Colonia");
        colonia.setCodigoPostal("12345");
        colonia.setMunicipioId(1); // ID de municipio asociado
        boolean res = coloniaDao.save(colonia);
        assertTrue(res);

        // Verificar que la colonia se haya guardado correctamente
        List<Colonia> colonias = coloniaDao.findAll();
        assertTrue(colonias.stream().anyMatch(c -> c.getNombre().equals("Nueva Colonia")));
    }

    @Test
    void update() {
        ColoniaDao coloniaDao = ColoniaDaoImpl.getInstance();
        Colonia colonia = coloniaDao.findById(1); // ID existente
        assertNotNull(colonia);
        colonia.setNombre("Colonia Actualizada");
        colonia.setCodigoPostal("54321");
        boolean res = coloniaDao.update(colonia);
        assertTrue(res);

        // Verificar que los cambios se hayan aplicado
        Colonia updatedColonia = coloniaDao.findById(1);
        assertEquals("Colonia Actualizada", updatedColonia.getNombre());
        assertEquals("54321", updatedColonia.getCodigoPostal());
    }

    @Test
    void delete() {
        ColoniaDao coloniaDao = ColoniaDaoImpl.getInstance();
        Colonia colonia = coloniaDao.findById(2); // ID existente para eliminar
        assertNotNull(colonia);
        boolean res = coloniaDao.delete(colonia);
        assertTrue(res);

        // Verificar que la colonia haya sido eliminada
        Colonia deletedColonia = coloniaDao.findById(2);
        assertNull(deletedColonia);
    }

    @Test
    void findById() {
        ColoniaDao coloniaDao = ColoniaDaoImpl.getInstance();
        Colonia colonia = coloniaDao.findById(1); // ID existente
        assertNotNull(colonia);
        assertEquals(1, colonia.getId());
        assertEquals("Colonia Ejemplo", colonia.getNombre()); // Ajustar según datos esperados
    }
}
