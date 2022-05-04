package pe.edu.upc.miloficios.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.miloficios.dao.IDistritoDao;
import pe.edu.upc.miloficios.entidades.Distrito;
import pe.edu.upc.miloficios.service.IDistritoService;

@Named
public class DistritoServImpl implements IDistritoService {
	@Inject
	private IDistritoDao dstDao;
	
	@Override
	public void insert(Distrito dst) {
		// TODO Auto-generated method stub
		dstDao.insert(dst);
	}

	@Override
	public List<Distrito> list() {
		// TODO Auto-generated method stub
		return dstDao.list();
	}

	@Override
	public void delete(int idDistrito) {
		// TODO Auto-generated method stub
		dstDao.delete(idDistrito);
	}

	@Override
	public void update(Distrito dst) {
		// TODO Auto-generated method stub
		dstDao.update(dst);
	}

	@Override
	public List<Distrito> findByName(Distrito dst) {
		// TODO Auto-generated method stub
		return dstDao.findByName(dst);
	}
}
