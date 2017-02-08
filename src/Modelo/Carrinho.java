package Modelo;

import java.util.ArrayList;
import java.util.List;



public class Carrinho {

	public List<Curso> getLista() {
		return lista;
	}


	public void setLista(List<Curso> lista) {
		this.lista = lista;
	}


	private List<Curso> lista = new ArrayList<Curso>();
	
	
	public Carrinho() {
		
	}
	
	public void excluir(int posicao) {
		
		this.getLista().remove(posicao);
	}
	
	public void inserir(Curso curso) {
		
		this.getLista().add(curso);
	}
		
	public List<Curso> buscarTodos(){
		
		return this.getLista();
		
	}
	
}
