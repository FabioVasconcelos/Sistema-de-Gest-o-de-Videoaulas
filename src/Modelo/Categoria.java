package Modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idCategoria;

	@Column(length=500)
	private String descricao;

	//bi-directional many-to-one association to Curso
	@OneToMany(mappedBy="categoria")
	private List<Curso> cursos;

	public Categoria() {
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

}