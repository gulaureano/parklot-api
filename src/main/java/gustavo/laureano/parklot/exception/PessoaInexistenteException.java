package gustavo.laureano.parklot.exception;


public class PessoaInexistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public PessoaInexistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public PessoaInexistenteException(String message) {
		super(message);
	}
	
	public PessoaInexistenteException() {
	}
	
	

}
