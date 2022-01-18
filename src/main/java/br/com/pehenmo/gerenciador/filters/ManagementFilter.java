package br.com.pehenmo.gerenciador.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class ManagementFilter
 */
@WebFilter("/controller")
public class ManagementFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;
	
	@Override public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Long start = System.currentTimeMillis();
		chain.doFilter(request, response);
		Long end = System.currentTimeMillis();
		
		String pAcao = request.getParameter("acao");
		System.out.println("Tempo de execução: "+ pAcao +"("+(end-start)+" mm)");
	}

}
