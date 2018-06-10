package br.com.pizzaria.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.pizzaria.dao.ProdutoDao;
import br.com.pizzaria.models.Produto;

@Model
public class ProdutoListaBean {

	
	@Inject
	private ProdutoDao dao;
	
	private List<Produto> produtos = new ArrayList<>();
	
	public List<Produto> getProdutos(){
		this.produtos = dao.listar();
		
		return produtos;
	}
}
