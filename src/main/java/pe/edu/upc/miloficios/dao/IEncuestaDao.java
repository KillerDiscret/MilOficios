package pe.edu.upc.miloficios.dao;

import java.util.List;

import pe.edu.upc.miloficios.entidades.Encuesta;

public interface IEncuestaDao {
	
	public void insert(Encuesta en);
	
	public List<Encuesta> list();
	
	public void delete(int idEncuesta);
	
	public void modificar(Encuesta en);
	
	public List<Encuesta> findByName(Encuesta en);
}
