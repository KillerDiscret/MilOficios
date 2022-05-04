package pe.edu.upc.miloficios.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.miloficios.dao.IEncuestaDao;
import pe.edu.upc.miloficios.entidades.Encuesta;
import pe.edu.upc.miloficios.service.IEncuestaService;

@Named
public class EncuestaServiceImpl  implements IEncuestaService {

	@Inject
	private IEncuestaDao enDao;
	
	@Override
	public void insert(Encuesta e) {
		// TODO Auto-generated method stub
		enDao.insert(e);
	}

	@Override
	public List<Encuesta> list() {
		// TODO Auto-generated method stub
		return enDao.list();
	}

	@Override
	public void delete(int idEncuesta) {
		// TODO Auto-generated method stub
		enDao.delete(idEncuesta);
	}

	@Override
	public void modificar(Encuesta en) {
		// TODO Auto-generated method stub
		enDao.modificar(en);
	}

	@Override
	public List<Encuesta> findByName(Encuesta en) {
		// TODO Auto-generated method stub
		return enDao.findByName(en);
	}

}
