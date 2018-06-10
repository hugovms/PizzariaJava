package br.com.pizzaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.pizzaria.models.Pedido;


public class PedidoDao {
	@PersistenceContext
	private EntityManager manager;
	public void cadastrar(Pedido pedido) {
		manager.persist(pedido);
	}
	public List<Pedido> listar() {
		String jpql = "select p from Pedido p";
		return manager.createQuery(jpql, Pedido.class).getResultList();
	}
	@Transactional
	public void deletar(Pedido pedido) {
		manager.remove(manager.getReference(Pedido.class, pedido.getId()));
	}
	@Transactional
	public void editar(Pedido pedido) {
	manager.merge(pedido);
	manager.flush();
	}
}
