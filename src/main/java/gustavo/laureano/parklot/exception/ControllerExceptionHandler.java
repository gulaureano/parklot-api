package gustavo.laureano.parklot.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(PessoaExistenteException.class)
	public ResponseEntity<ErroPadrao> pessoaExistente(PessoaExistenteException e, HttpServletRequest request){
		ErroPadrao erro = new ErroPadrao(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Pessoa Já existente", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(PessoaInexistenteException.class)
	public ResponseEntity<ErroPadrao> pessoaInexistenteException(PessoaInexistenteException e, HttpServletRequest request) {
		String path = request.getRequestURI();
		ErroPadrao erro = new ErroPadrao(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Pessoa Inexistente", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroPadrao> dadosInvalidos(MethodArgumentNotValidException e, HttpServletRequest request) {
		String path = request.getRequestURI();
		ValidacaoException erro = new ValidacaoException(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Validacao Exception", "Falha na Validação", request.getRequestURI());
		for (FieldError ex : e.getFieldErrors()) {
			erro.addFieldError(ex.getField(), ex.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	

}
