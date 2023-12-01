package View;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

import DAO.UsuariosDAO;
import Model.Usuarios;
import Util.DB;

import javax.swing.*;


public class RegisterUserScreen extends javax.swing.JFrame {
	public	RegisterUserScreen() {
	        initComponents();
	        setLocationRelativeTo(null);
	        cadastrar.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });
	    }

	@SuppressWarnings("unchecked")
	private void initComponents() {

		lblimg = new javax.swing.JLabel();
		cadastrar = new JButton();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new JTextField ();
		jPasswordField = new javax.swing.JPasswordField();
		lblEmail = new JLabel ();
		lblSenha = new JLabel ();
		lbltelefone = new JLabel ();
		lblNome = new JLabel ();
		
		getContentPane().add(lblEmail);
		getContentPane().add(lblSenha);
		getContentPane().add(lbltelefone);
		getContentPane().add(lblNome);
		
		//Cadastrar
		cadastrar.setText("Cadastrar");
        getContentPane().add(cadastrar);
        
        Font novaFonte = new Font ("MV Boli",Font.BOLD, 15);
        cadastrar.setBackground(Color.GREEN);
        cadastrar.setForeground(Color.BLACK);
        cadastrar.setFont(novaFonte);
        
        cadastrar.setBounds (320,470,140,28);
        
        //Nome 
        jTextField3.setText("");
        getContentPane().add(jTextField3);
        jTextField3.setBounds(279, 170, 248, 29);
        
        lblNome.setBounds(279, 150, 100, 20); 
        lblNome.setText("Nome");
        
        //Email
        jTextField1.setText("");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(279, 240, 248, 29);
        
        lblEmail.setBounds(279, 220, 100, 20); 
        lblEmail.setText("Email");
        
        //lblSenha
        jPasswordField.setText("");
        getContentPane().add(jPasswordField);
        jPasswordField.setBounds(279, 315, 248, 29);
        
        lblSenha.setBounds(279, 295, 248, 20);
        lblSenha.setText("Senha");
        
        //Telefone
        jTextField2.setText("");
        getContentPane().add(jTextField2);
        jTextField2.setBounds(279, 390, 248, 29);
        
        lbltelefone.setBounds(279, 370, 100, 20);
        lbltelefone.setText("Telefone");
        
        Font fonteLabels = new Font("Arial black", Font.PLAIN, 14); 

        lblEmail.setFont(fonteLabels);
        lblSenha.setFont(fonteLabels);
        lbltelefone.setFont(fonteLabels);
        lblNome.setFont(fonteLabels);
  
		ImageIcon icon = new ImageIcon(getClass().getResource("/Images/TelaCadastro.png"));
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
	
	public static void main (String [] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new RegisterUserScreen().setVisible(true);
			}
		});
	}
	
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {         
	DB bd = new DB ();
	
	String email = jTextField1.getText();	
	String senha = new String (jPasswordField.getPassword());
	String telefone = jTextField2.getText();
	String nome = jTextField3.getText();
	
	Usuarios user = new Usuarios();
	user.setEmail(email);
	user.setSenha(senha);
	user.setTelefone(telefone);
	user.setNome (nome);
	
	if (email.isEmpty() || senha.isEmpty() || telefone.isEmpty() || nome.isEmpty()) {
		JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios", "Erro", JOptionPane.WARNING_MESSAGE);
		return;
	}
	
	UsuariosDAO u = new UsuariosDAO (DB.getConnection());
	try {
		u.inserirUsuario(user);
		JOptionPane.showMessageDialog (null, "Usuário cadastrado com sucesso!");
	    new LoginScreen().setVisible(true);
	    dispose(); // Fecha a tela de carregamento
	} catch (Exception e) {
		JOptionPane.showMessageDialog (null, "Erro ao cadastrar usuário: " + e.getMessage());
	}
} 

	private JLabel lblimg;
	private JButton cadastrar;
	private JTextField jTextField2;
	private JTextField jTextField1;
	private JTextField jTextField3;
	private JPasswordField jPasswordField;
	private JLabel lblEmail;
	private JLabel lblSenha;
	private JLabel lbltelefone;
	private JLabel lblNome;

}
