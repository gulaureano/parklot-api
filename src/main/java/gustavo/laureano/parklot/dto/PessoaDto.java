package gustavo.laureano.parklot.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDto {
	
	
	
	public PessoaDto(String nome, String cpf, LocalDate dataNascimento, Boolean isCliente, Boolean isLocador) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.isCliente = isCliente;
		this.isLocador = isLocador;
	}
	
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private Boolean isCliente;
	private Boolean isLocador;
	

}
