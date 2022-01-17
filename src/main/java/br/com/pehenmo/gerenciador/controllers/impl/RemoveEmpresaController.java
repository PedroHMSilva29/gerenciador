package br.com.pehenmo.gerenciador.controllers.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pehenmo.gerenciador.controllers.ServletController;
import br.com.pehenmo.gerenciador.entities.Empresa;
import br.com.pehenmo.gerenciador.repositories.Repository;

public class RemoveEmpresaController implements ServletController {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Repository rep = new Repository();
		List<Empresa> empresas = rep.getEmpresas();
		
		String pId = (String) request.getParameter("id");
		System.out.print("LOG SERVER: " +pId);
		Empresa empresaRemover = new Empresa();
		empresaRemover.setId(Integer.parseInt(pId));
		
		empresas.remove(empresaRemover);
		
		request.setAttribute("empresas", empresas);
		
		response.sendRedirect("listaEmpresa");
		
	}

}
