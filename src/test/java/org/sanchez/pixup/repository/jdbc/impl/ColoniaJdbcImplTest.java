package org.sanchez.pixup.repository.jdbc.impl;

import org.sanchez.pixup.model.Colonia;
import org.sanchez.pixup.repository.jdbc.ColoniaJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColoniaJdbcImplTest {

    ColoniaJdbc coloniaJdbc = ColoniaJdbcImpl.getInstance();

    @Test
    void getInstance() {
        assertNotNull(ColoniaJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        ColoniaJdbc coloniaJdbc1 = ColoniaJdbcImpl.getInstance();
        List<Colonia> list = coloniaJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() > 0);
        assertEquals(3, list.size());
        list.stream().forEach(System.out::println);
    }

    @Test
    void save() {
        Colonia colonia = new Colonia();
        boolean res = false;
        colonia.setNombre("Nueva Colonia");
        colonia.setCodigoPostal("12345");
        colonia.setMunicipioId(1);
        res = coloniaJdbc.save(colonia);
        assertEquals(true, res);
    }

    @Test
    void update() {
        Colonia colonia = new Colonia();
        boolean res = false;
        colonia.setNombre("Colonia Actualizada");
        colonia.setCodigoPostal("54321");
        colonia.setMunicipioId(2);
        colonia.setId(1);
        res = coloniaJdbc.update(colonia);
        assertEquals(true, res);
    }

    @Test
    void delete() {
        Colonia colonia = new Colonia();
        boolean res = false;
        colonia.setId(4);
        res = coloniaJdbc.delete(colonia);
        assertEquals(true, res);
    }

    @Test
    void findByID() {
        ColoniaJdbc coloniaJdbc1 = ColoniaJdbcImpl.getInstance();
        Colonia colonia = coloniaJdbc.findByID(1);
        assertNotNull(colonia);
        assertTrue("Colonia1".equals(colonia.getNombre()));
        assertEquals(1, colonia.getId());
        System.out.println(colonia);
    }
}
