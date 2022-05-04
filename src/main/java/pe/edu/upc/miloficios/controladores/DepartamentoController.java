package pe.edu.upc.miloficios.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.miloficios.entidades.Departamento;
import pe.edu.upc.miloficios.service.IDepartamentoService;

@Named
@RequestScoped
public class DepartamentoController {

	@Inject
	private IDepartamentoService dService;

	private Departamento d;

	List<Departamento> listaDepartamentos;

	// Constructor
	@PostConstruct
	public void init() {
		this.listaDepartamentos = new ArrayList<Departamento>();
		this.d = new Departamento();
		this.list();
	}

	// Métodos

	public String newDepartamento() {

		this.setD(new Departamento());
		return "Departamento.xhtml";
	}

	public void insert() {
		try {
			dService.insert(d);

		} catch (Exception e) {
			System.out.println("Error al insertar en el controller departamento");
		}
	}

	public void list() {
		try {
			listaDepartamentos = dService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en controller departamento");
		}
	}

	public void delete(Departamento dep) {
		try {
			dService.delete(dep.getIdDepartamento());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller departamento");
		}

	}

	public void update() {

		try {
			dService.update(d);

		} catch (Exception e) {
			System.out.println("Error al modificar controlador de departamento");
		}

	}
	
	public String preUpdate(Departamento de) {
		this.setD(de);
		return "modificacionDepartamento.xhtml";
	}
	
	
	public void findByName() {
		
		try {
			listaDepartamentos = dService.findByName(this.getD());
			
		} catch (Exception e) {
			
			System.out.println("Error al buscar en el controlador de departamento");
		}
		
	}
	

	// getters and setters

	public Departamento getD() {
		return d;
	}

	public void setD(Departamento d) {
		this.d = d;
	}

	public List<Departamento> getListaDepartamentos() {
		return listaDepartamentos;
	}

	public void setListaDepartamentos(List<Departamento> listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
	}

}
