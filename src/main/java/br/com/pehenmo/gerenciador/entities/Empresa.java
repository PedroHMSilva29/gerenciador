package br.com.pehenmo.gerenciador.entities;

import java.util.Date;

public class Empresa {

	private Integer id;
	private String nome;
	private Date dataAbertura = new Date();
	
	public Empresa() {}
	
	public Empresa(String nome, Date dataAbertura) {
		this.nome = nome;
		this.dataAbertura = dataAbertura;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		Empresa outra = (Empresa) obj;
		return this.getId().equals(outra.getId());
	}
	
}
