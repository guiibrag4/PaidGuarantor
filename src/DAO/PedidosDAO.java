package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Model.Pedidos;


public class PedidosDAO {

	private Connection connection;

	public PedidosDAO(Connection connection) {
		this.connection = connection;
	}

	public void conectar(Connection connection) throws SQLException {
		this.connection = connection;
	}


	public void inserirPedido(Pedidos pedido) throws SQLException {
	
		String sql = "INSERT INTO fiado_pago.pedidos (cliente_id, data_pedido, valor_total) "
					+"VALUES (?, ?, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, pedido.getCliente_id());
		preparedStatement.setString(2, pedido.getData_pedido());
		preparedStatement.setDouble(3, pedido.getValor_total());
	}

	public ResultSet listarPedidos() throws SQLException {
		String sql = "SELECT * FROM fiado_pago.pedidos";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		return preparedStatement.executeQuery();
	}

}
