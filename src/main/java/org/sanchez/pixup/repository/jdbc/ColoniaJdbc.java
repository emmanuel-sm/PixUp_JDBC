package org.sanchez.pixup.repository.jdbc;

import org.sanchez.pixup.model.Colonia;

import java.util.List;

public interface ColoniaJdbc {
    List<Colonia> findAll();
    boolean save(Colonia colonia);
    boolean update(Colonia colonia);
    boolean delete(Colonia colonia);
    Colonia findByID(Integer id);
}
