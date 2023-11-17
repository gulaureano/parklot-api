package gustavo.laureano.parklot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gustavo.laureano.parklot.domain.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

}
