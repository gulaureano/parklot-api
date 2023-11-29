package gustavo.laureano.parklot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gustavo.laureano.parklot.domain.Pessoa;
import gustavo.laureano.parklot.dto.PessoaCadastradaDto;
import gustavo.laureano.parklot.dto.PessoaDeleteDto;
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

	public void deletaPessoa(PessoaDeleteDto pessoaDeleteDto) {
		if (pessoaDeleteDto.getId() != null) {
			deletaPorId(pessoaDeleteDto.getId());
		}
		
		if (pessoaDeleteDto.getCpf() != null) {
			deletaPorCPF(pessoaDeleteDto.getCpf());
		} else {
			throw new NullPointerException();
		}
	}

	private void deletaPorCPF(String cpf) {
		Pessoa pessoa = repository.findByCpf(cpf);
		try {
			if(pessoa == null) {
				throw new PessoaInexistenteException();
			}
			repository.delete(pessoa);
		} catch (PessoaInexistenteException e) {
			e.getMessage();
		}
		
	}

	private void deletaPorId(Integer id) {
		Optional<Pessoa> pessoa = repository.findById(id);
		try {
			if (!pessoa.isPresent()) {
				throw new PessoaInexistenteException();
			}
			repository.delete(pessoa.get());
		} catch (PessoaInexistenteException e) {
			e.getMessage();
		}
	}

}
