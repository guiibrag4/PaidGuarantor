package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Pedidos_produtos;
import Model.Usuarios;

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

	public void inserirUsuario(Usuarios user) throws SQLException {

		String sql = "INSERT INTO Usuarios (usuario_id, email, senha, emailrecup, telefone) VALUES (?, ?, ?, ?, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, user.getUsuario_id());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.setString(3, user.getSenha());
		preparedStatement.setString(5, user.getTelefone());
		preparedStatement.executeUpdate();
	}

	public ResultSet listarUsuarios() throws SQLException {
		String sql = "SELECT * FROM fiado_pago.usuarios";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		return preparedStatement.executeQuery();
	}

}
