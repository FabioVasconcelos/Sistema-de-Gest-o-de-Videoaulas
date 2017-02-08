package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


import Modelo.Categoria;



public class CategoriaDaoJPA implements CategoriaDao {

	private EntityManager em = null;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Categoria x) {
		em.persist(x);
	}
	


	public void atualizar(Categoria x) {
		x = em.merge(x);

	}


	public void deletar(Categoria x) {
		em.remove(x);

	}

	
	public Categoria buscaPorCodigo(int x) {
		return em.find(Categoria.class, x);
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> buscaTodos() {
		String s = "SELECT u FROM Categoria u ";
		Query query = em.createQuery(s);
		return query.getResultList();
	}

}
