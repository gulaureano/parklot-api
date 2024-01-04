package gustavo.laureano.parklot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gustavo.laureano.parklot.dto.PessoaCadastradaDto;
import gustavo.laureano.parklot.dto.PessoaDeleteDto;
import gustavo.laureano.parklot.dto.PessoaDto;
import gustavo.laureano.parklot.exception.DadosNuloException;
import gustavo.laureano.parklot.exception.PessoaExistenteException;
import gustavo.laureano.parklot.exception.PessoaInexistenteException;
import gustavo.laureano.parklot.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	PessoaService service;
	
	@PostMapping
	public ResponseEntity<PessoaCadastradaDto> cadastrarPessoa(@Valid @RequestBody PessoaCadastradaDto pessoaDto) throws DadosNuloException, PessoaExistenteException{
		if (pessoaDto == null) {
			throw new DadosNuloException("Dados Nulo");
		}
		String mensagem = service.cadastrarPessoa(pessoaDto);
		if (mensagem == null) {
			mensagem = "O CPF digitado já existe na nossa base de dados";
			pessoaDto.setMensagemRetorno(mensagem);
			
		} 
		pessoaDto.setMensagemRetorno(mensagem);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PessoaDto> getPessoa(@PathVariable Integer id) throws PessoaInexistenteException {
		if(id == null) {
			throw new PessoaInexistenteException("ID nulo");
		}
		PessoaDto pessoaDto = service.recuperaPessoaDto(id);
		if (pessoaDto == null) {
			throw new PessoaInexistenteException("Não ");
		}
		return ResponseEntity.ok().body(pessoaDto);
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaDto>> findAll() throws PessoaInexistenteException {
		List<PessoaDto> pessoasDto = service.findAll();
		if (pessoasDto == null || pessoasDto.isEmpty()) {
			throw new PessoaInexistenteException("Não possui dados de Pessoa no banco");
		}
		return ResponseEntity.ok().body(pessoasDto);
	}
	
	@DeleteMapping
	public ResponseEntity<PessoaDeleteDto> deletarPessoa(@RequestBody PessoaDeleteDto pessoaDeleteDto) throws PessoaInexistenteException {
		PessoaDeleteDto pessoaDelete = service.deletaPessoa(pessoaDeleteDto);
		pessoaDelete.setMensagem("Pessoa: " + pessoaDelete.getNome() + " com CPF: " + pessoaDelete.getCpf() + " deletado com sucesso");
		return ResponseEntity.ok(pessoaDelete);
	}

}
