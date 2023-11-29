package gustavo.laureano.parklot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gustavo.laureano.parklot.domain.Pessoa;
import gustavo.laureano.parklot.dto.PessoaCadastradaDto;
import gustavo.laureano.parklot.dto.PessoaDto;
import gustavo.laureano.parklot.exception.PessoaExistenteException;
import gustavo.laureano.parklot.exception.PessoaInexistenteException;
import gustavo.laureano.parklot.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository repository;

	public String cadastrarPessoa(PessoaCadastradaDto pessoaDto) {
		Pessoa pessoa = repository.findByCpf(pessoaDto.getCpf());
		if (pessoa == null) {
			Pessoa pessoaVolta = PessoaCadastradaDto.convertePessoa(pessoaDto);
			repository.save(pessoaVolta);
			return "Pessoa Cadastrada com sucesso";
		}
		return null;
	}

	public PessoaDto recuperaPessoaDto(Integer id) throws PessoaInexistenteException {
		Pessoa pessoa = repository.getReferenceById(id);
		if (pessoa != null) {
			return new PessoaDto(pessoa.getNome(), pessoa.getCpf(), pessoa.getDataNascimento(), pessoa.getIsCliente(), pessoa.getIsLocador());
		}
		throw new PessoaInexistenteException();
	}

}
