package br.com.pehenmo.gerenciador.servlet.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pehenmo.gerenciador.entities.ResponseServlet;

public interface IAction {
	
	ResponseServlet run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
