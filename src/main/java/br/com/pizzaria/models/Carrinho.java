package br.com.pizzaria.models;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class Carrinho {
	private ArrayList<Produto> produtos = new ArrayList<Produto>();

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public Produto getProduto(int id) {
		Produto mp = null;
		for(Produto p : produtos) {
			if(p.getId() == id) {
				return p;
			}
		}
		return mp;
	}
	
	public void adiciona(Produto p) {
			produtos.add(p);
		}
	
	public void adicionar(int id) {
		Produto p = getProduto(id);
			p.setQtdCarrinho(p.getQtdCarrinho()+1);
	}
	public void remover(int id) {
		Produto p = getProduto(id);
		if(p.getQtdCarrinho() > 1) {
			p.setQtdCarrinho(p.getQtdCarrinho()-1);
		}else {
			produtos.remove(p);
		}
	}
	 public void removerGeral(int id) {
		 Produto p = getProduto(id);
		 produtos.remove(p);
	 }
	 public double total() {
			double total = 0.;
			for(Produto produto : produtos) {
			total += produto.getPreco() * produto.getQtdCarrinho();
				}
			return total;
			}
}
