package Model;

public class Clientes {
	private int cliente_id;
	private String nome;
	private String cpf;
	private String telefone;
	private String endereco_cobranca;
	
// Construtores
	
public Clientes () {
		
}
	
public Clientes (int cliente_id, String nome, String cpf, String telefone, String endereco_cobranca, Boolean status) {
	this.cliente_id = cliente_id;
	this.nome = nome;
	this.cpf = cpf;
	this.telefone = telefone;
	this.endereco_cobranca = endereco_cobranca;
}

// Métodos getters e setters

public int getClient_id () {
	return cliente_id;
}

public int getCliente_id() {
	return cliente_id;
}

public void setCliente_id(int cliente_id) {
	this.cliente_id = cliente_id;
}

public String getNome () {
	return nome;
}

public void setNome (String nome) {
	this.nome = nome;
}

public String getCpf () {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public String getTelefone () {
	return telefone;
}

public void setTelefone (String telefone) {
	this.telefone = telefone;
}

public String getEndereco_cobranca() {
	return endereco_cobranca;
}

public void setEndereco_cobranca(String endereco_cobranca) {
	this.endereco_cobranca = endereco_cobranca;
}

}
