package py.edu.facitec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import py.edu.facitec.model.Suscrito;

@Repository
public interface SuscritoRepository extends JpaRepository<Suscrito, Long> {

	List<Suscrito> findByCodigo(Long codigo);

}
