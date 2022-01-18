package br.com.pehenmo.gerenciador.factories;

import javax.servlet.ServletException;

import br.com.pehenmo.gerenciador.servlet.actions.IAction;

public class ServletControllerFactory {
	
	public static IAction get(String acao) throws ServletException {
		
		String packageName = "br.com.pehenmo.gerenciador.servlet.actions.impl." + acao;
		IAction action = null;

			try {
				Class name = Class.forName(packageName);
				action = (IAction) name.getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				
				throw new ServletException(e);
			}
			
		return action;
	}

}
