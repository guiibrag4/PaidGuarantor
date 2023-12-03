package View;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.Pedidos_produtosDAO;
import Util.DB;

public class ListingSalesScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private Pedidos_produtosDAO pedidos_produtosDAO;


	public ListingSalesScreen() {

		voltar = new JButton();
		voltar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				voltarActionPerformed(evt);
			}
		});

		voltar.setText("Voltar");
		getContentPane().add(voltar);

		Font novaFonte = new Font("MV Boli", Font.BOLD, 15);
		voltar.setBackground(Color.GREEN);
		voltar.setForeground(Color.BLACK);
		voltar.setFont(novaFonte);

		voltar.setBounds(3, 480, 150, 30);

		pedidos_produtosDAO = new Pedidos_produtosDAO(DB.getConnection());

		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);

		setTitle("Listagem de Vendas");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		carregarDados();
	}

	private void carregarDados() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Pedido_id");
		model.addColumn("Produto");
		model.addColumn("Cliente");
		model.addColumn("Data_pedido");
		model.addColumn("Valor_total");

		try {
			ResultSet resultSet = pedidos_produtosDAO.vendaRealizada();

			while (resultSet.next()) {
				int pedido_id = resultSet.getInt("pedido_id");
				String produto = resultSet.getString("nome_produto");
				String cliente = resultSet.getString("nome_cliente");
				String data_pedido = resultSet.getString("data_pedido");
				Double valor_total = resultSet.getDouble("valor_total");

				model.addRow(new Object[] { pedido_id, produto, cliente, data_pedido, valor_total });
			}

			table.setModel(model);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void voltarActionPerformed(java.awt.event.ActionEvent evt) {
		new OptionsRegisterSalesScreen().setVisible(true);
		dispose();
	}
	
	private JButton voltar;
}
