package gustavo.laureano.parklot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gustavo.laureano.parklot.domain.Cliente;
import gustavo.laureano.parklot.dto.ClienteDTO;
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
			Optional<Cliente> cli = repository.findById(id);
			if (!cli.isPresent()) {
				throw new ClienteInexistenteException("Cliente inexistente por esse ID: " + id);
			}
			return cli.get();
	}

	public void cadastrarCliente(Integer id) throws PessoaInexistenteException {
		PessoaDto pessoaDTO = pessoaService.recuperaPessoaDto(id);
		pessoaDTO.setIsCliente(true);
		pessoaDTO.setIsLocador(false);
		
	}

	public List<ClienteDTO> findAll() {
		List<Cliente> clientes = repository.findAll();
		return clientes.stream().map(cli -> new ClienteDTO(cli.getId(), cli)).collect(Collectors.toList());
	}

}
