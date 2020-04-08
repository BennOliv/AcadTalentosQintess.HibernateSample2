package com.qintess.desafio0604.model;

import java.time.LocalDate;
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
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private long codigo;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "senha", length = 120, nullable = false)
	private String senha;
	
	@Column(name = "ativo",nullable = false)
	private short ativo;
	
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "usuario_grupo",
				joinColumns = @JoinColumn(name = "codigo_usuario"),
				inverseJoinColumns = @JoinColumn(name = "codigo_grupo"))
	private List<Grupo> grupos;
	
	public void addGrupo(Grupo grupo) {
		if(grupos == null){
			grupos = new ArrayList<>();
		}
		grupos.add(grupo);
	}

	public Usuario() {
	}

	public Usuario(String nome, String email, String senha, short ativo) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.ativo = ativo;
	}
	
	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", ativo="
				+ ativo + ", dataNascimento=" + dataNascimento + "]";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public short getAtivo() {
		return ativo;
	}

	public void setAtivo(short ativo) {
		this.ativo = ativo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
}