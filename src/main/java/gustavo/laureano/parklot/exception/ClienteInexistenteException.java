package gustavo.laureano.parklot.exception;


public class ClienteInexistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClienteInexistenteException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClienteInexistenteException(String message) {
		super(message);
	}
	
	public ClienteInexistenteException() {
	}
	
	

}
