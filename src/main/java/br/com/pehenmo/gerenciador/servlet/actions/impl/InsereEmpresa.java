package br.com.pehenmo.gerenciador.servlet.actions.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pehenmo.gerenciador.entities.Empresa;
import br.com.pehenmo.gerenciador.entities.Parameters;
import br.com.pehenmo.gerenciador.entities.ResponseServlet;
import br.com.pehenmo.gerenciador.repositories.Repository;
import br.com.pehenmo.gerenciador.servlet.actions.IAction;
import br.com.pehenmo.gerenciador.utils.Constants;

public class InsereEmpresa implements IAction {

	@Override
	public ResponseServlet run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Empresa empresa = new Empresa();
		Repository rep = new Repository();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			String pNomeEmpresa = request.getParameter("nome");
			String pDataAbertura = request.getParameter("dataAbertura");
			
			Date dataAbertura = sdf.parse(pDataAbertura);
			empresa.setNome(pNomeEmpresa);
			empresa.setDataAbertura(dataAbertura);
			
			rep.adiciona(empresa);
			
		}catch(ParseException ex) {
			response.getWriter().println(ex.getMessage() + ":" + ex.getStackTrace());
		}
		List<Parameters> parameters = Arrays.asList(new Parameters("empresa", empresa.getNome()));
		return new ResponseServlet(Constants.ACTION_LISTA_EMPRESA, Constants.METHOD_RESPONSE_REDIRECT, parameters);

	}

}
