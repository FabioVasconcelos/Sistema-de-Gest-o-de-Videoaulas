package Modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
@Table(name="endereco")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idEndereco;

	@Column(length=30)
	private String cep;

	@Column(nullable=false, length=45)
	private String cidade;

	@Column(length=45)
	private String complemento;

	@Column(nullable=false, length=45)
	private String logradouro;

	@Column(nullable=false)
	private int numero;

	@Column(length=2)
	private String uf;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="endereco")
	private List<Cliente> clientes;

	public Endereco() {
	}

	public int getIdEndereco() {
		return this.idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}