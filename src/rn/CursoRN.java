package rn;
import java.util.List;

import dao.CursoDao;
import dao.DaoFactory;

import Modelo.Curso;

public class CursoRN {

	private CursoDao dao;
	
	public CursoRN(){
		
		dao = DaoFactory.criarCursoDao();
	}
	
	public List<Curso> buscarTodos() {
		return dao.buscaTodos();
	}
	
	
	public Curso buscaCursoPorId(int x)
	{
		return dao.buscaPorCodigo(x);
	}
	
	public List<Curso> buscaTodosPorCategoria(int x) {
		return dao.buscaTodosPorCategoria(x);
	}
	
	public void inserirCurso(Curso x)
	{
		dao = DaoFactory.criarCursoDao();
		dao.salvar(x);
	}
	
	public void excluiCurso(Curso x)
	{
		dao.deletar(x);
	}
	
	
	public void atualizaCurso(Curso x)
	{
		dao.atualizar(x);
	}
	
	
	
}
