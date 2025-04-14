package org.sanchez.pixup.repository.jdbc.impl;

import org.sanchez.pixup.model.Disquera;
import org.sanchez.pixup.repository.jdbc.DisqueraJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisqueraJdbcImplTest {

    @Test
    void getInstance() {
        assertNotNull(DisqueraJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        DisqueraJdbc disqueraJdbc = DisqueraJdbcImpl.getInstance();
        List<Disquera> list = disqueraJdbc.findAll();
        assertNotNull(list); // Verifica que la lista no sea nula
        assertTrue(list.size() > 0); // Comprueba que existan registros en la tabla
        list.stream().forEach(System.out::println); // Imprime los resultados para referencia
    }

    @Test
    void save() {
        Disquera disquera = new Disquera();
        boolean res;
        DisqueraJdbc disqueraJdbc = DisqueraJdbcImpl.getInstance();
        disquera.setNombre("Nueva Disquera"); // Nombre de prueba
        res = disqueraJdbc.save(disquera);
        assertEquals(true, res); // Verifica que la operación sea exitosa
    }

    @Test
    void update() {
        Disquera disquera = new Disquera();
        boolean res;
        disquera.setId(1); // Ajusta este ID con un registro existente
        disquera.setNombre("Disquera Actualizada"); // Nuevo nombre de la disquera
        DisqueraJdbc disqueraJdbc = DisqueraJdbcImpl.getInstance();
        res = disqueraJdbc.update(disquera);
        assertEquals(true, res); // Verifica que la operación sea exitosa
    }

    @Test
    void delete() {
        Disquera disquera = new Disquera();
        boolean res;
        disquera.setId(5); // Ajusta este ID con un registro existente que deseas eliminar
        DisqueraJdbc disqueraJdbc = DisqueraJdbcImpl.getInstance();
        res = disqueraJdbc.delete(disquera);
        assertEquals(true, res); // Verifica que la operación sea exitosa
    }

    @Test
    void findByID() {
        DisqueraJdbc disqueraJdbc = DisqueraJdbcImpl.getInstance();
        Disquera disquera = disqueraJdbc.findByID(1); // Ajusta el ID según tus datos reales
        assertNotNull(disquera); // Verifica que no sea nulo
        assertEquals(1, disquera.getId()); // Verifica que el ID coincida
        assertTrue("Disquera Actualizada".equals(disquera.getNombre())); // Ajusta el nombre esperado
        System.out.println(disquera); // Imprime los datos para referencia
    }
}
