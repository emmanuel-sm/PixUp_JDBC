package org.sanchez.pixup.repository.jdbc.impl;

import org.sanchez.pixup.model.Domicilio;
import org.sanchez.pixup.repository.jdbc.DomicilioJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DomicilioJdbcImplTest {

    @Test
    void getInstance() {
        assertNotNull(DomicilioJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        DomicilioJdbc domicilioJdbc = DomicilioJdbcImpl.getInstance();
        List<Domicilio> list = domicilioJdbc.findAll();
        assertNotNull(list); // Verifica que la lista no sea nula
        assertTrue(list.size() > 0); // Comprueba que existan registros en la tabla
        list.stream().forEach(System.out::println); // Imprime los resultados para referencia
    }

    @Test
    void save() {
        Domicilio domicilio = new Domicilio();
        boolean res;
        DomicilioJdbc domicilioJdbc = DomicilioJdbcImpl.getInstance();
        domicilio.setCalle("Calle Falsa"); // Calle de prueba
        domicilio.setNumExterior("123"); // Número exterior de prueba
        domicilio.setNumInterior("A"); // Número interior de prueba
        domicilio.setColoniaId(1); // ID de colonia existente
        domicilio.setUsuarioId(1); // ID de usuario existente
        res = domicilioJdbc.save(domicilio);
        assertEquals(true, res); // Verifica que la operación sea exitosa
    }

    @Test
    void update() {
        Domicilio domicilio = new Domicilio();
        boolean res;
        domicilio.setId(1); // Ajusta este ID con un registro existente
        domicilio.setCalle("Calle Actualizada"); // Nueva calle
        domicilio.setNumExterior("456"); // Nuevo número exterior
        domicilio.setNumInterior("B"); // Nuevo número interior
        domicilio.setColoniaId(2); // Nueva colonia
        domicilio.setUsuarioId(2); // Nuevo usuario
        DomicilioJdbc domicilioJdbc = DomicilioJdbcImpl.getInstance();
        res = domicilioJdbc.update(domicilio);
        assertEquals(true, res); // Verifica que la operación sea exitosa
    }

    @Test
    void delete() {
        Domicilio domicilio = new Domicilio();
        boolean res;
        domicilio.setId(5); // Ajusta este ID con un registro existente que deseas eliminar
        DomicilioJdbc domicilioJdbc = DomicilioJdbcImpl.getInstance();
        res = domicilioJdbc.delete(domicilio);
        assertEquals(true, res); // Verifica que la operación sea exitosa
    }

    @Test
    void findByID() {
        DomicilioJdbc domicilioJdbc = DomicilioJdbcImpl.getInstance();
        Domicilio domicilio = domicilioJdbc.findByID(1); // Ajusta el ID según tus datos reales
        assertNotNull(domicilio); // Verifica que no sea nulo
        assertEquals(1, domicilio.getId()); // Verifica que el ID coincida
        assertTrue("Calle Actualizada".equals(domicilio.getCalle())); // Ajusta el valor esperado
        System.out.println(domicilio); // Imprime los datos para referencia
    }
}
