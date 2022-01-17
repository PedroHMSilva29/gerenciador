package br.com.pehenmo.gerenciador.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.pehenmo.gerenciador.entities.Empresa;

public class Repository {
	
	private static List<Empresa> empresas = new ArrayList<>();
	private static Integer count = 1;
	
	static {
		  Empresa empresa = new Empresa();
		  empresa.setNome("Alura");
		  empresa.setId(count++);
		  Empresa empresa2 = new Empresa();
		  empresa2.setNome("Caelum");
		  empresa2.setId(count++);
		  
		  Repository rep = new Repository();
		  rep.adiciona(empresa);
		  rep.adiciona(empresa2);
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
		if(null != empresa) {
			empresa.setNome(novaEmpresa.getNome());
			empresa.setDataAbertura(novaEmpresa.getDataAbertura());
		}
	}
	
	public List<Empresa> getEmpresas(){
		return Repository.empresas;
	}


}
