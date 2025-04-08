package pixup.repository.jdbc;

import org.gerdoc.pixup.model.Usuario;

import java.util.List;

public interface UsuarioJdbc {
    List<Usuario> findAll();

}
