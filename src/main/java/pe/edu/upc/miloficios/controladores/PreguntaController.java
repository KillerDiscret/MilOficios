package pe.edu.upc.miloficios.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.miloficios.entidades.Pregunta;
import pe.edu.upc.miloficios.service.IPreguntaService;

@Named
@RequestScoped
public class PreguntaController {

	@Inject
	private IPreguntaService pService;

	private Pregunta p;

	List<Pregunta> listaPreguntas;

	// Constructor
	@PostConstruct
	public void init() {
		this.listaPreguntas = new ArrayList<Pregunta>();
		this.p = new Pregunta();
		this.list();
	}

	// Métodos

	public String newPregunta() {

		this.setP(new Pregunta());
		return "Pregunta.xhtml";
	}

	public void insert() {
		try {
			pService.insert(p);

		} catch (Exception e) {
			System.out.println("Error al insertar en el controller pregunta");
		}
	}

	public void list() {
		try {
			listaPreguntas = pService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en controller pregunta");
		}
	}

	public void delete(Pregunta pre) {
		try {
			pService.delete(pre.getIdPregunta());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller pregunta");
		}

	}

	public void update() {

		try {
			pService.update(p);

		} catch (Exception e) {
			System.out.println("Error al modificar controlador de pregunta");
		}

	}
	
	public String preUpdate(Pregunta pr) {
		this.setP(pr);
		return "modificacionPregunta.xhtml";
	}
	
	
	public void findByName() {
		
		try {
			listaPreguntas = pService.findByName(this.getP());
			
		} catch (Exception e) {
			
			System.out.println("Error al buscar en el controlador de pregunta");
		}
		
	}
	

	// getters and setters

	public Pregunta getP() {
		return p;
	}

	public void setP(Pregunta p) {
		this.p = p;
	}

	public List<Pregunta> getListaPreguntas() {
		return listaPreguntas;
	}

	public void setListaPreguntas(List<Pregunta> listaPreguntas) {
		this.listaPreguntas = listaPreguntas;
	}

}
