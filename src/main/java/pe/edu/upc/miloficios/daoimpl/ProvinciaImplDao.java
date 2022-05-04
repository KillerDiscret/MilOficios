package pe.edu.upc.miloficios.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.miloficios.dao.IProvinciaDao;
import pe.edu.upc.miloficios.entidades.Provincia;

public class ProvinciaImplDao implements IProvinciaDao {

	@PersistenceContext(unitName = "MilOficios")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Provincia p) {

		try {
			em.persist(p);
		} catch (Exception e) {
			System.out.println("Error al insertar provincia en el dao");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provincia> list() {
		List<Provincia> listaProvincias = new ArrayList<Provincia>();
		try {
			Query jpql = em.createQuery("from Provincia p");
			listaProvincias = (List<Provincia>)jpql.getResultList();
			
		} catch (Exception e) {
			System.out.println("Error al listar provincia en el Dao");
		}
		
		return listaProvincias;
	}

	@Transactional
	@Override
	public void delete(int idProvincia) {

		try {
			Provincia pr = em.find(Provincia.class, idProvincia);
			em.remove(pr);
			
		} catch (Exception e) {
			System.out.println("Error al eliminar provincia en el dao");
		}
		
	}

	@Transactional
	@Override
	public void update(Provincia p) {

		try {
			em.merge(p);
		} catch (Exception e) {
			System.out.println("Error al modificar provincia en el DAO");
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provincia> findByName(Provincia p) {
		
		List<Provincia> listaBuscada = new ArrayList<Provincia>();
		
		try {
			Query q = em.createQuery("from Provincia p where p.name like ?1");
			q.setParameter(1, "%" + p.getName() + "%");
			listaBuscada = (List<Provincia>)q.getResultList();
		
		} catch (Exception e) {

			System.out.println("Error al buscar Provincia");
		}
		
		return listaBuscada;
	}

}
