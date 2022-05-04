package pe.edu.upc.miloficios.service;

import java.util.List;

import pe.edu.upc.miloficios.entidades.Distrito;

public interface IDistritoService {
	
	public void insert(Distrito d);
	
	public List<Distrito> list();
	
	public void delete(int idDistrito);
	
	public void modificar(Distrito di); 
	
	public List<Distrito> findByName(Distrito di); 
}
