package Modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the itempedido database table.
 * 
 */
@Entity
@Table(name="itempedido")
public class Itempedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idItemPedido;

	@Column(nullable=false)
	private double preco;

	@Column(nullable=false)
	private int quantidade;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="idCurso", nullable=false)
	private Curso curso;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="idPedido", nullable=false)
	private Pedido pedido;

	public Itempedido() {
	}

	public int getIdItemPedido() {
		return this.idItemPedido;
	}

	public void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}