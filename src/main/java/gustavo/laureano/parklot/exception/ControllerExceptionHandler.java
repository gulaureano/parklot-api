package gustavo.laureano.parklot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(PessoaExistenteException.class)
	public ResponseEntity<String> pessoaExistente(){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O CPF informado já está cadastrado!");
	}
	
	@ExceptionHandler(PessoaInexistenteException.class)
	public ResponseEntity<String> pessoaInexistenteException(PessoaInexistenteException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	

}
