package pe.edu.upc.miloficios.service;

import java.util.List;

import pe.edu.upc.miloficios.entidades.Distrito;

public interface IDistritoService {

	public void insert(Distrito dst);
	
	public List<Distrito> list();
	
	public void delete(int idDistrito);
	
	public void update(Distrito dst);
	
	public List<Distrito> findByName(Distrito dst);
	
}
