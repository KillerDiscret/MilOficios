package pe.edu.upc.miloficios.service;

import java.util.List;

import pe.edu.upc.miloficios.entidades.Encuesta;

public interface IEncuestaService {
	
	public void insert(Encuesta e);
	
	public List<Encuesta> list();
	
	public void delete(int idEncuesta);
	
	public void modificar(Encuesta en); 
	
	public List<Encuesta> findByName(Encuesta en); 
}
