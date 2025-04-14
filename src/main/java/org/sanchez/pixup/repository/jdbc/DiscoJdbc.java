package org.sanchez.pixup.repository.jdbc;

import org.sanchez.pixup.model.Disco;

import java.util.List;


public interface DiscoJdbc {
    List<Disco> findAll();
    boolean save(Disco disco);
    boolean update(Disco disco);
    boolean delete(Disco disco);
    Disco findByID(Integer id);

}
