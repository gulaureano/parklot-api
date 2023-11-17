package gustavo.laureano.parklot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String marca;
	private String modelo;
	
	@ManyToOne
	private Pessoa donoCarro;
	private String placa;
	
	@OneToOne(mappedBy = "carroOcupado")
	private Vaga vagaOcupada;
	
	public Carro() {
	}
	

}
