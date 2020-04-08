package com.qintess.desafio0604.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private long codigo;
	
	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "sigla", nullable = false)
	private String sigla;

	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidades;
	
	@SuppressWarnings("deprecation") // deprecation feito de propósito
	public void addCidade(Cidade cidade) {
		if(cidades == null) {
			cidades = new ArrayList<>();
		}
		cidades.add(cidade);
		cidade.setEstado(this);
	}

	public Estado() {
	}

	public Estado(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}

	@Override
	public String toString() {
		return "Estado [codigo=" + codigo + ", nome=" + nome + ", sigla=" + sigla + "]";
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
}