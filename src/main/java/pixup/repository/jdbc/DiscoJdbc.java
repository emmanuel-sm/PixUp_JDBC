package pixup.repository.jdbc;

import org.gerdoc.pixup.model.Disco;

import java.util.List;


public interface DiscoJdbc {
    List<Disco> findAll();
}
