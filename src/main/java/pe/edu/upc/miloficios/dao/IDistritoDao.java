package pe.edu.upc.miloficios.dao;

import java.util.List;

import pe.edu.upc.miloficios.entidades.Distrito;

public interface IDistritoDao {
	
	public void insert(Distrito ds);

	public List<Distrito> list();

	public void delete(int idDistrito);

	public void update(Distrito ds);

	public List<Distrito> findByName(Distrito ds);

}
