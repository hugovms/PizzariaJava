package br.com.pizzaria.beans;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import br.com.pizzaria.dao.ProdutoDao;
import br.com.pizzaria.models.Produto;

@Named
@RequestScoped
public class ProdutoCadastroBean {
	private Produto produto = new Produto();
	@Inject
	private ProdutoDao dao;
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoDao getDao() {
		return dao;
	}

	public void setDao(ProdutoDao dao) {
		this.dao = dao;
	}

	public Part getImagemProduto() {
		return imagemProduto;
	}

	public void setImagemProduto(Part imagemProduto) {
		this.imagemProduto = imagemProduto;
	}
	private Part imagemProduto;
	@Transactional
	public void cadastrar() throws IOException {
		if(produto.getId() == null) {
			dao.cadastrar(produto);
			
			imagemProduto.write("/home/hugo/workspace/pizzaria/imagens/" + imagemProduto.getSubmittedFileName());
			
			System.out.println("user cadastrado" + produto);
		}else {
			dao.editar(produto);
		}
	}

	@Transactional
	public void remover(Produto produto) {
		System.out.println("Excluindo produto "+ produto.getSabor());
		dao.deletar(produto);
	}
	@Transactional
	public void editar(Produto prod) {
		produto = prod;
	}
	
}
