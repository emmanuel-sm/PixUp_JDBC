package pixup.repository.jdbc;

import org.gerdoc.pixup.model.Municipio;

import java.util.List;

public interface MunicipioJdbc {
    List<Municipio> findAll();

}
