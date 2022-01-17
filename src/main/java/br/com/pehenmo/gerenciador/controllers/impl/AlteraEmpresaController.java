package br.com.pehenmo.gerenciador.controllers.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pehenmo.gerenciador.controllers.ServletController;
import br.com.pehenmo.gerenciador.entities.Empresa;
import br.com.pehenmo.gerenciador.repositories.Repository;

public class AlteraEmpresaController implements ServletController {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Empresa empresa = new Empresa();
		Repository rep = new Repository();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			String pNomeEmpresa = request.getParameter("nome");
			String pDataAbertura = request.getParameter("dataAbertura");
			String pId = request.getParameter("id");

			Date dataAbertura = sdf.parse(pDataAbertura);
			empresa.setNome(pNomeEmpresa);
			empresa.setDataAbertura(dataAbertura);
			empresa.setId(Integer.parseInt(pId));
			
			rep.alterById(Integer.parseInt(pId), empresa);
			
		}catch(ParseException ex) {
			response.getWriter().println(ex.getMessage() + ":" + ex.getStackTrace());
		}
		
		response.sendRedirect("listaEmpresa");
		
	}

}
