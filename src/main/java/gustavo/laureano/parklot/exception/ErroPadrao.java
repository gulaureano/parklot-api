package gustavo.laureano.parklot.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErroPadrao {
	
	private LocalDateTime timestamp;
	private Integer status;
	private String erro;
	private String path;
	private String messagem;
	
	public ErroPadrao() {
		super();
	}

	public ErroPadrao(LocalDateTime timestamp, Integer status, String erro, String messagem, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.erro = erro;
		this.path = path;
		this.messagem = messagem;
	}

}
