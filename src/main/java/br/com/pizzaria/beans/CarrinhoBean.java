package br.com.pizzaria.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.pizzaria.dao.ProdutoDao;
import br.com.pizzaria.models.Produto;
import br.com.pizzaria.util.FacesUtil;


@ManagedBean
@ApplicationScoped
public class CarrinhoBean {
		@Inject
		private ProdutoDao dao;
		private Produto prod = new Produto();
		private List<Produto> listaProdutos = new ArrayList<Produto>();
		
		public void addProduto() {
			listaProdutos.add(prod);
			this.prod = new Produto();
			FacesUtil.addInfoMessage("Adicionado ao carrinho!");
		}

		public Produto getProd() {
			return prod;
		}
		public void setProd(Produto prod) {
			this.prod = prod;
		}
		public List<Produto> getListaProdutos() {
			this.listaProdutos = dao.listar();
			return listaProdutos;
		}
		public void setListaProdutos(List<Produto> listaProdutos) {
			this.listaProdutos = listaProdutos;
		}
		
		
	}
