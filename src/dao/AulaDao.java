package dao;

import java.util.List;

import Modelo.Aula;



public interface AulaDao {
	public void salvar(Aula x);
	public void atualizar(Aula x);
	public void deletar(Aula x);
	public Aula buscaPorCodigo(int x);
	public List<Aula> buscaTodos();
	public List<Aula> buscaTodosPorCurso(int x);
}
