package pe.edu.upc.miloficios.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.miloficios.dao.IDistritoDao;
import pe.edu.upc.miloficios.entidades.Distrito;
import pe.edu.upc.miloficios.service.IDistritoService;

@Named
public class DistritoServiceImpl  implements IDistritoService {

	@Inject
	private IDistritoDao diDao;
	
	@Override
	public void insert(Distrito d) {
		// TODO Auto-generated method stub
		diDao.insert(d);
	}

	@Override
	public List<Distrito> list() {
		// TODO Auto-generated method stub
		return diDao.list();
	}

	@Override
	public void delete(int idDistrito) {
		// TODO Auto-generated method stub
		diDao.delete(idDistrito);
	}

	@Override
	public void modificar(Distrito di) {
		// TODO Auto-generated method stub
		diDao.modificar(di);
	}

	@Override
	public List<Distrito> findByName(Distrito di) {
		// TODO Auto-generated method stub
		return diDao.findByName(di);
	}

}
