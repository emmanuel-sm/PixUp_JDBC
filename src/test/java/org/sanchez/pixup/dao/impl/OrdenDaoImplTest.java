package org.sanchez.pixup.dao.impl;

import org.junit.jupiter.api.Test;
import org.sanchez.pixup.dao.OrdenDao;
import org.sanchez.pixup.model.Orden;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrdenDaoImplTest {

    @Test
    void getInstance() {
        OrdenDao ordenDao = OrdenDaoImpl.getInstance();
        assertNotNull(ordenDao);
    }

    @Test
    void findAll() {
        List<Orden> ordenes = null;
        OrdenDao ordenDao = OrdenDaoImpl.getInstance();
        ordenes = ordenDao.findAll();
        assertNotNull(ordenes);
        assertFalse(ordenes.isEmpty());
        ordenes.forEach(System.out::println);
    }

    @Test
    void save() {
        OrdenDao ordenDao = OrdenDaoImpl.getInstance();
        Orden orden = new Orden();
        orden.setCostoTotal(500.0f);
        orden.setFecha("2025-04-14");
        orden.setCantidadTotal(5);
        orden.setEstatusEnvio(true);
        orden.setCostoMax(100.0f);
        orden.setUsuarioId(1); // ID de usuario asociado
        orden.setDiscoId(1); // ID de disco asociado
        boolean res = ordenDao.save(orden);
        assertTrue(res);

        // Verificar que la orden se haya guardado correctamente
        List<Orden> ordenes = ordenDao.findAll();
        assertTrue(ordenes.stream().anyMatch(o -> o.getCostoTotal().equals(500.0f)));
    }

    @Test
    void update() {
        OrdenDao ordenDao = OrdenDaoImpl.getInstance();
        Orden orden = ordenDao.findById(1); // ID existente
        assertNotNull(orden);
        orden.setCostoTotal(600.0f);
        orden.setCantidadTotal(10);
        boolean res = ordenDao.update(orden);
        assertTrue(res);

        // Verificar que los cambios se hayan aplicado
        Orden updatedOrden = ordenDao.findById(1);
        assertEquals(600.0f, updatedOrden.getCostoTotal());
        assertEquals(10, updatedOrden.getCantidadTotal());
    }

    @Test
    void delete() {
        OrdenDao ordenDao = OrdenDaoImpl.getInstance();
        Orden orden = ordenDao.findById(2); // ID existente para eliminar
        assertNotNull(orden);
        boolean res = ordenDao.delete(orden);
        assertTrue(res);

        // Verificar que la orden haya sido eliminada correctamente
        Orden deletedOrden = ordenDao.findById(2);
        assertNull(deletedOrden);
    }

    @Test
    void findById() {
        OrdenDao ordenDao = OrdenDaoImpl.getInstance();
        Orden orden = ordenDao.findById(1); // ID existente
        assertNotNull(orden);
        assertEquals(1, orden.getId());
        assertEquals("2025-04-14", orden.getFecha()); // Ajustar según los datos esperados
    }
}
