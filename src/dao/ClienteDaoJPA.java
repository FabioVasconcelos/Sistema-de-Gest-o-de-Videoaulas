package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Modelo.Cliente;

public class ClienteDaoJPA implements ClienteDao {

	private EntityManager em = null;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Cliente x) {
		em.persist(x);
	}

	public void atualizar(Cliente x) {
		x = em.merge(x);
	}

	public void deletar(Cliente x) {
		em.remove(x);
	}

	public Cliente buscaPorCodigo(int x) {
		return em.find(Cliente.class, x);
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> buscaTodos() {
		String s = "SELECT u FROM Vendedor u ";
		Query query = em.createQuery(s);
		return query.getResultList();
	}
}
