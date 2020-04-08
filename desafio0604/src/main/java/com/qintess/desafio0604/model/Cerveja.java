package com.qintess.desafio0604.model;

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
@Table(name="cerveja")
public class Cerveja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private long codigo;
	
	@Column(name="sku", length = 50, nullable = false)
	private String sku;
	
	@Column(name="nome", length = 80, nullable = false)
	private String nome;
	
	@Column(name="descricao", nullable = false)
	private String descricao;
	
	@Column(name="valor", precision = 10, scale = 2, nullable = false)
	private double valor;
	
	@Column(name="teor_alcoolico", precision = 10, scale = 2, nullable = false)
	private double teorAlcoolico;
	
	@Column(name="comissao", precision = 10, scale = 2, nullable = false)
	private double comissao;
	
	@Column(name = "sabor", length = 50, nullable = false)
	private String sabor;
	
	@Column(name="origem", length = 50, nullable = false)
	private String origem;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="codigo_estilo", nullable = false)
	private Estilo estilo;
	
	@Column(name = "quantidade_estoque")
	private int quantidadeEstoque;
	
	@Column(name = "foto")
	private String foto;
	
	@Column(name= "content_type", length = 100)
	private String contentType;
	
	@OneToMany(mappedBy = "cerveja")
	private List<ItemVenda> vendas;
	
	@SuppressWarnings("deprecation")//deprecation feita de propósito
	public void addItemVenda(ItemVenda itemVenda) {
		if(vendas == null) {
			vendas = new ArrayList<>();
		}
		vendas.add(itemVenda);
		itemVenda.setCerveja(this);
	}
	
	/**
	 * Construtor vazio.
	 * Construtor vazio, use com moderação.
	 * No BD, são NOT NULL os campos sku, nome, descricao, valor, teorAlcoolico, comissao, sabor, origem e estilo.
	 */
	public Cerveja() {
	}

	/**
	 * Contrutor com os campos NOT NULL.
	 * Construtor que recebe os campos NOT NULL nos parametros com excessao do estilo.
	 * @param sku
	 * @param nome
	 * @param descricao
	 * @param valor
	 * @param teorAlcoolico
	 * @param comissao
	 * @param sabor
	 * @param origem
	 */
	public Cerveja(String sku, String nome, String descricao, double valor, double teorAlcoolico, double comissao,
			String sabor, String origem) {
		this.sku = sku;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.teorAlcoolico = teorAlcoolico;
		this.comissao = comissao;
		this.sabor = sabor;
		this.origem = origem;
	}

	/**
	 * Construtor com todos os campos.
	 * Construtor que recebe os campos nos parametros com excessao do estilo.
	 * @param sku
	 * @param nome
	 * @param descricao
	 * @param valor
	 * @param teorAlcoolico
	 * @param comissao
	 * @param sabor
	 * @param origem
	 * @param quantidadeEstoque
	 * @param foto
	 * @param contentType
	 */
	public Cerveja(String sku, String nome, String descricao, double valor, double teorAlcoolico, double comissao,
			String sabor, String origem, int quantidadeEstoque, String foto, String contentType) {
		this.sku = sku;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.teorAlcoolico = teorAlcoolico;
		this.comissao = comissao;
		this.sabor = sabor;
		this.origem = origem;
		this.quantidadeEstoque = quantidadeEstoque;
		this.foto = foto;
		this.contentType = contentType;
	}

	
	@Override
	public String toString() {
		return "Cerveja [codigo=" + codigo + ", sku=" + sku + ", nome=" + nome + ", descricao=" + descricao + ", valor="
				+ valor + ", teorAlcoolico=" + teorAlcoolico + ", comissao=" + comissao + ", sabor=" + sabor
				+ ", origem=" + origem + ", estilo=" + estilo + ", quantidadeEstoque=" + quantidadeEstoque + ", foto="
				+ foto + ", contentType=" + contentType + "]";
	}
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(double teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public List<ItemVenda> getVendas() {
		return vendas;
	}

	public void setVendas(List<ItemVenda> vendas) {
		this.vendas = vendas;
	}	
}
