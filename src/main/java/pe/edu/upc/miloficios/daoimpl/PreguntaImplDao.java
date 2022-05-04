package pe.edu.upc.miloficios.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.miloficios.dao.IPreguntaDao;
import pe.edu.upc.miloficios.entidades.Pregunta;

public class PreguntaImplDao implements IPreguntaDao {

	@PersistenceContext(unitName = "MilOficios")
	private EntityManager em;
	
	
	@Transactional
	@Override
	public void insert(Pregunta p) {
		try {
			em.persist(p);
		} catch (Exception e) {
			System.out.println("Error al insertar departamento");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pregunta> list() {
		
		List<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
		
		try {
			Query jpql = em.createQuery("from Departamento d");
			listaPreguntas = (List<Pregunta>)jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar preguntas");
		}
	
		return listaPreguntas;
	}

	@Transactional
	@Override
	public void delete(int idPregunta) {
		
		try {
			Pregunta pr = em.find(Pregunta.class, idPregunta);
			em.remove(pr);
		} catch (Exception e) {
			
			System.out.println("Error al eliminar en el dao");
		}
		
	}

	@Transactional
	@Override
	public void update(Pregunta pr) {
		
		try {
			em.merge(pr);
		} catch (Exception e) {
			System.out.println("Error al modificar departamento en el DAO");
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pregunta> findByName(Pregunta pr) {
		
		List<Pregunta> listaBuscada = new ArrayList<Pregunta>();
		
		try {
			Query q = em.createQuery("from Pregunta p where p.Texto like ?1");
			q.setParameter(1, "%" + pr.getTexto() + "%");
			listaBuscada = (List<Pregunta>)q.getResultList();
			
		} catch (Exception e) {
			
			System.out.println("Error al buscar preguntas");
		}
		
		return listaBuscada;
	}

}