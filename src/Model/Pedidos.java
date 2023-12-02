package Model;

public class Pedidos {
	private int pedido_id;
	private int cliente_id;
	private String data_pedido;
	private double valor_total;

// Construtores

	public Pedidos() {

	}

	public Pedidos(int pedido_id, int cliente_id, String data_pedido, double valor_total) {
		this.pedido_id = pedido_id;
		this.cliente_id = cliente_id;
		this.data_pedido = data_pedido;
		this.valor_total = valor_total;
	}

// Métodos getters e setters

	public int getPedido_id() {
		return pedido_id;
	}

	public int getCliente_id() {
		return cliente_id;
	}
	
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public String getData_pedido() {
		return data_pedido;
	}
	
	public void setData_pedido(String data_pedido) {
		this.data_pedido = data_pedido;
	}

	public double getValor_total() {
		return valor_total;
	}

	/*
	 * public double setValor_total (double valor_total) { this.valor_total =
	 * valor_total; }
	 */

// Métodos diferentes de getters e setters 

// Precisa mesmo desse método? O pedido já não está sendo criado no segundo construtos? */ 
	/*
	 * public void criarPedido (int pedido_id, int cliente_id, String data_pedido,
	 * double valor_total) { this.pedido_id = pedido_id. this.cliente_id =
	 * cliente_id; this }
	 * 
	 * public int listarProdutoPedido (int pedido_id) { // algo como
	 * pedido_id.toString() aqui dentro, creio; }
	 */

}
