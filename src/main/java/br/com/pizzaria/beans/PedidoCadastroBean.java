package br.com.pizzaria.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.pizzaria.dao.PedidoDao;
import br.com.pizzaria.models.Pedido;

@Named
@RequestScoped
public class PedidoCadastroBean {
	
	private Pedido pedido = new Pedido();
	@Inject
	private PedidoDao dao;

	@Transactional
	public void cadastrarPedido() {
		if (pedido.getId() == null) {
			dao.cadastrar(pedido);
			System.out.println("pedido cadastrado" + pedido);
		} else {
			System.out.println("chegou aqui");
			dao.editar(pedido);
		}
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public PedidoDao getDao() {
		return dao;
	}

	public void setDao(PedidoDao dao) {
		this.dao = dao;
	}

	@Transactional
	public void remover(Pedido pedido) {
		System.out.println("Excluindo pedido ");
		dao.deletar(pedido);
	}

	@Transactional
	public void editar(Pedido pedido) {
		this.pedido = pedido;
	}

}
