package gustavo.laureano.parklot.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldError {
	
	private String campo;
	private String erro;
	
	public FieldError(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}
	
	

}
