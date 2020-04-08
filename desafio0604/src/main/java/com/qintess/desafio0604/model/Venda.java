package com.qintess.desafio0604.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private long codigo;
	
	@Column(name = "data_criacao", nullable = false)
	private LocalDateTime dataCriacao;
	
	@Column(name = "valor_frete", precision = 10, scale = 2)
	private double valorFrete;
	
	@Column(name = "valor_desconto", precision = 10, scale = 2)
	private double valorDesconto;
	
	@Column(name = "valor_total", precision = 10, scale = 2, nullable = false)
	private double valorTotal;
	
	@Column(name="status", length = 30, nullable = false)
	private String status;
	
	@Column(name = "observacao", length = 200)
	private String observavao;
	
	@Column(name = "data_hora_entrega")
	private LocalDateTime dataHoraEntrega;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="codigo_cliente", nullable = false)
	private Cliente cliente;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="codigo_usuario", nullable = false)
	private Usuario usuario;
	
	@OneToMany(mappedBy = "venda", orphanRemoval = true)
	private List<ItemVenda> itensVenda;

	@SuppressWarnings("deprecation")//deprecation feita de propósito
	public void addItemVenda(ItemVenda itemVenda) {
		if(itensVenda == null) {
			itensVenda = new ArrayList<>();
		}
		itensVenda.add(itemVenda);
		itemVenda.setVenda(this);
	}
	
	public Venda() {
	}
	
	//Bateu a preguiça de comentar bonitinho, e como eu só queria fixar bem na mente, então ja basta a minha outra anotação :)
	//Construtor com os NOT NULL, exceto o clietne e usuário.
	public Venda(LocalDateTime dataCriacao, double valorTotal, String status) {
		this.dataCriacao = dataCriacao;
		this.valorTotal = valorTotal;
		this.status = status;
	}
	
	//Construtor com todos os parametros, exceto o clietne e usuário.
	public Venda(LocalDateTime dataCriacao, double valorFrete, double valorDesconto, double valorTotal, String status,
			String observavao, LocalDateTime dataHoraEntrega) {
		this.dataCriacao = dataCriacao;
		this.valorFrete = valorFrete;
		this.valorDesconto = valorDesconto;
		this.valorTotal = valorTotal;
		this.status = status;
		this.observavao = observavao;
		this.dataHoraEntrega = dataHoraEntrega;
	}

	@Override
	public String toString() {
		return "Venda [codigo=" + codigo + ", dataCriacao=" + dataCriacao + ", valorFrete=" + valorFrete
				+ ", valorDesconto=" + valorDesconto + ", valorTotal=" + valorTotal + ", status=" + status
				+ ", observavao=" + observavao + ", dataHoraEntrega=" + dataHoraEntrega + ", cliente=" + cliente
				+ ", usuario=" + usuario + "]";
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObservavao() {
		return observavao;
	}

	public void setObservavao(String observavao) {
		this.observavao = observavao;
	}

	public LocalDateTime getDataHoraEntrega() {
		return dataHoraEntrega;
	}

	public void setDataHoraEntrega(LocalDateTime dataHoraEntrega) {
		this.dataHoraEntrega = dataHoraEntrega;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * @deprecated use {@link Usuario#addVenda(Venda)}
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * @deprecated {@link Cliente#addVenda(Venda)}
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}
}
