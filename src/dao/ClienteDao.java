package dao;

import java.util.List;
import Modelo.Cliente;

public interface ClienteDao {
	public void salvar(Cliente x);
	public void atualizar(Cliente x);
	public void deletar(Cliente x);
	public Cliente buscaPorCodigo(int x);
	public List<Cliente> buscaTodos();
}
