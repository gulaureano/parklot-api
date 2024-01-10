package gustavo.laureano.parklot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gustavo.laureano.parklot.domain.Cliente;
import gustavo.laureano.parklot.dto.ClienteDTO;
import gustavo.laureano.parklot.exception.ClienteInexistenteException;
import gustavo.laureano.parklot.exception.PessoaInexistenteException;
import gustavo.laureano.parklot.service.ClienteService;
import gustavo.laureano.parklot.service.PessoaService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService service;
	
	@Autowired
	PessoaService pessoaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> getCliente(@PathVariable Integer id) throws ClienteInexistenteException {
		Cliente cliente = service.findById(id);
		ClienteDTO cliDTO = new ClienteDTO(id, cliente);
		return ResponseEntity.ok(cliDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> retornaTodosClientes() {
		List<ClienteDTO> clientes = service.findAll();
		if (clientes == null) {
			throw new ClienteInexistenteException("Não há clientes cadastrados nessa base");
		}
		return ResponseEntity.ok(clientes);
	}

}
