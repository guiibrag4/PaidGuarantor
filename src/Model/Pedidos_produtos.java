package Model;

public class Pedidos_produtos {
	private int pedido_id;
	private int produto_id;
	private int quantidade;
	
// Construtores

public Pedidos_produtos () {
	
}

public Pedidos_produtos (int pedido_id, int produto_id, int quantidade) {
	this.pedido_id = pedido_id;
	this.produto_id = produto_id;
	this.quantidade = quantidade;
}

public int getPedido_id () {
	return pedido_id;
}

<<<<<<< HEAD
public void setPedido_id (int pedido_id) {
	this.pedido_id = pedido_id;
}

=======
>>>>>>> feed0cbab4b2cc04ef265814c049eea8b9e84de2
public int getProduto_id () {
	return produto_id;
}

<<<<<<< HEAD
public void setProduto_id (int produto_id) {
	this.produto_id = produto_id;;
}

=======
>>>>>>> feed0cbab4b2cc04ef265814c049eea8b9e84de2
public int getQuantidade () {
	return quantidade;
}

public void setQuantidade (int quantidade) {
	this.quantidade = quantidade;
}

}