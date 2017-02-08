package dao;

import javax.persistence.EntityManager;
import util.EMLocal;

public class DaoFactory {

	public static ClienteDao criarClienteDao() {
		ClienteDaoJPA aux = new ClienteDaoJPA();
		EntityManager em = EMLocal.getEntityManager();
		aux.setEm(em);
		return aux;
	}
	
	
	public static CategoriaDao criarCategoriaDao() {
		CategoriaDaoJPA aux = new CategoriaDaoJPA();
		EntityManager em = EMLocal.getEntityManager();
		aux.setEm(em);
		return aux;
	}
	
	public static CursoDao criarCursoDao() {
		CursoDaoJPA aux = new CursoDaoJPA();
		EntityManager em = EMLocal.getEntityManager();
		aux.setEm(em);
		return aux;
	}
	
	public static AulaDao criarAulaDao() {
		AulaDaoJPA aux = new AulaDaoJPA();
		EntityManager em = EMLocal.getEntityManager();
		aux.setEm(em);
		return aux;
	}
}
