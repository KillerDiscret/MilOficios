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
	private IProvinciaDao prDao;
	
	@Override
	public void insert(Provincia pr) {
		// TODO Auto-generated method stub
		prDao.insert(pr);
	}

	@Override
	public List<Provincia> list() {
		// TODO Auto-generated method stub
		return prDao.list();
	}

	@Override
	public void delete(int idPronvincia) {
		// TODO Auto-generated method stub
		prDao.delete(idPronvincia);
	}

	@Override
	public void update(Provincia pr) {
		// TODO Auto-generated method stub
		prDao.update(pr);
	}

	@Override
	public List<Provincia> findByName(Provincia pr) {
		// TODO Auto-generated method stub
		return prDao.findByName(pr);
	}

	
	
	
}
