package pe.edu.upc.miloficios.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.miloficios.dao.ITipoNotificacionDao;
import pe.edu.upc.miloficios.entidades.TipoNotificacion;

public class TipoNotificacionImplDao implements ITipoNotificacionDao {

	@PersistenceContext(unitName = "MilOficios")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(TipoNotificacion tn) {
		// TODO Auto-generated method stub
		try {
			em.persist(tn);
		} catch (Exception e) {
			System.out.println("Error al insertar Tipo de Notificacion");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoNotificacion> list() {
		// TODO Auto-generated method stub
		List<TipoNotificacion> listaTipoNotificaciones = new ArrayList<TipoNotificacion>();
		
		try {
			Query jpql = em.createQuery("from TipoNotificacion tn");
			listaTipoNotificaciones = (List<TipoNotificacion>)jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar Tipo de Notificaciones");
		}
	
		return listaTipoNotificaciones;
	}

	@Transactional
	@Override
	public void delete(int idTipoNotificacion) {
		// TODO Auto-generated method stub
		try {
			TipoNotificacion tpn = em.find(TipoNotificacion.class, idTipoNotificacion);
			em.remove(tpn);
		} catch (Exception e) {
			
			System.out.println("Error al eliminar en el dao");
		}
	}
	
	@Transactional
	@Override
	public void update(TipoNotificacion no) {
		
		try {
			em.merge(no);
		} catch (Exception e) {
			System.out.println("Error al modificar Tipo de Notificaci�n en el DAO");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoNotificacion> findByName(TipoNotificacion no) {
		
		List<TipoNotificacion> listaBuscada = new ArrayList<TipoNotificacion>();
		
		try {
			Query q = em.createQuery("from TipoNotificacion tn where tn.nombreTipoNotificacion like ?1");
			q.setParameter(1, "%" + no.getNombreNotificacion() + "%");
			listaBuscada = (List<TipoNotificacion>)q.getResultList();
			
		} catch (Exception e) {
			
			System.out.println("Error al buscar notificaci�n");
		}
		
		return listaBuscada;
	}

	
	
}
