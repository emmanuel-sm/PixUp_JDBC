package pixup.repository.jdbc;

import org.gerdoc.pixup.model.Colonia;

import java.util.List;

public interface ColoniaJdbc {
    List<Colonia> findAll();
}
