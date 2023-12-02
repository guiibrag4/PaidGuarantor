package Model;

public class Pedidos_produtos {
	private int pedido_id;
	private int produto_id;
	private int quantidade;

// Construtores

	public Pedidos_produtos() {

	}

	public Pedidos_produtos(int pedido_id, int produto_id, int quantidade) {
		this.pedido_id = pedido_id;
		this.produto_id = produto_id;
		this.quantidade = quantidade;
	}

	public int getPedido_id() {
		return pedido_id;
	}

	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}

	public int getProduto_id() {
		return produto_id;
	}

	public void setProduto_id(int produto_id) {
		this.produto_id = produto_id;
		;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}