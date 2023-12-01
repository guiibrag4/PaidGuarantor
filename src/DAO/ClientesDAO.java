package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Clientes;
import Model.Usuarios;

public class ClientesDAO {

	private Connection connection;

	public ClientesDAO(Connection connection) {
		this.connection = connection;
	}

	public void conectar(Connection connection) throws SQLException {
		this.connection = connection;
	}

	public void inserirCliente(Clientes customer) throws SQLException {

		String sql = "INSERT INTO fiado_pago.clientes (nome, cpf, telefone, endereco_cobranca) "
				+ "VALUES "
				+ "(?, ?, ?, ?)";

		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, customer.getNome());
		ps.setString(2, customer.getCpf() );
		ps.setString(3, customer.getTelefone());
		ps.setString(4, customer.getEndereco_cobranca());
		ps.execute();
	}

	public ResultSet listarClientes() throws SQLException {
		String sql = "SELECT * FROM fiado_pago.clientes";
		PreparedStatement ps = connection.prepareStatement(sql);
		return ps.executeQuery();
	}

	public void atualizarClientes(Clientes customer) throws SQLException { 
		 String sql = "UPDATE fiado_pago.clientes SET nome = ?, cpf = ?, telefone = ?,"
		 		+ "endereco_cobranca  = ? WHERE cliente_id = ?"; 
		 PreparedStatement ps = connection.prepareStatement(sql);
		 
		 ps.setString(1, customer.getNome()); 
		 ps.setString(2, customer.getCpf()); 
		 ps.setString(3, customer.getTelefone()); 
		 ps.setString(4, customer.getEndereco_cobranca()); 
		 ps.setInt(5, customer.getCliente_id()); 
		
		
		 ps.executeUpdate();
	}

	public void excluirUsuario(Clientes customer) throws SQLException {
		String sql = "DELETE FROM fiado_pago.clientes WHERE cliente_id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, customer.getCliente_id());
		ps.executeUpdate();
	}
}