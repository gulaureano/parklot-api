package gustavo.laureano.parklot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gustavo.laureano.parklot.domain.Pessoa;
import gustavo.laureano.parklot.dto.PessoaCadastradaDto;
import gustavo.laureano.parklot.dto.PessoaDeleteDto;
import gustavo.laureano.parklot.dto.PessoaDto;
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
			Optional<Pessoa> pessoa = repository.findById(id);
			if (!pessoa.isPresent()) {
				throw new PessoaInexistenteException("Não existe pessoa com este ID: " + id);
			}
			return new PessoaDto(pessoa.get().getNome(), pessoa.get().getCpf(), pessoa.get().getDataNascimento(), pessoa.get().getIsCliente(), pessoa.get().getIsLocador());
	}

	public PessoaDeleteDto deletaPessoa(PessoaDeleteDto pessoaDeleteDto) throws PessoaInexistenteException {
		if (pessoaDeleteDto.getId() != null) {
			return deletaPorId(pessoaDeleteDto.getId());
		}
		
		if (pessoaDeleteDto.getCpf() != null) {
			return deletaPorCPF(pessoaDeleteDto.getCpf());
		} else {
			throw new PessoaInexistenteException("Os campos informados estão nulos");
		}
	}

	private PessoaDeleteDto deletaPorCPF(String cpf) throws PessoaInexistenteException {
		Pessoa pessoa = repository.findByCpf(cpf);
		if(pessoa == null) {
			throw new PessoaInexistenteException("CPF inexistente no banco " + cpf);
		}
		PessoaDeleteDto pessoaDeletada = new PessoaDeleteDto(pessoa.getNome(), pessoa.getCpf(), pessoa.getId());
		repository.delete(pessoa);
		return pessoaDeletada;
		
	}

	private PessoaDeleteDto deletaPorId(Integer id) throws PessoaInexistenteException {
		Optional<Pessoa> pessoa = repository.findById(id);
		
			if (!pessoa.isPresent()) {
				throw new PessoaInexistenteException("ID inexistente no banco " + id);
			}
			PessoaDeleteDto pessoaDeletada = new PessoaDeleteDto(pessoa.get().getNome(), pessoa.get().getCpf(), pessoa.get().getId());
			repository.delete(pessoa.get());
			return pessoaDeletada;
	}

	public List<PessoaDto> findAll() {
		List<Pessoa> pessoas = repository.findAll();
		return pessoas.stream().map(pessoa -> new PessoaDto(pessoa)).collect(Collectors.toList());
		
	}

}
