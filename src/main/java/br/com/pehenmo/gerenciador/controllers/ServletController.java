package br.com.pehenmo.gerenciador.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServletController {
	
	void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
