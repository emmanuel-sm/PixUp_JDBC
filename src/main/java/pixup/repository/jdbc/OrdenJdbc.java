package pixup.repository.jdbc;

import org.gerdoc.pixup.model.Orden;

import java.util.List;

public interface OrdenJdbc {
    List<Orden> findAll();

}
