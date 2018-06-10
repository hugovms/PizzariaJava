package br.com.pizzaria.acesso;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(servletNames = { "Faces Servlet" })
public class ControleAcesso implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		if((session.getAttribute("USUARIOLogado") != null)
				|| (req.getRequestURI().endsWith("login.xhtml"))
				|| (req.getRequestURI().endsWith("index.xhtml"))
				|| (req.getRequestURI().endsWith("admin.xhtml"))
				|| (req.getRequestURI().endsWith("pedido.xhtml"))
				|| (req.getRequestURI().endsWith("finaliza.xhtml"))
				|| (req.getRequestURI().endsWith("javax.faces.resource/"))
				|| (req.getRequestURI().endsWith("cadastro.xhtml"))){
			chain.doFilter(request, response);
		}else {
			redireciona("/pizzaria/index.xhtml",response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {		
	}
	
	private void redireciona(String url, ServletResponse response)
			throws IOException {
		HttpServletResponse res = (HttpServletResponse) response;
		res.sendRedirect(url);
	}
	
	
	
}