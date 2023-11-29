package gustavo.laureano.parklot.controller;

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
import gustavo.laureano.parklot.exception.PessoaExistenteException;
import gustavo.laureano.parklot.exception.PessoaInexistenteException;
import gustavo.laureano.parklot.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	PessoaService service;
	
	@GetMapping
	public String hello() {
		return "Hello Pessoa";
	}
	
	@PostMapping
	public ResponseEntity<PessoaCadastradaDto> cadastrarPessoa(@RequestBody PessoaCadastradaDto pessoaDto) throws PessoaExistenteException{
		String mensagem = service.cadastrarPessoa(pessoaDto);
		if (mensagem == null) {
			mensagem = "O CPF digitado já existe na nossa base de dados";
			pessoaDto.setMensagemRetorno(mensagem);
			throw new PessoaExistenteException();
		} 
		pessoaDto.setMensagemRetorno(mensagem);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PessoaDto> getPessoa(@PathVariable Integer id) throws PessoaInexistenteException {
		PessoaDto pessoaDto = service.recuperaPessoaDto(id);
		if (pessoaDto == null) {
			throw new PessoaInexistenteException();
		}
		return ResponseEntity.ok().body(pessoaDto);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deletarPessoa(@RequestBody PessoaDeleteDto pessoaDeleteDto) {
		service.deletaPessoa(pessoaDeleteDto);
		return null;
	}

}
