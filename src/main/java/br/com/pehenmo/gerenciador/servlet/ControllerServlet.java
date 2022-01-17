package br.com.pehenmo.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pehenmo.gerenciador.controllers.ServletController;
import br.com.pehenmo.gerenciador.decorators.ServletControllerDecorator;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet(name = "controller", urlPatterns = { "/controller" })
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pAcao = request.getParameter("acao");
		
		ServletController controller = ServletControllerDecorator.get(pAcao);
		controller.run(request, response);
	}

}
