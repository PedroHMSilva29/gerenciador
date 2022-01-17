package br.com.pehenmo.gerenciador.controllers.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pehenmo.gerenciador.controllers.ServletController;
import br.com.pehenmo.gerenciador.entities.Empresa;
import br.com.pehenmo.gerenciador.repositories.Repository;

public class ListaEmpresaController implements ServletController {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Repository rep = new Repository();
		List<Empresa> empresas = rep.getEmpresas();
		
		request.setAttribute("empresas", empresas);
		
		RequestDispatcher rd = request.getRequestDispatcher("/lista-empresa.jsp");
		rd.forward(request, response);
		
	}
	
}
