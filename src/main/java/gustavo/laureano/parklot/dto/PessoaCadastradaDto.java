package gustavo.laureano.parklot.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import gustavo.laureano.parklot.domain.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaCadastradaDto {
	
	@NotNull(message = "Campo NOME é obrigatório")
	@NotBlank(message = "Campo NOME é obrigatório")
	private String nome;
	
	@NotNull(message = "Campo CPF é obrigatório")
	@NotBlank(message = "Campo CPF é obrigatório")
	private String cpf;
	
	@NotNull(message = "Campo DATA NASC é obrigatório")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	@NotNull(message = "Campo CLIENTE é obrigatório")
	private Boolean isCliente;
	
	@NotNull(message = "Campo LOCADOR é obrigatório")
	private Boolean isLocador;
	private String mensagemRetorno;
	
	public static Pessoa convertePessoa(PessoaCadastradaDto pessoaDto) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(pessoaDto.getNome());
		pessoa.setDataNascimento(pessoaDto.getDataNascimento());
		pessoa.setCpf(pessoaDto.getCpf());
		pessoa.setIsCliente(pessoaDto.getIsCliente());
		pessoa.setIsLocador(pessoaDto.getIsLocador());
		return pessoa;
		
	}

}
