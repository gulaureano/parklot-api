package gustavo.laureano.parklot.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import gustavo.laureano.parklot.domain.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaCadastradaDto {
	
	private String nome;
	private String cpf;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	private String mensagemRetorno;
	
	public static Pessoa convertePessoa(PessoaCadastradaDto pessoaDto) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(pessoaDto.getNome());
		pessoa.setDataNascimento(pessoaDto.getDataNascimento());
		pessoa.setCpf(pessoaDto.getCpf());
		return pessoa;
		
	}

}
