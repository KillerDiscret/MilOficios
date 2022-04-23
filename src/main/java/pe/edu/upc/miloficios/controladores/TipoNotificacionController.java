package pe.edu.upc.miloficios.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.miloficios.entidades.TipoNotificacion;
import pe.edu.upc.miloficios.service.ITipoNotificacionService;

@Named
@RequestScoped
public class TipoNotificacionController {
	@Inject
	private ITipoNotificacionService tnService;

	private TipoNotificacion tn;

	List<TipoNotificacion> listaTipoNotificaciones;

	// Constructor
	@PostConstruct
	public void init() {
		this.listaTipoNotificaciones = new ArrayList<TipoNotificacion>();
		this.tn = new TipoNotificacion();
		this.list();
	}

	// Métodos
	public String newTipoNotificacion() {

		this.setD(new TipoNotificacion());
		return "TipoNotificacion.xhtml";
	}

	public void insert() {
		try {
			tnService.insert(tn);

		} catch (Exception e) {
			System.out.println("Error al insertar en el controller Tipo de notificacion");
		}
	}

	public void list() {
		try {
			listaTipoNotificaciones = tnService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en controller Tipo de Notificacion");
		}
	}

	public void delete(TipoNotificacion tdp) {
		try {
			tnService.delete(tdp.getIdTipoNotificacion());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller Tipo de Notificacion");
		}

	}

	// getters and setters

	public TipoNotificacion getD() {
		return tn;
	}

	public void setD(TipoNotificacion tn) {
		this.tn = tn;
	}

	public List<TipoNotificacion> getListaTipoNotificaciones() {
		return listaTipoNotificaciones;
	}

	public void setListaTipoNotificaciones(List<TipoNotificacion> listaTipoNotificaciones) {
		this.listaTipoNotificaciones = listaTipoNotificaciones;
	}
}
