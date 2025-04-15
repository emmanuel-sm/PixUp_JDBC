package org.sanchez.pixup.dao.impl;

import org.junit.jupiter.api.Test;
import org.sanchez.pixup.dao.DomicilioDao;
import org.sanchez.pixup.model.Domicilio;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DomicilioDaoImplTest {

    @Test
    void getInstance() {
        DomicilioDao domicilioDao = DomicilioDaoImpl.getInstance();
        assertNotNull(domicilioDao);
    }

    @Test
    void findAll() {
        List<Domicilio> domicilios = null;
        DomicilioDao domicilioDao = DomicilioDaoImpl.getInstance();
        domicilios = domicilioDao.findAll();
        assertNotNull(domicilios);
        assertFalse(domicilios.isEmpty());
        domicilios.forEach(System.out::println);
    }

    @Test
    void save() {
        DomicilioDao domicilioDao = DomicilioDaoImpl.getInstance();
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Nueva Calle");
        domicilio.setNumExterior("123");
        domicilio.setNumInterior("A");
        domicilio.setColoniaId(1); // ID de colonia asociada
        domicilio.setUsuarioId(1); // ID de usuario asociado
        boolean res = domicilioDao.save(domicilio);
        assertTrue(res);

        // Verificar que el domicilio se haya guardado correctamente
        List<Domicilio> domicilios = domicilioDao.findAll();
        assertTrue(domicilios.stream().anyMatch(d -> d.getCalle().equals("Nueva Calle")));
    }

    @Test
    void update() {
        DomicilioDao domicilioDao = DomicilioDaoImpl.getInstance();
        Domicilio domicilio = domicilioDao.findById(1); // ID existente
        assertNotNull(domicilio);
        domicilio.setCalle("Calle Actualizada");
        domicilio.setNumExterior("456");
        boolean res = domicilioDao.update(domicilio);
        assertTrue(res);

        // Verificar que los cambios se hayan aplicado
        Domicilio updatedDomicilio = domicilioDao.findById(1);
        assertEquals("Calle Actualizada", updatedDomicilio.getCalle());
        assertEquals("456", updatedDomicilio.getNumExterior());
    }

    @Test
    void delete() {
        DomicilioDao domicilioDao = DomicilioDaoImpl.getInstance();
        Domicilio domicilio = domicilioDao.findById(2); // ID existente para eliminar
        assertNotNull(domicilio);
        boolean res = domicilioDao.delete(domicilio);
        assertTrue(res);

        // Verificar que el domicilio haya sido eliminado correctamente
        Domicilio deletedDomicilio = domicilioDao.findById(2);
        assertNull(deletedDomicilio);
    }

    @Test
    void findById() {
        DomicilioDao domicilioDao = DomicilioDaoImpl.getInstance();
        Domicilio domicilio = domicilioDao.findById(1); // ID existente
        assertNotNull(domicilio);
        assertEquals(1, domicilio.getId());
        assertEquals("Calle Ejemplo", domicilio.getCalle()); // Ajustar según datos esperados
    }
}
