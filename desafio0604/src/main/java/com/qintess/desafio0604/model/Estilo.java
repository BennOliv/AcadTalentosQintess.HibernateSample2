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
@Table(name="estilo")
public class Estilo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo")
	private long codigo;
	
	@Column(name="nome",nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "estilo")
	private List<Cerveja> cervejas;

	public Estilo() {
	}

	public Estilo(String nome) {
		this.nome = nome;
	}
	
	public void add(Cerveja cerveja) {
		if(cervejas == null) {
			cervejas = new ArrayList<>();
		}
		cervejas.add(cerveja);
		cerveja.setEstilo(this);
	}
	
	@Override
	public String toString() {
		return "Estilo [codigo=" + codigo + ", nome=" + nome + "]";
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
	
	public List<Cerveja> getCervejas() {
		return cervejas;
	}

	public void setCervejas(List<Cerveja> cervejas) {
		this.cervejas = cervejas;
	}
}