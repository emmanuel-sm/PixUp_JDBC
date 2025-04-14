package org.sanchez.pixup.repository.jdbc.impl;

import org.sanchez.pixup.model.Municipio;
import org.sanchez.pixup.repository.jdbc.MunicipioJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MunicipioJdbcImplTest {

    @Test
    void getInstance() {
        assertNotNull(MunicipioJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        MunicipioJdbc municipioJdbc = MunicipioJdbcImpl.getInstance();
        List<Municipio> list = municipioJdbc.findAll();
        assertNotNull(list); // Verifica que la lista no sea nula
        assertTrue(list.size() > 0); // Asegura que existan registros en la tabla
        list.stream().forEach(System.out::println); // Imprime los municipios para referencia
    }

    @Test
    void save() {
        Municipio municipio = new Municipio();
        boolean res;
        MunicipioJdbc municipioJdbc = MunicipioJdbcImpl.getInstance();
        municipio.setNombre("Nuevo Municipio"); // Nombre del municipio
        municipio.setEstadoId(1); // ID de un estado existente
        res = municipioJdbc.save(municipio);
        assertEquals(true, res); // Verifica que la operación sea exitosa
    }

    @Test
    void update() {
        Municipio municipio = new Municipio();
        boolean res;
        municipio.setId(1); // ID del municipio existente
        municipio.setNombre("Municipio Actualizado"); // Nuevo nombre del municipio
        municipio.setEstadoId(2); // ID de un estado actualizado
        MunicipioJdbc municipioJdbc = MunicipioJdbcImpl.getInstance();
        res = municipioJdbc.update(municipio);
        assertEquals(true, res); // Verifica que la operación sea exitosa
    }

    @Test
    void delete() {
        Municipio municipio = new Municipio();
        boolean res;
        municipio.setId(5); // ID del municipio a eliminar
        MunicipioJdbc municipioJdbc = MunicipioJdbcImpl.getInstance();
        res = municipioJdbc.delete(municipio);
        assertEquals(true, res); // Verifica que la operación sea exitosa
    }

    @Test
    void findByID() {
        MunicipioJdbc municipioJdbc = MunicipioJdbcImpl.getInstance();
        Municipio municipio = municipioJdbc.findByID(1); // Ajusta el ID según los datos existentes
        assertNotNull(municipio); // Verifica que no sea nulo
        assertEquals(1, municipio.getId()); // Comprueba que el ID coincida
        assertTrue("Municipio Actualizado".equals(municipio.getNombre())); // Ajusta el valor esperado
        System.out.println(municipio); // Imprime el municipio para referencia
    }
}
