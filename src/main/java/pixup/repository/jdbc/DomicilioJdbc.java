package pixup.repository.jdbc;

import org.gerdoc.pixup.model.Domicilio;

import java.util.List;

public interface DomicilioJdbc {
    List<Domicilio> findAll();
}
