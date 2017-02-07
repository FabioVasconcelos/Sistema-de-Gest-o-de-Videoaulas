package rn;
import java.util.List;

import Modelo.Categoria;
import dao.CategoriaDao;
import dao.DaoFactory;

public class CategoriaRN {

	private CategoriaDao dao;
	
	public CategoriaRN(){
		
		dao = DaoFactory.criarCategoriaDao();
				
	}
	
	
	public List<Categoria> buscarTodos()
	{
		return dao.buscaTodos();
	}
	
	public Categoria buscaPorCodigo(int x)
	{
		return dao.buscaPorCodigo(x);
		
	}
	
	
	
}
