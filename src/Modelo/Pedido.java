package Modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Table(name="pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idPedido;

	@Temporal(TemporalType.DATE)
	private Date dataPagamento;

	@Temporal(TemporalType.DATE)
	private Date dataPedido;

	//bi-directional many-to-one association to Itempedido
	@OneToMany(mappedBy="pedido")
	private List<Itempedido> itempedidos;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;

	public Pedido() {
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDataPagamento() {
		return this.dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataPedido() {
		return this.dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public List<Itempedido> getItempedidos() {
		return this.itempedidos;
	}

	public void setItempedidos(List<Itempedido> itempedidos) {
		this.itempedidos = itempedidos;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}