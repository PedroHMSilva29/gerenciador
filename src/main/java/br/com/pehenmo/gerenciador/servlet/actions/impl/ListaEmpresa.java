package br.com.pehenmo.gerenciador.servlet.actions.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pehenmo.gerenciador.entities.Empresa;
import br.com.pehenmo.gerenciador.entities.ResponseServlet;
import br.com.pehenmo.gerenciador.repositories.Repository;
import br.com.pehenmo.gerenciador.servlet.actions.IAction;
import br.com.pehenmo.gerenciador.utils.Constants;

public class ListaEmpresa implements IAction {

	@Override
	public ResponseServlet run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Repository rep = new Repository();
		List<Empresa> empresas = rep.getEmpresas();
		
		request.setAttribute("empresas", empresas);
		request.setAttribute("empresa", (String) request.getParameter("empresa"));
		
		return new ResponseServlet("lista-empresa.jsp", Constants.METHOD_RESPONSE_FORWARD);

	}
	
}
