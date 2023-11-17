package gustavo.laureano.parklot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gustavo.laureano.parklot.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
