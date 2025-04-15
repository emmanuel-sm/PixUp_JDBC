package org.sanchez.pixup.dao;

import org.sanchez.pixup.model.Colonia;
import org.sanchez.pixup.model.Municipio;

import java.util.List;

public interface ColoniaDao
{
    List<Colonia> findAll( );
    boolean save( Colonia colonia);
    boolean update( Colonia colonia );
    boolean delete( Colonia colonia );
    Colonia findById(int id );
}
