package rn;
import java.util.List;


import dao.AulaDao;
import dao.DaoFactory;

import Modelo.Aula;

public class AulaRN {

	private AulaDao dao;
	
	public AulaRN(){
		
		dao = DaoFactory.criarAulaDao();
	}
	
	public List<Aula> buscarTodos() {
		return dao.buscaTodos();
	}
	
	
	public Aula buscaAulaPorId(int x)
	{
		return dao.buscaPorCodigo(x);
	}
	
	public List<Aula> buscaTodosPorCurso(int x) {
		return dao.buscaTodosPorCurso(x);
	}
	
	public void inserirAulas(Aula x)
	{
		
		dao.salvar(x);
	}
	
	public void excluiAula(Aula x)
	{
		dao.deletar(x);
	}
	
	
	public void atualizaAula(Aula x)
	{
		dao.atualizar(x);
	}
	

	
}
