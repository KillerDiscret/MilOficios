package pe.edu.upc.miloficios.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.miloficios.entidades.Provincia;
import pe.edu.upc.miloficios.entidades.Distrito;
import pe.edu.upc.miloficios.service.IProvinciaService;
import pe.edu.upc.miloficios.service.IDistritoService;

@Named
@RequestScoped
public class DistritoController {

	@Inject
	private IDistritoService dsService;

	@Inject
	private IProvinciaService pService;

	private Distrito dst;
	private List<Distrito> listaDistritos;
	List<Provincia> listaProvincias;

	@PostConstruct
	public void init() {
		this.dst = new Distrito();
		this.listaDistritos = new ArrayList<Distrito>();
		this.listaProvincias = new ArrayList<Provincia>();
		this.listProvincias();
		this.list();

	}

	public void insert() {

		try {
			dsService.insert(dst);

		} catch (Exception e) {
			System.out.println("Error al insertar en el controlador de Distrito");
		}

	}

	public void list() {
		try {
			listaDistritos = dsService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controlador de Distrito");
		}

	}

	public void delete(Distrito dis) {

		try {

			dsService.delete(dis.getId());
			this.list();

		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller Distrito");
		}

	}

	public void listProvincias() {

		try {

			listaProvincias = pService.list();
		} catch (Exception e) {
			System.out.println("Error al listar Provincias en el controlador de Distrito");
		}

	}

	public void update() {

		try {
			dsService.update(dst);
		} catch (Exception e) {
			System.out.println("Error al modificar controlador de Distrito");
		}

	}

	public String preUpdate(Distrito dst) {
		this.setDst(dst);
		return "modificacionDistrito.xhtml";

	}

	public void findByName() {

		try {
			listaDistritos = dsService.findByName(this.getDst());

		} catch (Exception e) {

			System.out.println("Error al buscar en el controlador de Provincia");
		}

	}

	public Distrito getDst() {
		return dst;
	}

	public void setDst(Distrito dst) {
		this.dst = dst;
	}

	public List<Distrito> getListaDistritos() {
		return listaDistritos;
	}

	public void setListaDistritos(List<Distrito> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}

	public List<Provincia> getListaProvincias() {
		return listaProvincias;
	}

	public void setListaProvincias(List<Provincia> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

}
