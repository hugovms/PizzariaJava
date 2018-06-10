package br.com.pizzaria.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.pizzaria.dao.UsuarioDao;
import br.com.pizzaria.models.Usuario;

@Model
public class UsuarioListaBean {

	
	@Inject
	private UsuarioDao dao;
	
	private List<Usuario> usuarios = new ArrayList<>();
	
	public List<Usuario> getUsuarios(){
		this.usuarios = dao.listar();
		
		return usuarios;
	}
}
