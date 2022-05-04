package pe.edu.upc.miloficios.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.miloficios.entidades.Departamento;
import pe.edu.upc.miloficios.entidades.Provincia;
import pe.edu.upc.miloficios.service.IDepartamentoService;
import pe.edu.upc.miloficios.service.IProvinciaService;

@Named
@RequestScoped
public class ProvinciaController {

	@Inject
	private IProvinciaService pService;
	
	@Inject
	private IDepartamentoService dService;
	
	private Provincia pr;
	private List<Provincia> listaProvincias;
	List<Departamento> listaDepartamentos;
	
	@PostConstruct
	public void init() {
		this.pr = new Provincia();
		this.listaProvincias = new ArrayList<Provincia>();
		this.listaDepartamentos = new ArrayList<Departamento>();
		this.listDepartamentos();
		this.list();
		
	}
	
	
	
	
	public void insert() {
		
		try {
			pService.insert(pr);
			
		} catch (Exception e) {
			System.out.println("Error al insertar en el controlador de provincia");
		}
		
	}
	
	public void list() {
		try {
			listaProvincias = pService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en el controlador de provincia");
		}
		
	}
	
	public void listDepartamentos() {
		
		try {
			
			listaDepartamentos = dService.list();
		} catch (Exception e) {
			System.out.println("Error al listar departamentos en el controlador de provincia");
		}
		
	}
	
	public void update() {
		
		try {
			pService.update(pr);
		} catch (Exception e) {
			System.out.println("Error al modificar controlador de provincia");
		}
		
		
	}
	
	public String preUpdate(Provincia pr) {
		this.setPr(pr);
		return "modificacionProvincia.xhtml";
		
	}




	public Provincia getPr() {
		return pr;
	}




	public void setPr(Provincia pr) {
		this.pr = pr;
	}




	public List<Provincia> getListaProvincias() {
		return listaProvincias;
	}




	public void setListaProvincias(List<Provincia> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}




	public List<Departamento> getListaDepartamentos() {
		return listaDepartamentos;
	}




	public void setListaDepartamentos(List<Departamento> listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
	}
	
	
	
}
