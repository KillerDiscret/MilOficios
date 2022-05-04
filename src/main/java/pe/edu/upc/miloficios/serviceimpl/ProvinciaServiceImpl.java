package pe.edu.upc.miloficios.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.miloficios.dao.IProvinciaDao;
import pe.edu.upc.miloficios.entidades.Provincia;
import pe.edu.upc.miloficios.service.IProvinciaService;

@Named
public class ProvinciaServiceImpl implements IProvinciaService {

	@Inject
	private IProvinciaDao pDao;
	
	@Override
	public void insert(Provincia p) {
		// TODO Auto-generated method stub
		pDao.insert(p);
	}

	@Override
	public List<Provincia> list() {
		// TODO Auto-generated method stub
		return pDao.list();
	}

	@Override
	public void delete(int idProvincia) {
		// TODO Auto-generated method stub
		pDao.delete(idProvincia);
	}

	@Override
	public void modificar(Provincia p) {
		// TODO Auto-generated method stub
		pDao.modificar(p);
	}

	@Override
	public List<Provincia> findByName(Provincia p) {
		// TODO Auto-generated method stub
		return pDao.findByName(p);
	}

}
