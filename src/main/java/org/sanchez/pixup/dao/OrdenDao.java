package org.sanchez.pixup.dao;

import org.sanchez.pixup.model.Artista;
import org.sanchez.pixup.model.Orden;

import java.util.List;

public interface OrdenDao {
    List<Orden> findAll( );
    boolean save( Orden orden);
    boolean update( Orden orden );
    boolean delete( Orden orden );
    Orden findById(int id );
}
