package pe.edu.upc.miloficios.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Encuesta")
public class Encuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEncuesta;

	@Column(name = "respuesta", nullable = false, length = 40)
	private String respuesta;

	@ManyToOne
	@JoinColumn(name="idPregunta", nullable = false)
	private Pregunta pregunta;
	
	public Encuesta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Encuesta(int idEncuesta, String respuesta, Pregunta pregunta) {
		super();
		this.idEncuesta = idEncuesta;
		this.respuesta = respuesta;
		this.pregunta = pregunta;
	}

	public int getIdEncuesta() {
		return idEncuesta;
	}

	public void setIdEncuesta(int idEncuesta) {
		this.idEncuesta = idEncuesta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	
}
