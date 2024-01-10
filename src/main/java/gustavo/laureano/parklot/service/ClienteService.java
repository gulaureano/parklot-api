package gustavo.laureano.parklot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gustavo.laureano.parklot.domain.Cliente;
import gustavo.laureano.parklot.dto.PessoaDto;
import gustavo.laureano.parklot.exception.ClienteInexistenteException;
import gustavo.laureano.parklot.exception.PessoaInexistenteException;
import gustavo.laureano.parklot.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;
	
	@Autowired
	PessoaService pessoaService;

	public Cliente findById(Integer id) throws ClienteInexistenteException {
			Cliente cli = repository.getReferenceById(id);
			if (cli == null) {
				throw new ClienteInexistenteException("Cliente inexistente por esse ID: " + id);
			}
			return cli;
	}

	public void cadastrarCliente(Integer id) throws PessoaInexistenteException {
		PessoaDto pessoaDTO = pessoaService.recuperaPessoaDto(id);
		pessoaDTO.setIsCliente(true);
		pessoaDTO.setIsLocador(false);
		
	}

}
