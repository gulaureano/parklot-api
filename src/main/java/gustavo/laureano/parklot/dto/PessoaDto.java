package gustavo.laureano.parklot.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

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
	
	@NotNull(message = "Campo NOME é obrigatório")
	private String nome;
	@NotNull(message = "Campo CPF é obrigatório")
	private String cpf;
	@NotNull(message = "Campo DATA NASC. é obrigatório")
	private LocalDate dataNascimento;
	@NotNull(message = "Campo CLIENTE é obrigatório")
	private Boolean isCliente;
	@NotNull(message = "Campo LOCADOR é obrigatório")
	private Boolean isLocador;
	

}
