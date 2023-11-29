package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Produtos;

public class ProdutosDAO {

	private Connection connection;

	public ProdutosDAO(Connection connection) {
		this.connection = connection;
	}

	public void conectar(Connection connection) throws SQLException {
		this.connection = connection;
	}

	public void inserirProduto(Produtos product) throws SQLException {

		String sql = "INSERT INTO fiado_pago.produtos (nome, preco) VALUES (?, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, product.getNome());
		preparedStatement.setDouble(2, product.getPreco());
		preparedStatement.executeUpdate();
	}

	public ResultSet listarProdutos() throws SQLException {
		String sql = "SELECT * FROM fiado_pago.produtos";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		return preparedStatement.executeQuery();
	}

}
