package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.UsuariosDAO;
import Util.DB;

public class TelaLogin extends javax.swing.JFrame {

	Connection conexao = null;
	PreparedStatement sql = null;
	ResultSet rs = null;

	public TelaLogin() {
		initComponents();
		setLocationRelativeTo(null);

		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		lblimg = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jPasswordField1 = new javax.swing.JPasswordField();
		jTextField1 = new javax.swing.JTextField();

		jButton1.setText("ENTRAR");
		getContentPane().add(jButton1);
		jButton1.setBounds(302, 370, 201, 29);
		// x,y, c,h

		jButton2.setText("Clique Aqui");
		getContentPane().add(jButton2);

		Font novaFonte = new Font("Arial", Font.BOLD, 10);
		jButton2.setBackground(Color.YELLOW);
		jButton2.setForeground(Color.RED);
		jButton2.setFont(novaFonte);

		jButton2.setBounds(433, 507, 90, 25);

		jPasswordField1.setText("Password");
		getContentPane().add(jPasswordField1);
		jPasswordField1.setBounds(279, 297, 248, 29);

		jTextField1.setText("Seu email");
		getContentPane().add(jTextField1);
		jTextField1.setBounds(279, 233, 248, 29);

		ImageIcon icon = new ImageIcon(getClass().getResource("/Images/TelaLoginPrincipal.png"));
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

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		DB bd = new DB();

		UsuariosDAO u = new UsuariosDAO(DB.getConnection());

		String email = jTextField1.getText();
		String senha = new String(jPasswordField1.getText());

		if (u.validarLogin(email, senha)) {
			TelaPrincipal telaPrincipal = new TelaPrincipal();
			telaPrincipal.setVisible(true);
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Credenciais inválidas. Tente novamente.");
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		new TelaCadastro().setVisible(true);
		dispose();
	}

	private JLabel lblimg;
	private JButton jButton1;
	private JButton jButton2;
	private JPasswordField jPasswordField1;
	private JTextField jTextField1;

	public static void main(String[] args) {

	}

}
