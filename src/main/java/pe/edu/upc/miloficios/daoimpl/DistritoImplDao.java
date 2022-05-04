package pe.edu.upc.miloficios.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.miloficios.dao.IDistritoDao;
import pe.edu.upc.miloficios.entidades.Departamento;
import pe.edu.upc.miloficios.entidades.Distrito;

public class DistritoImplDao implements IDistritoDao {
	
	@PersistenceContext(unitName = "MilOficios")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Distrito di) {
		try {
			em.persist(di);
		} catch (Exception e) {
			System.out.println("Error al insertar distrito");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Distrito> list() {
		// TODO Auto-generated method stub
		List<Distrito> listaDistritos = new ArrayList<Distrito>();
		
		try {
			Query jpql = em.createQuery("from Distrito di");
			listaDistritos = (List<Distrito>)jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar distritos");
		}
	
		return listaDistritos;
	}
	
	@Transactional
	@Override
	public void delete(int idDistrito) {
		// TODO Auto-generated method stub
		try {
			Distrito dis = em.find(Distrito.class, idDistrito);
			em.remove(dis);
		} catch (Exception e) {
			
			System.out.println("Error al eliminar en el dao");
		}
	}

	@Override
	public void modificar(Distrito di) {
		// TODO Auto-generated method stub
		try {
			em.merge(di);
		} catch (Exception e) {
			System.out.println("Error al modificar distrito en el DAO");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Distrito> findByName(Distrito di) {
		// TODO Auto-generated method stub
		List<Distrito> listaBDistritos=new ArrayList<Distrito>();
		try {
			Query q=em.createQuery("from Distrito di where di.NombreDistrito like ?1");
			q.setParameter(1,"%"+di.getNombreDistrito()+"%");
			listaBDistritos=(List<Distrito>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar distritos");
		}
		return listaBDistritos;
	}
}
