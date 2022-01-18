package br.com.pehenmo.gerenciador.servlet.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pehenmo.gerenciador.entities.ResponseServlet;
import br.com.pehenmo.gerenciador.factories.ServletControllerFactory;
import br.com.pehenmo.gerenciador.helpers.ResponseCallbackHelper;
import br.com.pehenmo.gerenciador.servlet.actions.IAction;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet(name = "controller", urlPatterns = { "/controller" })
public class MainControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pAcao = request.getParameter("acao");

		IAction action = ServletControllerFactory.get(pAcao);
		
		ResponseServlet responseServlet = action.run(request, response);
		
		ResponseCallbackHelper.call(responseServlet, request, response);
		
	}

}
