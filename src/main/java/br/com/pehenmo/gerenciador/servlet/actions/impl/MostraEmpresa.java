package br.com.pehenmo.gerenciador.servlet.actions.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pehenmo.gerenciador.entities.ResponseServlet;
import br.com.pehenmo.gerenciador.repositories.Repository;
import br.com.pehenmo.gerenciador.servlet.actions.IAction;
import br.com.pehenmo.gerenciador.utils.Constants;

public class MostraEmpresa implements IAction {

	@Override
	public ResponseServlet run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pId = request.getParameter("id");
		
		Repository rep = new Repository();
		var empresa = rep.findById(Integer.parseInt(pId));

		request.setAttribute("empresa", empresa);
		
		return new ResponseServlet("altera-empresa.jsp", Constants.METHOD_RESPONSE_FORWARD);
		
	}

}
