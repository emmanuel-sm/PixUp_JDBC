package org.sanchez.pixup.repository.jdbc;

import org.sanchez.pixup.model.Orden;

import java.util.List;

public interface OrdenJdbc {
    List<Orden> findAll();
    boolean save(Orden orden);
    boolean update(Orden orden);
    boolean delete(Orden orden);
    Orden findByID(Integer id);


}
