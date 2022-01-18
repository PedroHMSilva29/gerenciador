package br.com.pehenmo.gerenciador.helpers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pehenmo.gerenciador.entities.ResponseServlet;
import br.com.pehenmo.gerenciador.utils.Constants;

public class ResponseCallbackHelper {
	
	public static void call(ResponseServlet callback, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		StringBuilder params = new StringBuilder();
		callback.getParameters().forEach(e -> params.append("&"+ e.getKey()+"="+e.getValue()));
		System.out.print(params.toString());
		switch(callback.getMethod()) {
		
			case Constants.METHOD_RESPONSE_REDIRECT -> {
				
				url = Constants.DEFAULT_URL_REDIRECT_SERVLET + callback.getUri() + params.toString();
				response.sendRedirect(url);
			}
			
			case Constants.METHOD_RESPONSE_FORWARD -> {
				url = Constants.DEFAULT_URL_FORWARD_JSP + callback.getUri();
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
			}
		
		default -> throw new IllegalArgumentException("Unexpected value: " + callback.getMethod());
		};
	
	}

}
