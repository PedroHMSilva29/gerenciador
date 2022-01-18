package br.com.pehenmo.gerenciador.servlet.actions.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.pehenmo.gerenciador.entities.ResponseServlet;
import br.com.pehenmo.gerenciador.servlet.actions.IAction;
import br.com.pehenmo.gerenciador.utils.Constants;

public class Logout implements IAction {

	@Override
	public ResponseServlet run(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		//sessao.removeAttribute("usr");
		sessao.invalidate();
		
		return new ResponseServlet("Login", Constants.METHOD_RESPONSE_REDIRECT);
	}

}
