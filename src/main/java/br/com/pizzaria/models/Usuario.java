package br.com.pizzaria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name = "Usuario.nome", query = "select u from Usuario u where u.nome= :name"),
@NamedQuery(name = "Usuario.senha", query = "select u from Usuario u where u.senha=:senha"),
@NamedQuery(name = "Usuario.tudo", query = "select u from Usuario u")
})
public class Usuario {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="userName", nullable=false, unique=true)
	private String nome;
	@Column(name="email", unique = true)
	private String email;
	@Column(name="password", nullable=false, unique=false)
	private String senha;
	@Column(name="nomeCompleto", nullable=false)
	private String nomeCompleto;
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
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
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}
	
	
}
