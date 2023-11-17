package gustavo.laureano.parklot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gustavo.laureano.parklot.domain.Carro;

public interface CarroRepository extends JpaRepository<Carro, Integer> {

}
