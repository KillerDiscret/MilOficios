package pe.edu.upc.miloficios.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoNotificacion")
public class TipoNotificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTipoNotificacion;
	
	@Column(name="nombreNotificacion", nullable=false, length=40)
	private String nombreNotificacion;
	
	@Column(name="descripcionNotificacion", nullable=false, length=200)
	private String descripcionNotificacion;

	public TipoNotificacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoNotificacion(int idTipoNotificacion, String nombreNotificacion, String descripcionNotificacion) {
		super();
		this.idTipoNotificacion = idTipoNotificacion;
		this.nombreNotificacion = nombreNotificacion;
		this.descripcionNotificacion = descripcionNotificacion;
	}

	public int getIdTipoNotificacion() {
		return idTipoNotificacion;
	}

	public void setIdTipoNotificacion(int idTipoNotificacion) {
		this.idTipoNotificacion = idTipoNotificacion;
	}

	public String getNombreNotificacion() {
		return nombreNotificacion;
	}

	public void setNombreNotificacion(String nombreNotificacion) {
		this.nombreNotificacion = nombreNotificacion;
	}

	public String getDescripcionNotificacion() {
		return descripcionNotificacion;
	}

	public void setDescripcionNotificacion(String descripcionNotificacion) {
		this.descripcionNotificacion = descripcionNotificacion;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idTipoNotificacion);
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoNotificacion other = (TipoNotificacion) obj;
		return idTipoNotificacion == other.idTipoNotificacion;
	}

}
