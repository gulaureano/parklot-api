package gustavo.laureano.parklot.dto;

import java.time.LocalDate;

import gustavo.laureano.parklot.domain.Pessoa;
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
	
	public PessoaDto(Pessoa pessoa) {
		this.nome = pessoa.getNome();
		this.cpf = pessoa.getCpf();
		this.dataNascimento = pessoa.getDataNascimento();
		this.isCliente = pessoa.getIsCliente();
		this.isLocador = pessoa.getIsLocador();		
	}
	
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private Boolean isCliente;
	private Boolean isLocador;
	

}
