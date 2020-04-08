package com.qintess.desafio0604.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_venda")
public class ItemVenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private long codigo;
	
	@Column(name = "quantidade", nullable = false)
	private int quantidade;
	
	@Column(name = "valor_unitario", precision = 10, scale = 2, nullable = false)
	private double valorUnitario;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "codigo_cerveja", nullable = false)
	private Cerveja cerveja;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "codigo_venda", nullable = false)
	private Venda venda;

	public ItemVenda() {
	}

	public ItemVenda(int quantidade, double valorUnitario) {
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
	}

	@Override
	public String toString() {
		return "ItemVenda [codigo=" + codigo + ", quantidade=" + quantidade + ", valorUnitario=" + valorUnitario
				+ ", cerveja=" + cerveja + ", venda=" + venda + "]";
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Cerveja getCerveja() {
		return cerveja;
	}

	/**
	 * @deprecated setCerveja <b>obsoleto</b>, em vez dele, use {@link Cerveja#addItemVenda(ItemVenda)}
	 * @param cerveja
	 */
	public void setCerveja(Cerveja cerveja) {
		this.cerveja = cerveja;
	}

	public Venda getVenda() {
		return venda;
	}

	/**
	 * @deprecated setVenda <b>obsoleto</b>, em vez disso, use {@link Venda#addItemVenda(ItemVenda)}
	 * @param venda
	 */
	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
}
