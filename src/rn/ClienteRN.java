package rn;

import java.util.List;

import dao.ClienteDao;
import dao.DaoFactory;

import Modelo.Cliente;

public class ClienteRN {
	
	private ClienteDao dao;
	
	public ClienteRN() {
		dao = DaoFactory.criarClienteDao();
	}
	
	public List<Cliente> buscarTodos() {
		return dao.buscaTodos();
	}
}
