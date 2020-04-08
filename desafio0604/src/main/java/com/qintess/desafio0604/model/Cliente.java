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
@Table(name="cliente")
public class Cliente {
	
	//instanciar variáveis
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private long codigo;
	
	@Column(name = "nome", length = 80, nullable = false)
	private String nome;
	
	@Column(name = "tipo_pessoa", length = 15, nullable = false)
	private String tipoPessoa;
	
	@Column(name = "cpf_cnpj", length = 30, nullable = false)
	private String cpfCnpj;
	
	@Column(name = "telefone", length = 20)
	private String telefone;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "logradouro", length = 50)
	private String logradouro;
	
	@Column(name = "numero", length = 15)
	private String numero;
	
	@Column(name = "complemento", length = 20)
	private String complemento;
	
	@Column(name = "cep", length = 15)
	private String cep;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "codigo_cidade")
	private Cidade cidade;
	
	@OneToMany(mappedBy = "cliente")
	private List<Venda> compras;
	
	//metodo add
	@SuppressWarnings("deprecation")
	public void addVenda(Venda venda) {
		if(compras == null) {
			compras = new ArrayList<>();
		}
		compras.add(venda);
		venda.setCliente(this);
	}

	//metodos construtores
	
	public Cliente() {
	}

	public Cliente(String nome, String tipoPessoa, String cpfCnpj, String email) {
		this.nome = nome;
		this.tipoPessoa = tipoPessoa;
		this.cpfCnpj = cpfCnpj;
		this.email = email;
	}

	public Cliente(String nome, String tipoPessoa, String cpfCnpj, String telefone, String email, String logradouro,
			String numero, String complemento, String cep) {
		this.nome = nome;
		this.tipoPessoa = tipoPessoa;
		this.cpfCnpj = cpfCnpj;
		this.telefone = telefone;
		this.email = email;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", tipoPessoa=" + tipoPessoa + ", cpfCnpj=" + cpfCnpj
				+ ", telefone=" + telefone + ", email=" + email + ", logradouro=" + logradouro + ", numero=" + numero
				+ ", complemento=" + complemento + ", cep=" + cep + ", cidade=" + cidade + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cidade getCidade() {
		return cidade;
	}
	
	public List<Venda> getCompras() {
		return compras;
	}

	public long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * @deprecated use {@link Cidade#addCliente(Cliente)}
	 * @param cidade
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public void setCompras(List<Venda> compras) {
		this.compras = compras;
	}
}
