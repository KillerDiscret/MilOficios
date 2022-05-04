package pe.edu.upc.miloficios.service;

import java.util.List;

import pe.edu.upc.miloficios.entidades.TipoNotificacion;

public interface ITipoNotificacionService {

	public void insert(TipoNotificacion tn);

	public List<TipoNotificacion> list();

	public void delete(int idTipoNotificacion);
	
	public void modificar(TipoNotificacion tn); 
	
	public List<TipoNotificacion> findByName(TipoNotificacion tn); 
}
