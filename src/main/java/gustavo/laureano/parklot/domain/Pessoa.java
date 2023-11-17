package gustavo.laureano.parklot.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pessoa {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private Boolean isCliente;
	private Boolean isLocador;
	
	@OneToMany(mappedBy = "donoCarro")
	private List<Carro> carros = new ArrayList<>();
	
	public Pessoa(){

	}

}
