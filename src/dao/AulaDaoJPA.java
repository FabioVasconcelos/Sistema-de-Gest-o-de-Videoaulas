package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.Aula;


public class AulaDaoJPA implements AulaDao {

	private EntityManager em = null;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	public void salvar(Aula x) {
		em.persist(x);

	}


	public void atualizar(Aula x) {
		x = em.merge(x);

	}


	public void deletar(Aula x) {
		em.remove(x);

	}


	public Aula buscaPorCodigo(int x) {
		return em.find(Aula.class, x);
	}
	

	
	@SuppressWarnings("unchecked")
	public List<Aula> buscaTodos() {
		String s = "SELECT u FROM Aula u ";
		Query query = em.createQuery(s);
		return query.getResultList();
	}

	
	@SuppressWarnings("unchecked")
	public List<Aula> buscaTodosPorCurso(int x) {
		String s = "SELECT u FROM Aula u where u.curso.idCurso = :arg1";
		Query query = em.createQuery(s);
		query.setParameter("arg1", x);
		return query.getResultList();
	}
	

 
}
