package pe.edu.upc.miloficios.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.miloficios.dao.IProvinciaDao;
import pe.edu.upc.miloficios.entidades.Departamento;
import pe.edu.upc.miloficios.entidades.Provincia;

public class ProvinciaImplDao implements IProvinciaDao {
	
	@PersistenceContext(unitName = "MilOficios")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Provincia p) {
		// TODO Auto-generated method stub
		try {
			em.persist(p);
		} catch (Exception e) {
			System.out.println("Error al insertar provincia");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Provincia> list() {
		// TODO Auto-generated method stub
		List<Provincia> listaProvincias = new ArrayList<Provincia>();
		
		try {
			Query jpql = em.createQuery("from Provincia p");
			listaProvincias = (List<Provincia>)jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar provincias");
		}
	
		return listaProvincias;
	}
	
	@Transactional
	@Override
	public void delete(int idProvincia) {
		// TODO Auto-generated method stub
		try {
			Provincia pro = em.find(Provincia.class, idProvincia);
			em.remove(pro);
		} catch (Exception e) {
			
			System.out.println("Error al eliminar en el dao");
		}
	}

	@Override
	public void modificar(Provincia p) {
		// TODO Auto-generated method stub
		try {
			em.merge(p);
		} catch (Exception e) {
			System.out.println("Error al modificar provincia en el DAO");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provincia> findByName(Provincia p) {
		// TODO Auto-generated method stub
		List<Provincia> listaBProvincias=new ArrayList<Provincia>();
		try {
			Query q=em.createQuery("from Provinca p where p.NombreProvincia() like ?1");
			q.setParameter(1,"%"+p.getNombreProvincia()+"%");
			listaBProvincias=(List<Provincia>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar provincias");
		}
		return listaBProvincias;
	}
	
}
