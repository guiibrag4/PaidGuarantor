package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

<<<<<<< HEAD
import Model.Pedidos_produtos;
=======
import Model.Usuarios;
>>>>>>> feed0cbab4b2cc04ef265814c049eea8b9e84de2

public class Pedidos_produtosDAO {

	private Connection connection;

	public Pedidos_produtosDAO(Connection connection) {
		this.connection = connection;
	}

	public void conectar(Connection connection) throws SQLException {
		this.connection = connection;
	}

<<<<<<< HEAD
	public void inserirPedidos_produtos(Pedidos_produtos pp) throws SQLException {

		String sql = "INSERT INTO fiado_pago.pedidos_produtos (pedido_id, produto_id, quantidade) VALUES (?, ?, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, pp.getPedido_id());
		preparedStatement.setInt(2, pp.getProduto_id());
		preparedStatement.setInt(3, pp.getQuantidade());
		preparedStatement.executeUpdate();
	}

	public ResultSet listarPedidos_Produtos() throws SQLException {
		String sql = "SELECT * FROM fiado_pago.pedidos_produtos";
=======
	public void inserirUsuario(Usuarios user) throws SQLException {

		String sql = "INSERT INTO Usuarios (usuario_id, email, senha, emailrecup, telefone) VALUES (?, ?, ?, ?, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, user.getUsuario_id());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.setString(3, user.getSenha());
		preparedStatement.setString(4, user.getEmailRecup());
		preparedStatement.setString(5, user.getSenha());
		preparedStatement.executeUpdate();
	}

	public void atualizarUsuario(Usuarios user) throws SQLException {
		String sql = "UPDATE Usuarios SET senha = ?, emailrecup = ?, telefone = ? WHERE usuario_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getSenha());
		preparedStatement.setString(2, user.getEmailRecup());
		preparedStatement.setString(3, user.getTelefone());
		preparedStatement.setInt(4, user.getUsuario_id());
		preparedStatement.executeUpdate();
	}

	public void excluirUsuario(Usuarios user) throws SQLException {
		String sql = "DELETE FROM Usuarios WHERE usuario_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, user.getUsuario_id());
		preparedStatement.executeUpdate();
	}

	public ResultSet listarUsuarios() throws SQLException {
		String sql = "SELECT * FROM Usuarios";
>>>>>>> feed0cbab4b2cc04ef265814c049eea8b9e84de2
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		return preparedStatement.executeQuery();
	}

}
