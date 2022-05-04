package pe.edu.upc.miloficios.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.miloficios.dao.IPreguntaDao;
import pe.edu.upc.miloficios.entidades.Pregunta;
import pe.edu.upc.miloficios.service.IPreguntaService;

@Named
public class PreguntaServiceImpl implements IPreguntaService {

	@Inject
	private IPreguntaDao pDao;

	@Override
	public void insert(Pregunta p) {
		pDao.insert(p);
	}

	@Override
	public List<Pregunta> list() {
		// TODO Auto-generated method stub
		return pDao.list();
	}

	@Override
	public void delete(int idPregunta) {
		// TODO Auto-generated method stub
		pDao.delete(idPregunta);		
	}

	@Override
	public void update(Pregunta de) {
		// TODO Auto-generated method stub
		pDao.update(de);
	}

	@Override
	public List<Pregunta> findByName(Pregunta pr) {
		// TODO Auto-generated method stub
		return pDao.findByName(pr);
	}
	
}