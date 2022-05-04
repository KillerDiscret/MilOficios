package pe.edu.upc.miloficios.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import pe.edu.upc.miloficios.entidades.Departamento;
import pe.edu.upc.miloficios.entidades.Provincia;
import pe.edu.upc.miloficios.service.IProvinciaService;

public class ProvinciaController {
	
	@Inject
	private IProvinciaService pService;

	private Provincia p;

	List<Provincia> listaProvincias;
	
	// Constructor
		@PostConstruct
		public void init() {
			this.listaProvincias = new ArrayList<Provincia>();
			this.p = new Provincia();
			this.list();
		}

		// Métodos

		public String newProvincia() {

			this.setP(new Provincia());
			return "Provincia.xhtml";
		}

		public void insert() {
			try {
				pService.insert(p);

			} catch (Exception e) {
				System.out.println("Error al insertar en el controller provincia");
			}
		}

		public void list() {
			try {
				listaProvincias = pService.list();
			} catch (Exception e) {
				System.out.println("Error al listar en controller provincia");
			}
		}

		public void delete(Provincia pro) {
			try {
				pService.delete(pro.getIdProvincia());
				this.list();
			} catch (Exception e) {
				System.out.println("Error al eliminar en el controller provincia");
			}
		}

		public String premodificar(Provincia p) {
			this.setP(p);
			return "modificacion.xhtml";
		}
		
		public void modificar() {
			try {
				pService.modificar(this.p);
			} catch (Exception e) {
				System.out.println("Error al modificar el controlador de provincia");
			}
		}
		
		public void findByname() {
			try {
				listaProvincias=pService.findByName(this.getP());
			} catch (Exception e) {
				System.out.println("Error al buscar en el controller provincia");
			}
		}
		
		public Provincia getP() {
			return p;
		}

		public void setP(Provincia p) {
			this.p = p;
		}

		public List<Provincia> getListaProvincias() {
			return listaProvincias;
		}

		public void setListaProvincias(List<Provincia> listaProvincias) {
			this.listaProvincias = listaProvincias;
		}
		
}
