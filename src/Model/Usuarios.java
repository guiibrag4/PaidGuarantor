package Model;

public class Usuarios{
	private int usuario_id;
	private String email;
	private String senha;
	private String nome;
	private String telefone;
	
// Construtores
	
public Usuarios () {
	
}

public Usuarios (int usuario_id, String email, String senha, String nome, String telefone) {
	this.usuario_id = usuario_id;
	this.email = email;
	this.senha = senha;
	this.nome = nome;
	this.telefone = telefone;
}

// Métodos getters e setters

public int getUsuario_id () {
	return usuario_id;
}

public void setUsuario_id (int usuario_id) {
	this.usuario_id = usuario_id;
}

public String getEmail () {
	return email;
}

public void setEmail (String email) {
	this.email = email;
}

public String getNome () {
	return nome;
}

public void setNome (String nome) {
	this.nome = nome;
}

public String getSenha () {
	return senha;
}

public void setSenha (String senha) {
	this.senha = senha;
}

public String getTelefone () {
	return telefone;
}

public void setTelefone (String telefone) {
	this.telefone = telefone;
}



}