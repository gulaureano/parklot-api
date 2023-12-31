package gustavo.laureano.parklot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vaga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String quadra;
	private String numero;
	private Boolean isOcupado;
	
	@OneToOne
	private Carro carroOcupado;
	
	public Vaga() {
	}

}
