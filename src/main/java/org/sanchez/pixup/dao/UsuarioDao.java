package org.sanchez.pixup.dao;

import org.sanchez.pixup.model.Colonia;
import org.sanchez.pixup.model.Usuario;

import java.util.List;

public interface UsuarioDao
{
    List<Usuario> findAll( );
    boolean save( Usuario usuario);
    boolean update( Usuario usuario );
    boolean delete( Usuario usuario );
    Usuario findById(int id );
}