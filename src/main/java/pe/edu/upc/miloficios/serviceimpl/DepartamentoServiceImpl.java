package pe.edu.upc.miloficios.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.miloficios.dao.IDepartamentoDao;
import pe.edu.upc.miloficios.entidades.Departamento;
import pe.edu.upc.miloficios.service.IDepartamentoService;

@Named
public class DepartamentoServiceImpl implements IDepartamentoService {

	@Inject
	private IDepartamentoDao dDao;

	@Override
	public void insert(Departamento d) {
		dDao.insert(d);
	}

	@Override
	public List<Departamento> list() {
		// TODO Auto-generated method stub
		return dDao.list();
	}

	@Override
	public void delete(int idDepartamento) {
		// TODO Auto-generated method stub
		dDao.delete(idDepartamento);		
	}
	
	
	
	
	
	
}
