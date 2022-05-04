package pe.edu.upc.miloficios.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.miloficios.dao.IEncuestaDao;
import pe.edu.upc.miloficios.entidades.Pregunta;
import pe.edu.upc.miloficios.entidades.Encuesta;

public class EncuestaImplDao implements IEncuestaDao {
	
	@PersistenceContext(unitName = "MilOficios")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Encuesta en) {
		try {
			em.persist(en);
		} catch (Exception e) {
			System.out.println("Error al insertar distrito");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Encuesta> list() {
		// TODO Auto-generated method stub
		List<Encuesta> listaDistritos = new ArrayList<Encuesta>();
		
		try {
			Query jpql = em.createQuery("from Encuesta en");
			listaDistritos = (List<Encuesta>)jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar distritos");
		}
	
		return listaDistritos;
	}
	
	@Transactional
	@Override
	public void delete(int idEncuesta) {
		// TODO Auto-generated method stub
		try {
			Encuesta enc = em.find(Encuesta.class, idEncuesta);
			em.remove(enc);
		} catch (Exception e) {
			
			System.out.println("Error al eliminar en el dao");
		}
	}

	@Override
	public void modificar(Encuesta en) {
		// TODO Auto-generated method stub
		try {
			em.merge(en);
		} catch (Exception e) {
			System.out.println("Error al modificar encuesta en el DAO");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Encuesta> findByName(Encuesta en) {
		// TODO Auto-generated method stub
		List<Encuesta> listaBuscada=new ArrayList<Encuesta>();
		try {
			Query q=em.createQuery("from Encuesta en where en.respuesta like ?1");
			q.setParameter(1,"%"+en.getRespuesta()+"%");
			listaBuscada=(List<Encuesta>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar encuesta");
		}
		return listaBuscada;
	}
}
