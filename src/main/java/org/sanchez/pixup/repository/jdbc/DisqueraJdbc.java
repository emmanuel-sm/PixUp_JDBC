package org.sanchez.pixup.repository.jdbc;

import org.sanchez.pixup.model.Disquera;

import java.util.List;


public interface DisqueraJdbc {
    List<Disquera> findAll();
    boolean save(Disquera disquera);
    boolean update(Disquera disquera);
    boolean delete(Disquera disquera);
    Disquera findByID(Integer id);
}
