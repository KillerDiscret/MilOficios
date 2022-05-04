package pe.edu.upc.miloficios.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import pe.edu.upc.miloficios.entidades.Departamento;
import pe.edu.upc.miloficios.entidades.Distrito;
import pe.edu.upc.miloficios.service.IDistritoService;

public class DistritoController {

	@Inject
	private IDistritoService diService;

	private Distrito d;

	List<Distrito> listaDistritos;
	
	// Constructor
			@PostConstruct
			public void init() {
				this.listaDistritos = new ArrayList<Distrito>();
				this.d = new Distrito();
				this.list();
			}

			// Métodos

			public String newDistrito() {

				this.setD(new Distrito());
				return "Distrito.xhtml";
			}

			public void insert() {
				try {
					diService.insert(d);

				} catch (Exception e) {
					System.out.println("Error al insertar en el controller distrito");
				}
			}

			public void list() {
				try {
					listaDistritos = diService.list();
				} catch (Exception e) {
					System.out.println("Error al listar en controller distrito");
				}
			}

			public void delete(Distrito dis) {
				try {
					diService.delete(dis.getIdDistrito());
					this.list();
				} catch (Exception e) {
					System.out.println("Error al eliminar en el controller distrito");
				}
			}

			public String premodificar(Distrito dis) {
				this.setD(dis);
				return "modificacion.xhtml";
			}
			
			public void modificar() {
				try {
					diService.modificar(this.d);
				} catch (Exception e) {
					System.out.println("Error al modificar el controlador de distrito");
				}
			}
			
			public void findByname() {
				try {
					listaDistritos=diService.findByName(this.getD());
				} catch (Exception e) {
					System.out.println("Error al buscar en el controller distrito");
				}
			}
			
			public Distrito getD() {
				return d;
			}

			public void setD(Distrito d) {
				this.d = d;
			}

			public List<Distrito> getListaDistritos() {
				return listaDistritos;
			}

			public void setListaDistritos(List<Distrito> listaDistritos) {
				this.listaDistritos = listaDistritos;
			}
			
}
