package br.com.pehenmo.gerenciador.servlet.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.pehenmo.gerenciador.entities.Empresa;
import br.com.pehenmo.gerenciador.repositories.Repository;
import br.com.pehenmo.gerenciador.utils.Constants;

/**
 * Servlet implementation class EmpresaService
 */
@WebServlet(name = "empresa", urlPatterns = { "/empresa" })
public class EmpresaService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Repository rep = new Repository();
		List<Empresa> empresas = rep.getEmpresas();
		
		String valor = request.getHeader("accept");
		System.out.println(valor);
		
		if(valor.contains(Constants.XML_CONTENT_TYPE)) {

			XStream xstream = new XStream();
			String xml = xstream.toXML(empresas);
			response.setContentType(Constants.XML_CONTENT_TYPE);
			response.getWriter().print(xml);

		} else if(valor.contains(Constants.JSON_CONTENT_TYPE)) {
			Gson gson = new Gson();
			String json = gson.toJson(empresas);
			
			response.setContentType(Constants.JSON_CONTENT_TYPE);
			response.getWriter().print(json);

		}else {
			response.setContentType(Constants.JSON_CONTENT_TYPE);
			response.getWriter().print("{'message':'no content'}");
		
		}
	}

}
