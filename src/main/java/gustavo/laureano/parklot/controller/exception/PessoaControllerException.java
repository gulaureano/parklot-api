package gustavo.laureano.parklot.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import gustavo.laureano.parklot.exception.PessoaExistenteException;

@RestControllerAdvice
public class PessoaControllerException extends Exception {
	
	@ExceptionHandler(PessoaExistenteException.class)
	public ResponseEntity<String> pessoaExistente(PessoaExistenteException ex, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O CPF informado já está cadastrado!");
		
	}
	
	

}
