package gustavo.laureano.parklot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gustavo.laureano.parklot.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
