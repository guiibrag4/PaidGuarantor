package View;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.util.Locale;

import DAO.ProdutosDAO;
import Model.Produtos;
import Util.DB;

public class RUDProductsScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private ProdutosDAO produtosDAO;

	public RUDProductsScreen() {

		Locale.setDefault(Locale.US);
		voltar = new JButton();
		voltar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				voltarActionPerformed(evt);
			}
		});

		voltar.setText("Voltar");
		getContentPane().add(voltar);

		atualizar = new JButton("Atualizar");
		atualizar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				atualizarActionPerformed(evt);
			}
		});
		getContentPane().add(atualizar);

		excluir = new JButton("Excluir");
		excluir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				excluirActionPerformed(evt);
			}
		});
		getContentPane().add(excluir);

		voltar.setText("Voltar");
		getContentPane().add(voltar);

		Font novaFonte = new Font("MV Boli", Font.BOLD, 15);
		voltar.setBackground(Color.GREEN);
		voltar.setForeground(Color.BLACK);
		voltar.setFont(novaFonte);

		voltar.setBounds(3, 480, 150, 30);

		// Atualizar
		atualizar.setBackground(Color.GREEN);
		atualizar.setForeground(Color.BLACK);
		atualizar.setFont(novaFonte);

		atualizar.setBounds(330, 480, 150, 30);

		// Excluir
		excluir.setBackground(Color.RED);
		excluir.setForeground(Color.WHITE);
		excluir.setFont(novaFonte);

		excluir.setBounds(627, 480, 150, 30);

		produtosDAO = new ProdutosDAO(DB.getConnection());

		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);

		setTitle("Listagem de Produtos");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		carregarDados();
	}

	private void carregarDados() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Produto_id");
		model.addColumn("Nome");
		model.addColumn("Preço");

		try {
			ResultSet resultSet = produtosDAO.listarProdutos();

			while (resultSet.next()) {
				int produto_id = resultSet.getInt("produto_id");
				String nome = resultSet.getString("nome");
				double preco = resultSet.getDouble("preco");

				model.addRow(new Object[] { produto_id, nome, preco });
			}

			table.setModel(model);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void voltarActionPerformed(java.awt.event.ActionEvent evt) {
		new OptionsProductsScreen().setVisible(true);
		dispose();
	}

	private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {
		int linhaSelecionada = table.getSelectedRow();
		if (linhaSelecionada != -1) {
			editarProduto(linhaSelecionada);
			int produto_id = (int) table.getValueAt(linhaSelecionada, 0);
			String nome = (String) table.getValueAt(linhaSelecionada, 1);
			Double preco = (Double) table.getValueAt(linhaSelecionada, 2);

			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setValueAt(nome, linhaSelecionada, 1);
			model.setValueAt(preco, linhaSelecionada, 2);

			try {
				Produtos produtoSelecionado = new Produtos(produto_id, nome, preco);
				produtosDAO.atualizarProduto(produtoSelecionado);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void excluirActionPerformed(java.awt.event.ActionEvent evt) {
		int linhaSelecionada = table.getSelectedRow();
		if (linhaSelecionada != -1) {
			int produto_id = (int) table.getValueAt(linhaSelecionada, 0);
			String nome = (String) table.getValueAt(linhaSelecionada, 1);
			Double preco = (Double) table.getValueAt(linhaSelecionada, 2);

			Produtos produtoSelecionado = new Produtos(produto_id, nome, preco);

			int confirmacao = JOptionPane.showConfirmDialog(this,
					"Tem certeza que deseja excluir o produto selecionado?", "Confirmação de Exclusão",
					JOptionPane.YES_NO_OPTION);

			if (confirmacao == JOptionPane.YES_OPTION) {
				try {
					produtosDAO.excluirProduto(produtoSelecionado);
					carregarDados(); // Atualiza a tabela após a exclusão
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void editarProduto(int linhaSelecionada) {
		int produto_id = (int) table.getValueAt(linhaSelecionada, 0);
		String nome = (String) table.getValueAt(linhaSelecionada, 1);
		Double preco = (Double) table.getValueAt(linhaSelecionada, 2);

		String novoNome = JOptionPane.showInputDialog(this, "Nome:", nome);
		String novoPrecotxt = JOptionPane.showInputDialog(this, "Preço:", preco);
		Double novoPreco = Double.parseDouble(novoPrecotxt);

		if (novoNome != null && novoPreco != null) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setValueAt(novoNome, linhaSelecionada, 1);
			model.setValueAt(novoPreco, linhaSelecionada, 2);

			try {
				Produtos produtoSelecionado = new Produtos(produto_id, novoNome, novoPreco);
				produtosDAO.atualizarProduto(produtoSelecionado);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			RUDProductsScreen listagemProdutos = new RUDProductsScreen();
			listagemProdutos.setVisible(true);
		});
	}

	private JButton voltar;
	private JButton atualizar;
	private JButton excluir;
}
