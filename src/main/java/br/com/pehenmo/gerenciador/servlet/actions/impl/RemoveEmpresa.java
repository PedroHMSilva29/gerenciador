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

public class RemoveEmpresa implements IAction {

	@Override
	public ResponseServlet run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Repository rep = new Repository();
		List<Empresa> empresas = rep.getEmpresas();
		
		String pId = (String) request.getParameter("id");
		
		Empresa empresaRemover = new Empresa();
		empresaRemover.setId(Integer.parseInt(pId));
		
		empresas.remove(empresaRemover);
		
		request.setAttribute("empresas", empresas);
		
		return new ResponseServlet(Constants.ACTION_LISTA_EMPRESA, Constants.METHOD_RESPONSE_REDIRECT);

	}

}
