package br.com.pehenmo.gerenciador.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.pehenmo.gerenciador.entities.Empresa;
import br.com.pehenmo.gerenciador.entities.User;

public class Repository {

	private static List<Empresa> empresas = new ArrayList<>();
	private static List<User> users = new ArrayList<>();
	private static Integer count = 1;

	static {

		Repository rep = new Repository();
		
		rep.adiciona(new Empresa("Caelum", new Date()));
		rep.adiciona(new Empresa("Alura", new Date()));
		
		rep.adiciona(new User("pedro", "123"));

	}
	
	public boolean autentica(User user) {
		return Repository.users.contains(user);
	}

	public void adiciona(User user) {
		Repository.users.add(user);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(count++);
		Repository.empresas.add(empresa);
	}

	public Empresa findById(Integer id) {
		return empresas.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
	}

	public void alterById(Integer id, Empresa novaEmpresa) {
		Empresa empresa = empresas.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
		if (null != empresa) {
			empresa.setNome(novaEmpresa.getNome());
			empresa.setDataAbertura(novaEmpresa.getDataAbertura());
		}
	}

	public List<Empresa> getEmpresas() {
		return Repository.empresas;
	}

}
