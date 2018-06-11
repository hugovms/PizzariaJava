package br.com.pizzaria.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.pizzaria.dao.UsuarioDao;
import br.com.pizzaria.models.Usuario;
import br.com.pizzaria.util.SessionUtil;

@RequestScoped
@ManagedBean
public class LoginBean {

	private UsuarioDao usuarioDao = new UsuarioDao();
	private Usuario usuario = new Usuario();
	
	public String envia() {
		usuario = usuarioDao.getUsuario(usuario.getNome(), usuario.getSenha());
		if(usuario == null) {
			usuario = new Usuario();
            FacesContext.getCurrentInstance().addMessage(
                       null,
                       new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                                   "Erro no Login!"));
            return null;
		}else {
			Object b = new Object();
			SessionUtil.setParam("USUARIOLogado", b);
			return "produto.xhtml?faces-redirect=true";
		}
	}
		
	public UsuarioDao getUsuarioDao() {
			return usuarioDao;
		}

		public void setUsuarioDao(UsuarioDao usuarioDao) {
			this.usuarioDao = usuarioDao;
		}


	public String logout() {
		FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);
        session.invalidate();
        return "login.xhtml?faces-redirect=true";
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
