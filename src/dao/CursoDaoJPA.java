package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import Modelo.Curso;



public class CursoDaoJPA implements CursoDao {

	private EntityManager em = null;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Curso x) {
		em.persist(x);

	}


	public void atualizar(Curso x) {
		x = em.merge(x);

	}


	public void deletar(Curso x) {
		em.remove(x);

	}

	
	public Curso buscaPorCodigo(int x) {
		return em.find(Curso.class, x);
	}

	@SuppressWarnings("unchecked")
	public List<Curso> buscaTodos() {
		String s = "SELECT u FROM Curso u ";
		Query query = em.createQuery(s);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Curso> buscaTodosPorCategoria(int x) {
		
		String s = "SELECT u FROM Curso u where u.categoria.idCategoria = :arg1";
		Query query = em.createQuery(s);
		query.setParameter("arg1", x);
		return query.getResultList();
	}

}
