package pe.edu.upc.miloficios.dao;

import java.util.List;

import pe.edu.upc.miloficios.entidades.Departamento;

public interface IDepartamentoDao {

	public void insert(Departamento d);
	
	public List<Departamento> list();
	
	public void delete(int idDepartamento);
	
	
}
