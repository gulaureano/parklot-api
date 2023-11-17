package gustavo.laureano.parklot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gustavo.laureano.parklot.domain.Pessoa;
import gustavo.laureano.parklot.dto.PessoaCadastradaDto;
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

}
