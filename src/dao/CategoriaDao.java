package dao;

import java.util.List;

import Modelo.Categoria;

public interface CategoriaDao {
	public void salvar(Categoria x);
	public void atualizar(Categoria x);
	public void deletar(Categoria x);
	public Categoria buscaPorCodigo(int x);
	public List<Categoria> buscaTodos();
}
