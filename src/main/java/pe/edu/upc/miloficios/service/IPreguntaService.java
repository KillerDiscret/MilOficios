package pe.edu.upc.miloficios.service;

import java.util.List;

import pe.edu.upc.miloficios.entidades.Pregunta;

public interface IPreguntaService {

	public void insert(Pregunta d);
	
	public List<Pregunta> list();
	
	public void delete(int idPregunta);
	
	public void update(Pregunta de);
	
	public List<Pregunta> findByName(Pregunta pr);
	
}