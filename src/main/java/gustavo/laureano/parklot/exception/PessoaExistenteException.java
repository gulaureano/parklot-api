package gustavo.laureano.parklot.exception;

import gustavo.laureano.parklot.dto.PessoaCadastradaDto;

public class PessoaExistenteException extends Exception {
	
	private PessoaCadastradaDto dto;

	public PessoaExistenteException(PessoaCadastradaDto pessoaDto) {
		dto = pessoaDto;
	}
	
	
	
	

}
