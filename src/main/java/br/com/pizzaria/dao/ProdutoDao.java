package br.com.pizzaria.dao;

import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.pizzaria.models.Produto;
public class ProdutoDao {
	
	
	@PersistenceContext
	private EntityManager manager;
	public void cadastrar(Produto produto) {
		manager.persist(produto);
	}
	public List<Produto> listar() {
		String jpql = "select p from Produto p";
		return manager.createQuery(jpql, Produto.class).getResultList();
	}
	@Transactional
	public void deletar(Produto produto) {
		manager.remove(manager.getReference(Produto.class, produto.getId()));
	}
	@Transactional
	public void editar(Produto produto) {
	manager.merge(produto);
	manager.flush();
	}
}
