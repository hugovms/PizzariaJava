package br.com.pizzaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.pizzaria.models.Usuario;


public class UsuarioDao {
	private EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("pizzaria-dev");
	
	@PersistenceContext
	private EntityManager manager = factory.createEntityManager();
	
	
	public List<Usuario> listar() {
		return manager.createNamedQuery("Usuario.tudo", Usuario.class).getResultList();
	}
	
	public Usuario getUsuario(String nome, String senha) {
		try {
			Usuario usuario = (Usuario) manager
			.createQuery("select u from Usuario u where u.nome=:name and u.senha=:senha", Usuario.class)
			.setParameter("name", nome)
			.setParameter("senha", senha)
			.getSingleResult();
			return usuario;
		} catch (NoResultException e) {
			return null;
		}
	}
	public void cadastrar(Usuario usuario) {
		manager.persist(usuario);
	}

	@Transactional
	public void deletar(Usuario usuario) {
		manager.remove(manager.getReference(Usuario.class, usuario.getId()));
	}
	
	@Transactional
	public void editar(Usuario usuario) {
	manager.merge(usuario);
	manager.flush();
	}
	
	 
	
	
}
