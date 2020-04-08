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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "permissao")
public class Permissao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private long codigo;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "grupo_permissao",
				joinColumns = @JoinColumn(name = "codigo_permissao"),
				inverseJoinColumns = @JoinColumn(name = "codigo_grupo"))
	private List<Grupo> grupos;

	public void addGrupo(Grupo grupo) {
		if(grupos == null) {
			grupos = new ArrayList<>();
		}
		grupos.add(grupo);
	}

	public Permissao() {
	}

	public Permissao(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Permissao [codigo=" + codigo + ", nome=" + nome + "]";
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

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
}
