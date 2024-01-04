package gustavo.laureano.parklot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDeleteDto {
	
	public PessoaDeleteDto(String nome, String cpf, Integer id) {
		this.nome = nome;
		this.cpf = cpf;
		this.id = id;
	}
	
	
	private String nome;
	private String cpf;
	private Integer id;
	private String mensagem;

}
