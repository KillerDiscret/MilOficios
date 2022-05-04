package pe.edu.upc.miloficios.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.miloficios.dao.ITipoNotificacionDao;
import pe.edu.upc.miloficios.entidades.TipoNotificacion;
import pe.edu.upc.miloficios.service.ITipoNotificacionService;

@Named
public class TipoNotificacionServiceImpl implements ITipoNotificacionService {

	@Inject
	private ITipoNotificacionDao dDao;

	@Override
	public List<TipoNotificacion> list() {
		// TODO Auto-generated method stub
		return dDao.list();
	}

	@Override
	public void insert(TipoNotificacion tn) {
		// TODO Auto-generated method stub
		dDao.insert(tn);
	}

	@Override
	public void delete(int idTipoNotificacion) {
		// TODO Auto-generated method stub
		dDao.delete(idTipoNotificacion);
	}

	@Override
	public void modificar(TipoNotificacion tn) {
		// TODO Auto-generated method stub
		dDao.modificar(tn);
	}

	@Override
	public List<TipoNotificacion> findByName(TipoNotificacion tn) {
		// TODO Auto-generated method stub
		return dDao.findByName(tn);
	}
}
