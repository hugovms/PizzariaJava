package br.com.pizzaria.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.pizzaria.dao.PedidoDao;
import br.com.pizzaria.models.Pedido;

@Model
public class PedidoListaBean {
	
	
	public PedidoDao getDao() {
		return dao;
	}

	public void setDao(PedidoDao dao) {
		this.dao = dao;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Inject
	private PedidoDao dao;
	
	private List<Pedido> pedidos = new ArrayList<>();
	
	public List<Pedido> getPedidos(){
		this.pedidos = dao.listar();
		return pedidos;
	}
}
