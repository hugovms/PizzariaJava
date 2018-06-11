package br.com.pizzaria.models;

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;
@Entity
public class Produto {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String sabor;
	
	private String tipo;
	@Lob
	private String descricao;
	
	private Double preco;
	@Transient
	private int qtdCarrinho = 1;
	@Transient
	private static int count = 0;

	private String tamanho;
	
	private String imagemPath;
	
	public String getImagemPath() {
		return imagemPath;
	}

	public void setImagemPath(String imagemPath) {
		this.imagemPath = imagemPath;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public int getQtdCarrinho() {
		return qtdCarrinho;
	}

	public void setQtdCarrinho(int qtdCarrinho) {
		this.qtdCarrinho = qtdCarrinho;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Produto.count = count;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
