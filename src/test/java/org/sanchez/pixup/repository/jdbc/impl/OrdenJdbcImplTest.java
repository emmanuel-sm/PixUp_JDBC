package org.sanchez.pixup.repository.jdbc.impl;

import org.sanchez.pixup.model.Orden;
import org.sanchez.pixup.repository.jdbc.OrdenJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrdenJdbcImplTest {

    @Test
    void getInstance() {
        assertNotNull(OrdenJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        OrdenJdbc ordenJdbc = OrdenJdbcImpl.getInstance();
        List<Orden> list = ordenJdbc.findAll();
        assertNotNull(list); // Verifica que la lista no sea nula
        assertTrue(list.size() > 0); // Asegura que existan registros en la tabla
        list.stream().forEach(System.out::println); // Imprime las órdenes para referencia
    }

    @Test
    void save() {
        Orden orden = new Orden();
        boolean res;
        OrdenJdbc ordenJdbc = OrdenJdbcImpl.getInstance();
        orden.setCostoTotal(199.99f); // Costo total de la orden
        orden.setFecha("2023-06-15"); // Fecha de la orden
        orden.setCantidadTotal(10); // Cantidad total en la orden
        orden.setEstatusEnvio(true); // Estatus de envío
        orden.setCostoMax(299.99f); // Costo máximo
        orden.setUsuarioId(1); // ID de un usuario existente
        orden.setDiscoId(1); // ID de un disco existente
        res = ordenJdbc.save(orden);
        assertEquals(true, res); // Verifica que la operación sea exitosa
    }

    @Test
    void update() {
        Orden orden = new Orden();
        boolean res;
        orden.setId(1); // ID de la orden existente
        orden.setCostoTotal(250.00f); // Nuevo costo total
        orden.setFecha("2023-06-20"); // Nueva fecha
        orden.setCantidadTotal(15); // Nueva cantidad total
        orden.setEstatusEnvio(false); // Nuevo estatus de envío
        orden.setCostoMax(350.00f); // Nuevo costo máximo
        orden.setUsuarioId(2); // Nuevo usuario
        orden.setDiscoId(2); // Nuevo disco
        OrdenJdbc ordenJdbc = OrdenJdbcImpl.getInstance();
        res = ordenJdbc.update(orden);
        assertEquals(true, res); // Verifica que la operación sea exitosa
    }

    @Test
    void delete() {
        Orden orden = new Orden();
        boolean res;
        orden.setId(5); // ID de la orden a eliminar
        OrdenJdbc ordenJdbc = OrdenJdbcImpl.getInstance();
        res = ordenJdbc.delete(orden);
        assertEquals(true, res); // Verifica que la operación sea exitosa
    }

    @Test
    void findByID() {
        OrdenJdbc ordenJdbc = OrdenJdbcImpl.getInstance();
        Orden orden = ordenJdbc.findByID(1); // Ajusta el ID según tus datos reales
        assertNotNull(orden); // Verifica que no sea nulo
        assertEquals(1, orden.getId()); // Comprueba que el ID coincida
        assertTrue(orden.getCostoTotal() > 0); // Comprueba que el costo total sea válido
        System.out.println(orden); // Imprime los datos de la orden para referencia
    }
}
