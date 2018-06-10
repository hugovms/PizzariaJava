package br.com.pizzaria.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.pizzaria.dao.UsuarioDao;
import br.com.pizzaria.models.Usuario;

@Named
@RequestScoped
public class UsuarioCadastroBean {
	private Usuario usuario = new Usuario();
	@Inject
	private UsuarioDao dao;
	@Transactional
	public void cadastrar() {
		if(usuario.getId() == null) {
			dao.cadastrar(usuario);
			System.out.println("Usuario cadastrado" + usuario);
		}else {
			System.out.println("chegou aqui");
			dao.editar(usuario);
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDao getDao() {
		return dao;
	}

	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}

	@Transactional
	public void remover(Usuario usuario) {
		System.out.println("Excluindo usuario "+ usuario.getNome());
		dao.deletar(usuario);
	}
	@Transactional
	public void editar(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
