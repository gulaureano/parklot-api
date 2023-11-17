package gustavo.laureano.parklot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gustavo.laureano.parklot.domain.TotalVagas;

@Repository
public interface TotalVagasRepository extends JpaRepository<TotalVagas, Integer> {

}
