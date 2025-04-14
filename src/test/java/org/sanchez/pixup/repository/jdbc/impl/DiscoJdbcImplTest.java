package org.sanchez.pixup.repository.jdbc.impl;

import org.sanchez.pixup.model.Disco;
import org.sanchez.pixup.repository.jdbc.DiscoJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiscoJdbcImplTest {

    @Test
    void getInstance() {
        assertNotNull(DiscoJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        DiscoJdbc discoJdbc = DiscoJdbcImpl.getInstance();
        List<Disco> list = discoJdbc.findAll();
        assertNotNull(list); // Verifica que la lista no sea nula
        assertTrue(list.size() > 0); // Comprueba que existan registros en la tabla
        assertEquals(4, list.size()); // Ajusta este valor según tus datos reales
        list.stream().forEach(System.out::println); // Imprime los resultados para referencia
    }

    @Test
    void save() {
        Disco disco = new Disco();
        boolean res;
        DiscoJdbc discoJdbc = DiscoJdbcImpl.getInstance();
        disco.setTitulo("Nuevo Disco"); // Título de prueba
        disco.setPrecio(19.99f); // Precio de prueba
        disco.setExistencia(10); // Existencia de prueba
        disco.setDescuento(0.0f); // Descuento de prueba
        disco.setFechaLanzamiento("2023-01-01"); // Fecha de prueba
        disco.setImagen("imagen.jpg"); // Imagen de prueba
        disco.setArtistaId(1); // ID de artista existente
        disco.setDisqueraId(1); // ID de disquera existente
        res = discoJdbc.save(disco);
        assertEquals(true, res); // Verifica que la operación sea exitosa
    }

    @Test
    void update() {
        Disco disco = new Disco();
        boolean res;
        disco.setId(1); // Ajusta este ID con un registro existente
        disco.setTitulo("Disco Actualizado"); // Nuevo título del disco
        disco.setPrecio(25.99f); // Nuevo precio
        disco.setExistencia(5); // Nueva existencia
        disco.setDescuento(5.0f); // Nuevo descuento
        disco.setFechaLanzamiento("2023-02-01"); // Nueva fecha
        disco.setImagen("imagen_actualizada.jpg"); // Nueva imagen
        disco.setArtistaId(2); // ID de artista actualizado
        disco.setDisqueraId(2); // ID de disquera actualizada
        DiscoJdbc discoJdbc = DiscoJdbcImpl.getInstance();
        res = discoJdbc.update(disco);
        assertEquals(true, res); // Verifica que la operación sea exitosa
    }

    @Test
    void delete() {
        Disco disco = new Disco();
        boolean res;
        disco.setId(5); // Ajusta este ID con un registro existente que deseas eliminar
        DiscoJdbc discoJdbc = DiscoJdbcImpl.getInstance();
        res = discoJdbc.delete(disco);
        assertEquals(true, res); // Verifica que la operación sea exitosa
    }

    @Test
    void findByID() {
        DiscoJdbc discoJdbc = DiscoJdbcImpl.getInstance();
        Disco disco = discoJdbc.findByID(1); // Ajusta el ID según tus datos reales
        assertNotNull(disco); // Verifica que no sea nulo
        assertEquals(1, disco.getId()); // Verifica que el ID coincida
        assertTrue("Disco Actualizado".equals(disco.getTitulo())); // Ajusta el título esperado
        System.out.println(disco); // Imprime los datos para referencia
    }
}
