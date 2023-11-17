package gustavo.laureano.parklot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gustavo.laureano.parklot.domain.Locador;

@Repository
public interface LocadorRepository extends JpaRepository<Locador, Integer> {

}
