package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Pedidos_produtos;

public class Pedidos_produtosDAO {

	private Connection connection;

	public Pedidos_produtosDAO(Connection connection) {
		this.connection = connection;
	}

	public void conectar(Connection connection) throws SQLException {
		this.connection = connection;
	}

	public void inserirPedidos_produtos(Pedidos_produtos pp) throws SQLException {

		String sql = "INSERT INTO fiado_pago.pedidos_produtos (pedido_id, produto_id, quantidade) VALUES (?, ?, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, pp.getPedido_id());
		preparedStatement.setInt(2, pp.getProduto_id());
		preparedStatement.setInt(3, pp.getQuantidade());
		preparedStatement.executeUpdate();
	}

	public ResultSet listarPedidos_produtos() throws SQLException {
		String sql = "SELECT * FROM fiado_pago.pedidos_produtos";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		return preparedStatement.executeQuery();
	}
	
	public ResultSet vendaRealizada() throws SQLException {
	    String query = "SELECT c.nome AS nome_cliente, p.pedido_id, pro.nome AS nome_produto, p.data_pedido, p.valor_total  FROM fiado_pago.pedidos p JOIN"
	    		+ " fiado_pago.clientes AS c ON c.cliente_id = p.cliente_id JOIN"
	    		+ " fiado_pago.pedidos_produtos AS pp ON pp.pedido_id = p.pedido_id JOIN"
	    		+ " fiado_pago.produtos AS pro ON pro.produto_id = pp.produto_id"
	    		+ " ORDER BY pedido_id ASC";
	    PreparedStatement preparedStatement = connection.prepareStatement(query);
	    return preparedStatement.executeQuery();
	}

}
