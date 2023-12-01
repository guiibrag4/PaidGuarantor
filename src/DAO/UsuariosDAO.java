package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Usuarios;

public class UsuariosDAO {

	private Connection connection;

	public UsuariosDAO(Connection connection) {
		this.connection = connection;
	}

	public void conectar(Connection connection) throws SQLException {
		this.connection = connection;
	}

	public void inserirUsuario(Usuarios user) throws SQLException {

		String sql = "INSERT INTO fiado_pago.usuarios (email, senha, nome, telefone) VALUES (?, ?, ?, ?)";

		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getSenha());
		ps.setString(3, user.getNome());
		ps.setString(4, user.getTelefone());
		ps.execute();
	}

	public ResultSet listarUsuarios() throws SQLException {
		String sql = "SELECT * FROM fiado_pago.usuarios";
		PreparedStatement ps = connection.prepareStatement(sql);
		return ps.executeQuery();
	}

	public boolean validarLogin(String email, String senha) {
		try {
			String sql = "SELECT * FROM fiado_pago.usuarios WHERE email = ? AND senha = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void atualizarUsuario(Usuarios user) throws SQLException { 
		 String sql = "UPDATE fiado_pago.usuarios SET nome = ?, email = ?, senha = ?, telefone = ? WHERE usuario_id = ?"; 
		 PreparedStatement ps = connection.prepareStatement(sql);
		 ps.setString(1,user.getNome()); 
		 ps.setString(2, user.getEmail()); 
		 ps.setString(3, user.getSenha());
		 ps.setString(4, user.getTelefone());
		 ps.setInt(5, user.getUsuario_id());
		 ps.executeUpdate();
	}

	public void excluirUsuario(Usuarios user) throws SQLException {
		String sql = "DELETE FROM fiado_pago.usuarios WHERE usuario_id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, user.getUsuario_id());
		ps.executeUpdate();
	}

}
