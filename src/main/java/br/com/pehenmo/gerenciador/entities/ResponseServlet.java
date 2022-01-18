package br.com.pehenmo.gerenciador.entities;

import java.util.ArrayList;
import java.util.List;

public class ResponseServlet {
	
	private String uri;
	private String method;
	private List<Parameters> parameters = new ArrayList<>();
	
	public ResponseServlet(String uri, String method, List<Parameters> parameters) {
		this.uri = uri;
		this.method = method;
		this.parameters = parameters;
	}
	
	public ResponseServlet(String uri, String method) {
		this.uri = uri;
		this.method = method;
		this.parameters = new ArrayList<>();
	}
	
	public List<Parameters> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameters> parameters) {
		this.parameters = parameters;
	}

	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}

}
