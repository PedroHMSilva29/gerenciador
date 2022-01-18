package br.com.pehenmo.gerenciador.servlet.actions.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.pehenmo.gerenciador.entities.ResponseServlet;
import br.com.pehenmo.gerenciador.entities.User;
import br.com.pehenmo.gerenciador.repositories.Repository;
import br.com.pehenmo.gerenciador.servlet.actions.IAction;
import br.com.pehenmo.gerenciador.utils.Constants;

public class ValidaLogin implements IAction {

	@Override
	public ResponseServlet run(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pLogin = (String) request.getParameter("login");
		String pSenha = (String) request.getParameter("senha");
		System.out.println(pLogin + ":" + pSenha);
		User user = new User(pLogin, pSenha);
		
		Repository rep = new Repository();
		
		if(rep.autentica(user)){
			HttpSession sessao = request.getSession();
			sessao.setAttribute("user", user);
			return new ResponseServlet(Constants.ACTION_LISTA_EMPRESA, Constants.METHOD_RESPONSE_REDIRECT);
		}
		
		return new ResponseServlet(Constants.ACTION_LOGIN, Constants.METHOD_RESPONSE_REDIRECT);

	}

}
