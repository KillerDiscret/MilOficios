package pe.edu.upc.miloficios.service;

import java.util.List;

import pe.edu.upc.miloficios.entidades.Pregunta;

public interface IPreguntaService {

	public void insert(Pregunta p);
	
	public List<Pregunta> list();
	
	public void delete(int idPregunta);
	
	public void update(Pregunta pr);
	
	public List<Pregunta> findByName(Pregunta pr);
	
}