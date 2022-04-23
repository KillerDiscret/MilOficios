package pe.edu.upc.miloficios.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.miloficios.dao.IDepartamentoDao;
import pe.edu.upc.miloficios.entidades.Departamento;

public class DepartamentoImplDao implements IDepartamentoDao {

	@PersistenceContext(unitName = "MilOficios")
	private EntityManager em;
	
	
	@Transactional
	@Override
	public void insert(Departamento d) {
		try {
			em.persist(d);
		} catch (Exception e) {
			System.out.println("Error al insertar departamento");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> list() {
		
		List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
		
		try {
			Query jpql = em.createQuery("from Departamento d");
			listaDepartamentos = (List<Departamento>)jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar departamentos");
		}
	
		return listaDepartamentos;
	}

	@Transactional
	@Override
	public void delete(int idDepartamento) {
		
		try {
			Departamento de = em.find(Departamento.class, idDepartamento);
			em.remove(de);
		} catch (Exception e) {
			
			System.out.println("Error al eliminar en el dao");
		}
		
	}

}
