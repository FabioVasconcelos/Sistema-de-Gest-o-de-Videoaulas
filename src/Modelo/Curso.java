package Modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@Table(name="curso")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idCurso;

	@Column(length=500)
	private String descricao;

	private int duracao;

	@Column(length=500)
	private String imgUrl;

	@Column(length=500)
	private String nome;

	private double preco;

	//bi-directional many-to-one association to Aula
	@OneToMany(mappedBy="curso")
	private List<Aula> aulas;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="idCategoria")
	private Categoria categoria;

	//bi-directional many-to-one association to Itempedido
	@OneToMany(mappedBy="curso")
	private List<Itempedido> itempedidos;

	public Curso() {
	}

	public int getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getDuracao() {
		return this.duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Aula> getAulas() {
		return this.aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Itempedido> getItempedidos() {
		return this.itempedidos;
	}

	public void setItempedidos(List<Itempedido> itempedidos) {
		this.itempedidos = itempedidos;
	}

}