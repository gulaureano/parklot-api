package gustavo.laureano.parklot.controller.exception;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import gustavo.laureano.parklot.dto.PessoaCadastradaDto;
import gustavo.laureano.parklot.exception.PessoaExistenteException;

@RestControllerAdvice
public class PessoaControllerException extends Exception {
	
	@ExceptionHandler(PessoaExistenteException.class)
	public ResponseEntity<PessoaCadastradaDto> pessoaExistente(PessoaExistenteException ex, HttpServletRequest request){
		String nome =  (String) request.getAttribute("nome");
		String cpf =  (String) request.getAttribute("cpf");
		LocalDate data = (LocalDate) request.getAttribute("cpf");
		
		PessoaCadastradaDto dto = new PessoaCadastradaDto();
		dto.setNome(nome);
		dto.setCpf(cpf);
		dto.setDataNascimento(data);
		dto.setMensagemRetorno("O CPF digitado já está cadastrado");
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
		
	}
	
	

}
