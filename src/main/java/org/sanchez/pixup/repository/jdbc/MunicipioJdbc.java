package org.sanchez.pixup.repository.jdbc;

import org.sanchez.pixup.model.Municipio;

import java.util.List;

public interface MunicipioJdbc {
    List<Municipio> findAll();
    boolean save(Municipio municipio);
    boolean update(Municipio municipio);
    boolean delete(Municipio municipio);
    Municipio findByID(Integer id);

}
