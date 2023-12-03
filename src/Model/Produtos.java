package Model;

public class Produtos {
	private int produto_id;
	private String nome;
	private double preco;

// Construtores

	public Produtos() {

	}

	public Produtos(int produto_id, String nome, double preco) {
		this.produto_id = produto_id;
		this.nome = nome;
		this.preco = preco;
	}
	
	public Produtos (int produto_id) {
		this.produto_id = produto_id;
	}

// Métodos getters e setters

	public int getProduto_id() {
		return produto_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}