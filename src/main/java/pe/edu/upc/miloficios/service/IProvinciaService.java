package pe.edu.upc.miloficios.service;

import java.util.List;

import pe.edu.upc.miloficios.entidades.Provincia;

public interface IProvinciaService {
	
	public void insert(Provincia p);
	
	public List<Provincia> list();
	
	public void delete(int idProvincia);
	
	public void modificar(Provincia p);
	
	public List<Provincia> findByName(Provincia p);
}
