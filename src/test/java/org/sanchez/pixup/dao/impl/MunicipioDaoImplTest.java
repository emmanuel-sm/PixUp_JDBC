package org.sanchez.pixup.dao.impl;

import org.junit.jupiter.api.Test;
import org.sanchez.pixup.dao.MunicipioDao;
import org.sanchez.pixup.model.Municipio;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MunicipioDaoImplTest {

    @Test
    void getInstance() {
        MunicipioDao municipioDao = MunicipioDaoImpl.getInstance();
        assertNotNull(municipioDao);
    }

    @Test
    void findAll() {
        List<Municipio> municipios = null;
        MunicipioDao municipioDao = MunicipioDaoImpl.getInstance();
        municipios = municipioDao.findAll();
        assertNotNull(municipios);
        assertFalse(municipios.isEmpty());
        municipios.forEach(System.out::println);
    }

    @Test
    void save() {
        MunicipioDao municipioDao = MunicipioDaoImpl.getInstance();
        Municipio municipio = new Municipio();
        municipio.setNombre("Nuevo Municipio");
        municipio.setEstadoId(1); // ID del estado asociado
        boolean res = municipioDao.save(municipio);
        assertTrue(res);

        // Verificar que el municipio se haya guardado correctamente
        List<Municipio> municipios = municipioDao.findAll();
        assertTrue(municipios.stream().anyMatch(m -> m.getNombre().equals("Nuevo Municipio")));
    }

    @Test
    void update() {
        MunicipioDao municipioDao = MunicipioDaoImpl.getInstance();
        Municipio municipio = municipioDao.findById(1); // ID existente
        assertNotNull(municipio);
        municipio.setNombre("Municipio Actualizado");
        boolean res = municipioDao.update(municipio);
        assertTrue(res);

        // Verificar que los cambios se hayan aplicado
        Municipio updatedMunicipio = municipioDao.findById(1);
        assertEquals("Municipio Actualizado", updatedMunicipio.getNombre());
    }

    @Test
    void delete() {
        MunicipioDao municipioDao = MunicipioDaoImpl.getInstance();
        Municipio municipio = municipioDao.findById(2); // ID existente para eliminar
        assertNotNull(municipio);
        boolean res = municipioDao.delete(municipio);
        assertTrue(res);

        // Verificar que el municipio haya sido eliminado correctamente
        Municipio deletedMunicipio = municipioDao.findById(2);
        assertNull(deletedMunicipio);
    }

    @Test
    void findById() {
        MunicipioDao municipioDao = MunicipioDaoImpl.getInstance();
        Municipio municipio = municipioDao.findById(1); // ID existente
        assertNotNull(municipio);
        assertEquals(1, municipio.getId());
        assertEquals("Municipio Ejemplo", municipio.getNombre()); // Ajustar según datos esperados
    }
}
