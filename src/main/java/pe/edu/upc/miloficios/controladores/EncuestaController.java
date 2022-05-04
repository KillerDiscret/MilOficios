package pe.edu.upc.miloficios.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import pe.edu.upc.miloficios.entidades.Pregunta;
import pe.edu.upc.miloficios.entidades.Encuesta;
import pe.edu.upc.miloficios.service.IEncuestaService;

public class EncuestaController {

	@Inject
	private IEncuestaService enService;

	private Encuesta e;

	List<Encuesta> listaEncuestas;
	
	// Constructor
			@PostConstruct
			public void init() {
				this.listaEncuestas = new ArrayList<Encuesta>();
				this.e = new Encuesta();
				this.list();
			}

			// Métodos

			public String newDistrito() {

				this.setE(new Encuesta());
				return "Encuesta.xhtml";
			}

			public void insert() {
				try {
					enService.insert(e);

				} catch (Exception e) {
					System.out.println("Error al insertar en el controller encuesta");
				}
			}

			public void list() {
				try {
					listaEncuestas = enService.list();
				} catch (Exception e) {
					System.out.println("Error al listar en controller encuesta");
				}
			}

			public void delete(Encuesta enc) {
				try {
					enService.delete(enc.getIdEncuesta());
					this.list();
				} catch (Exception e) {
					System.out.println("Error al eliminar en el controller encuesta");
				}
			}

			public String premodificar(Encuesta enc) {
				this.setE(enc);
				return "modificacionEncuesta.xhtml";
			}
			
			public void modificar() {
				try {
					enService.modificar(this.e);
				} catch (Exception e) {
					System.out.println("Error al modificar el controlador de encuesta");
				}
			}
			
			public void findByname() {
				try {
					listaEncuestas=enService.findByName(this.getE());
				} catch (Exception e) {
					System.out.println("Error al buscar en el controller encuesta");
				}
			}
			
			public Encuesta getE() {
				return e;
			}

			public void setE(Encuesta e) {
				this.e= e;
			}

			public List<Encuesta> getListaEncuestas() {
				return listaEncuestas;
			}

			public void setListaDistritos(List<Encuesta> listaEncuestas) {
				this.listaEncuestas = listaEncuestas;
			}
			
}
