package gustavo.laureano.parklot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gustavo.laureano.parklot.domain.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Integer> {

}
