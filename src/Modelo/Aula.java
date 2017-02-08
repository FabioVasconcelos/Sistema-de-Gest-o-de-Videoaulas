package Modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the aula database table.
 * 
 */
@Entity
@Table(name="aula")
public class Aula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false, length=20)
	private String idAula;

	@Column(length=60)
	private String descricao;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="idCurso")
	private Curso curso;

	public Aula() {
	}

	public String getIdAula() {
		return this.idAula;
	}

	public void setIdAula(String idAula) {
		this.idAula = idAula;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}