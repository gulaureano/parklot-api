package gustavo.laureano.parklot.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import gustavo.laureano.parklot.exception.PessoaExistenteException;
import gustavo.laureano.parklot.exception.PessoaInexistenteException;

@RestControllerAdvice
public class PessoaControllerException extends Exception {
	
	@ExceptionHandler(PessoaExistenteException.class)
	public ResponseEntity<String> pessoaExistente(){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O CPF informado já está cadastrado!");
	}
	
	@ExceptionHandler(PessoaInexistenteException.class)
	public ResponseEntity<String> pessoaInexistenteException() {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível encontrar um cliente ou locador");
	}
	
	

}
