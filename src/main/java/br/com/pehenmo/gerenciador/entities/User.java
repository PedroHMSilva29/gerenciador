package br.com.pehenmo.gerenciador.entities;

import java.util.Objects;

public class User {
	
	private String login;
	private String senha;
	
	public User(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(login, other.login) && Objects.equals(senha, other.senha);
	}

}
