package dao;

import java.util.List;


import Modelo.Curso;

public interface CursoDao {

	public void salvar(Curso x);
	public void atualizar(Curso x);
	public void deletar(Curso x);
	public Curso buscaPorCodigo(int x);
	public List<Curso> buscaTodos();
	public List<Curso> buscaTodosPorCategoria(int x);
}
