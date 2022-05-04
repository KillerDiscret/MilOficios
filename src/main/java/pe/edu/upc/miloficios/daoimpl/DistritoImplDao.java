package pe.edu.upc.miloficios.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.miloficios.dao.IDistritoDao;
import pe.edu.upc.miloficios.entidades.Distrito;

public class DistritoImplDao implements IDistritoDao {
	@PersistenceContext(unitName = "MilOficios")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Distrito ds) {

		try {
			em.persist(ds);
		} catch (Exception e) {
			System.out.println("Error al insertar Distrito en el dao");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Distrito> list() {
		List<Distrito> listaDistritos = new ArrayList<Distrito>();
		try {
			Query jpql = em.createQuery("from Distrito ds");
			listaDistritos = (List<Distrito>)jpql.getResultList();
			
		} catch (Exception e) {
			System.out.println("Error al listar Distrito en el Dao");
		}
		
		return listaDistritos;
	}

	@Transactional
	@Override
	public void delete(int idDistrito) {

		try {
			Distrito dst = em.find(Distrito.class, idDistrito);
			em.remove(dst);
			
		} catch (Exception e) {
			System.out.println("Error al eliminar Distrito en el dao");
		}
	}

	@Transactional
	@Override
	public void update(Distrito ds) {

		try {
			em.merge(ds);
		} catch (Exception e) {
			System.out.println("Error al modificar distrito en el DAO");
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Distrito> findByName(Distrito ds) {
		
		List<Distrito> listaBuscada = new ArrayList<Distrito>();
		
		try {
			Query q = em.createQuery("from Distrito ds where ds.name like ?1");
			q.setParameter(1, "%" + ds.getName() + "%");
			listaBuscada = (List<Distrito>)q.getResultList();
		
		} catch (Exception e) {

			System.out.println("Error al buscar Distrito");
		}
		
		return listaBuscada;
	}
}
