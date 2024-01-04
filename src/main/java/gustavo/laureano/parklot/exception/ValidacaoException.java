package gustavo.laureano.parklot.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class ValidacaoException extends ErroPadrao {
	
	List<FieldError> erros = new ArrayList<>();

	public ValidacaoException() {
		super();
	}

	public ValidacaoException(LocalDateTime timestamp, Integer status, String erro, String messagem, String path) {
		super(timestamp, status, erro, messagem, path);
	}
	
	public void addFieldError(String campo, String erro) {
		this.erros.add(new FieldError(campo, erro));
	}
	
	

}
