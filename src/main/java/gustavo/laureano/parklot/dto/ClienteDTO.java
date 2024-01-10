package gustavo.laureano.parklot.dto;

import gustavo.laureano.parklot.domain.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
	
	private Integer id;
	private PessoaDto pessoa;

	public ClienteDTO(Integer id, Cliente cliente) {
		this.id = id;
		this.pessoa = new PessoaDto(cliente.getIdPessoa());
	}

	public ClienteDTO() {
	}
	
	

}
