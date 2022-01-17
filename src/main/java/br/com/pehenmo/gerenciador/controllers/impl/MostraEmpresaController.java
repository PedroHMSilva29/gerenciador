package br.com.pehenmo.gerenciador.controllers.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pehenmo.gerenciador.controllers.ServletController;
import br.com.pehenmo.gerenciador.repositories.Repository;

public class MostraEmpresaController implements ServletController {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pId = request.getParameter("id");
		
		Repository rep = new Repository();
		var empresa = rep.findById(Integer.parseInt(pId));

		request.setAttribute("empresa", empresa);
		RequestDispatcher rd = request.getRequestDispatcher("/altera-empresa.jsp");
		rd.forward(request, response);
		
	}

}
