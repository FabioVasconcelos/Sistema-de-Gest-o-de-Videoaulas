package rn;

import java.util.List;


import Modelo.Carrinho;
import Modelo.Curso;

public class CarrinhoRN {


	private Carrinho carrinho;
	 
	public void excluir(int posicao, Carrinho carrinho) {
		this.carrinho = carrinho;
		carrinho.getLista().remove(posicao);
	}
	
	public void inserir(Curso curso, Carrinho carrinho) {
		this.carrinho = carrinho;
		
				carrinho.getLista().add(curso);
			
		}
		

		
	public List<Curso> buscarTodos(Carrinho carrinho){
		this.carrinho = carrinho;
		return carrinho.getLista();
		
	}
	
	public double totalPedido(Carrinho carrinho) {
		if (carrinho.getLista().isEmpty()) {
			return 0.0;
		}
		double soma = 0.0;
		for (Curso x : carrinho.getLista()) {
			soma = soma + x.getPreco();
		}
		return soma ;
	}
	
}
