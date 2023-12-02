package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

public class MainScreen extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	public MainScreen() {
		initComponents();
		setLocationRelativeTo(null);
	}

	private void initComponents() {

		lblimg = new javax.swing.JLabel();
		clientes = new JButton();
		registrarVendas = new JButton();
		pagos = new JButton();
		devedores = new JButton();
		produtos = new JButton();

		clientes.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clientesActionPerformed(evt);
			}
		});

		devedores.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				devedoresActionPerformed(evt);
			}
		});

		pagos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				pagosActionPerformed(evt);
			}
		});

		registrarVendas.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				registrarVendasActionPerformed(evt);
			}
		});

		produtos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				produtosActionPerformed(evt);
			}
		});

		// clientes
		clientes.setText("Clientes");
		getContentPane().add(clientes);

		Font novaFonte = new Font("MV Boli", Font.BOLD, 18);
		clientes.setBackground(Color.YELLOW);
		clientes.setForeground(Color.BLACK);
		clientes.setFont(novaFonte);

		clientes.setBounds(148, 201, 180, 45);

		// pagos
		pagos.setText("Pagos");
		getContentPane().add(pagos);

		pagos.setBackground(Color.YELLOW);
		pagos.setForeground(Color.BLACK);
		pagos.setFont(novaFonte);

		pagos.setBounds(148, 400, 180, 45);

		registrarVendas.setText("Registrar Vendas");
		getContentPane().add(registrarVendas);

		// registrarVendas
		registrarVendas.setBackground(Color.YELLOW);
		registrarVendas.setForeground(Color.BLACK);
		registrarVendas.setFont(novaFonte);

		registrarVendas.setBounds(538, 201, 200, 45);

		// devedores
		devedores.setText("Devedores");
		getContentPane().add(devedores);

		devedores.setBackground(Color.YELLOW);
		devedores.setForeground(Color.BLACK);
		devedores.setFont(novaFonte);

		devedores.setBounds(148, 299, 180, 45);

		// produtos
		produtos.setText("Produtos");
		getContentPane().add(produtos);

		produtos.setBackground(Color.YELLOW);
		produtos.setForeground(Color.BLACK);
		produtos.setFont(novaFonte);

		produtos.setBounds(538, 302, 180, 45);

		ImageIcon icon = new ImageIcon(getClass().getResource("/Images/TelaInicialPrincipal.png"));
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

	private void clientesActionPerformed(java.awt.event.ActionEvent evt) {
		new OptionsCustomersScreen().setVisible(true);
		dispose();
	}

	private void devedoresActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void pagosActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void registrarVendasActionPerformed(java.awt.event.ActionEvent evt) {
		new OptionsRegisterSalesScreen().setVisible(true);
		dispose();
	}

	private void produtosActionPerformed(java.awt.event.ActionEvent evt) {
		new OptionsProductsScreen().setVisible(true);
		dispose();
	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainScreen().setVisible(true);
			}
		});
	}

	private JLabel lblimg;
	private JButton clientes;
	private JButton pagos;
	private JButton devedores;
	private JButton registrarVendas;
	private JButton produtos;

}
