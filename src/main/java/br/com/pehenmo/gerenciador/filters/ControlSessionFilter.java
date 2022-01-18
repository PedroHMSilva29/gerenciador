package br.com.pehenmo.gerenciador.filters;

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

import br.com.pehenmo.gerenciador.utils.Constants;

@WebFilter(urlPatterns = { "/controller" })
public class ControlSessionFilter implements Filter{
	
	@Override public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override public void destroy() {}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		var request = (HttpServletRequest) servletRequest;
		var response = (HttpServletResponse) servletResponse;
		
		String pAcao = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();
		boolean isLoggedUser = sessao.getAttribute("user") != null;
		boolean isProtectedPage = !(Constants.ACTION_LOGIN.equals(pAcao) || Constants.ACTION_VALIDA_LOGIN.equals(pAcao));
		
		if(!isLoggedUser && isProtectedPage) {
			response.sendRedirect(Constants.DEFAULT_URL_REDIRECT_SERVLET + Constants.ACTION_LOGIN);
			return;
		}
		
		chain.doFilter(request, response);
	}

}
