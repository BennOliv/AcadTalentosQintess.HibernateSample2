package com.qintess.desafio0604.model;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "cidade")
public class Cidade {
	//mapping
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private long codigo;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "codigo_estado", nullable = false)
	private Estado estado; 
	
	@OneToMany(mappedBy = "cidade")
	private List<Cliente> clientes;
	
	@SuppressWarnings("deprecation")//deprecation feito de propósito
	public void addCliente (Cliente cliente) {
		if(clientes == null) {
			clientes = new ArrayList<>();
		}
		clientes.add(cliente);
		cliente.setCidade(this);
	}
	//constructs

	public Cidade() {
	}
	
	public Cidade(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cidade [codigo=" + codigo + ", nome=" + nome + ", estado=" + estado + "]";
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	/**
	 * @deprecated use {@link Estado#addCidade(Cidade)}
	 * @param estado
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
