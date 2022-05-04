package pe.edu.upc.miloficios.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pregunta")
public class Pregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPregunta;

	@Column(name = "Texto", nullable = false, length = 40)
	private String Texto;

	public Pregunta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pregunta(int idPregunta, String Texto) {
		super();
		this.idPregunta = idPregunta;
		this.Texto = Texto;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getTexto() {
		return Texto;
	}

	public void setTexto(String Texto) {
		this.Texto = Texto;
	}

}