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
@Table(name = "grupo")
public class Grupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private long codigo;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "usuario_grupo",
				joinColumns = @JoinColumn(name = "codigo_grupo"),
				inverseJoinColumns = @JoinColumn(name = "codigo_usuario"))
	private List<Usuario> usuarios;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "grupo_permissao",
				joinColumns = @JoinColumn(name = "codigo_grupo"),
				inverseJoinColumns = @JoinColumn(name = "codigo_permissao"))
	private List<Permissao> permissoes;
	
	public void addUsuario(Usuario usuario) {
		if(usuarios == null) {
			usuarios = new ArrayList<>();
		}
		usuarios.add(usuario);
	}
	public void addPermissao(Permissao permissao) {
		if(permissoes == null) {
			permissoes = new ArrayList<>();
		}
		permissoes.add(permissao);
	}
	
	public Grupo() {
	}
	
	public Grupo(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Grupo [codigo=" + codigo + ", nome=" + nome + "]";
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
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public List<Permissao> getPermissoes() {
		return permissoes;
	}
	
	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
}
