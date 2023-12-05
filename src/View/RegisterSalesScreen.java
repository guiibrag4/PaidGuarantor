package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.PedidosDAO;
import DAO.Pedidos_produtosDAO;
import Model.Pedidos;
import Model.Pedidos_produtos;
import Util.DB;

public class RegisterSalesScreen extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	public RegisterSalesScreen() {
		initComponents();
		setLocationRelativeTo(null);
		carregarUltimoPedido();
	}

	private void initComponents() {

		lblimg = new javax.swing.JLabel();
		confirmar = new JButton();
		jTextProduto_id = new JTextField();
		jTextPedido_id = new JTextField();
		jTextQuantidade = new JTextField();
		lblNovaVenda = new JLabel();
		lblCliente = new JLabel();
		lblValorPedido = new JLabel();
		lblProduto_id = new JLabel();
		lblItensPedido = new JLabel();
		lblQuantidade = new JLabel();

		confirmar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				confirmarVendaActionPerformed(evt);
			}
		});

		getContentPane().add(lblNovaVenda);
		getContentPane().add(lblCliente);
		getContentPane().add(lblValorPedido);
		getContentPane().add(lblProduto_id);
		getContentPane().add(lblItensPedido);
		getContentPane().add(lblQuantidade);

		// Fazer um pedido
		lblNovaVenda.setBounds(300, 55, 500, 70);
		lblNovaVenda.setText("Fazer um pedido");

		// Pedido_id
		lblCliente.setBounds(40, 230, 300, 20);
		lblCliente.setText("Pedido_id:");

		jTextPedido_id.setText("");
		getContentPane().add(jTextPedido_id);
		jTextPedido_id.setBounds(190, 227, 250, 30);

		/*// Valor do Pedido
		lblValorPedido.setBounds(3, 210, 300, 20);
		lblValorPedido.setText("Valor do Pedido:");

		jTextField2.setText("");
		getContentPane().add(jTextField2);
		jTextField2.setBounds(245, 207, 250, 30); */

		// Produto_id
		lblProduto_id.setBounds(40, 290, 300, 20);
		lblProduto_id.setText("Produto_id: ");

		jTextProduto_id.setText("");
		getContentPane().add(jTextProduto_id);
		jTextProduto_id.setBounds(190, 287, 250, 30);

		// Quantidade
		lblQuantidade.setBounds(40, 350, 300, 20);
		lblQuantidade.setText("Quantidade:");

		jTextQuantidade.setText("");
		getContentPane().add(jTextQuantidade);
		jTextQuantidade.setBounds(190, 347, 250, 30);

		confirmar.setText("Confirmar");
		getContentPane().add(confirmar);

		Font novaFonte = new Font("MV Boli", Font.BOLD, 15);
		confirmar.setBackground(Color.GREEN);
		confirmar.setForeground(Color.BLACK);
		confirmar.setFont(novaFonte);

		confirmar.setBounds(655, 480, 140, 28);

		Font fonteLabels = new Font("Arial black", Font.PLAIN, 28);
		Font fonteLabels2 = new Font("Arial black", Font.PLAIN, 23);

		lblNovaVenda.setFont(fonteLabels);
		lblCliente.setFont(fonteLabels2);
		/*lblValorPedido.setFont(fonteLabels2);
		lblItensPedido.setFont(fonteLabels2);*/
		lblQuantidade.setFont(fonteLabels2);
		lblProduto_id.setFont(fonteLabels2);
		

		ImageIcon icon = new ImageIcon(getClass().getResource("/Images/TelaBase.png"));
		Image img = icon.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		lblimg.setIcon(icon);
		lblimg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(lblimg, javax.swing.GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(lblimg, javax.swing.GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE));

		pack();
	}

	private void confirmarVendaActionPerformed(java.awt.event.ActionEvent evt) {
		String pedidoTxt = jTextPedido_id.getText();
		String produtoTxt = jTextProduto_id.getText();
		String quantidadeTxt = jTextQuantidade.getText();
		int pedido_id = Integer.parseInt(pedidoTxt);
		int produto_id = Integer.parseInt (produtoTxt);
		int quantidade = Integer.parseInt(quantidadeTxt);
		
		if (pedidoTxt.isEmpty() || produtoTxt.isEmpty() || quantidadeTxt.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios");
			return;
		}

		Pedidos_produtos pp = new Pedidos_produtos();
		pp.setPedido_id(pedido_id);
		pp.setProduto_id(produto_id);
		pp.setQuantidade(quantidade);

		Pedidos_produtosDAO p = new Pedidos_produtosDAO(DB.getConnection());
		try {
			p.inserirPedidos_produtos(pp);
			JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
			new OptionsRegisterSalesScreen().setVisible(true);
			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar a venda: " + e.getMessage());
		}
	}
	
	private void carregarUltimoPedido() {
	    PedidosDAO pedidosDAO = new PedidosDAO(DB.getConnection());

	    try {
	        Pedidos ultimoPedido = pedidosDAO.obterUltimoPedido();

	        if (ultimoPedido != null) {
	            
	            jTextPedido_id.setText(String.valueOf(ultimoPedido.getPedido_id()));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	private JLabel lblimg;
	private JButton confirmar;
	private JTextField jTextQuantidade;
	private JTextField jTextPedido_id;
	private JTextField jTextProduto_id;
	private JLabel lblNovaVenda;
	private JLabel lblCliente;
	private JLabel lblValorPedido;
	private JLabel lblProduto_id;
	private JLabel lblItensPedido;
	private JLabel lblQuantidade;
}
