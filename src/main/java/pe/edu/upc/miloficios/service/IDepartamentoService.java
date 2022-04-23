package pe.edu.upc.miloficios.service;

import java.util.List;

import pe.edu.upc.miloficios.entidades.Departamento;

public interface IDepartamentoService {

	public void insert(Departamento d);
	
	public List<Departamento> list();
	
	public void delete(int idDepartamento);
	
}
