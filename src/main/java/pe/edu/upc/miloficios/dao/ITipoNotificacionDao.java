package pe.edu.upc.miloficios.dao;

import java.util.List;

import pe.edu.upc.miloficios.entidades.TipoNotificacion;

public interface ITipoNotificacionDao {

	public void insert(TipoNotificacion tn);

	public List<TipoNotificacion> list();

	public void delete(int idTipoNotificacion);
	
	public void modificar(TipoNotificacion tn);
	
	public List<TipoNotificacion> findByName(TipoNotificacion tn);
}
