package View;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

import DAO.ClientesDAO;
import Model.Clientes;
import Util.DB;


public class RegisterCustomerScreen extends javax.swing.JFrame {
	public	RegisterCustomerScreen() {
	        initComponents();
	        setLocationRelativeTo(null);
	    }

	@SuppressWarnings("unchecked")
	private void initComponents() {

		lblimg = new javax.swing.JLabel();
		confirmar = new JButton();
		voltar = new JButton ();
		jTextNome = new javax.swing.JTextField();
		jTextCpf = new javax.swing.JTextField();
		jTextTelefone = new javax.swing.JTextField();
		jTextEnderecoCobranca = new javax.swing.JTextField();
		lblNovoCliente = new JLabel ();
		lblNome= new JLabel ();
		lblCpf= new JLabel ();
		lblTelefone= new JLabel ();
		lblEnderecoCobranca= new JLabel ();
		
		 confirmar.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });
		
		voltar.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            voltarActionPerformed(evt);
	        }
	    });
		
		getContentPane().add(lblNovoCliente);
		getContentPane().add(lblNome);
		getContentPane().add(lblCpf);
		getContentPane().add(lblTelefone);
		getContentPane().add(lblEnderecoCobranca);
		

		lblNovoCliente.setBounds(300, 55, 500, 70); 
	    lblNovoCliente.setText("Novo Cliente");
	    
	 
	    lblNome.setBounds(3, 190, 300, 20); 
	    lblNome.setText("Nome:");
	    
	    jTextNome.setText("");
        getContentPane().add(jTextNome);
        jTextNome.setBounds(107, 187, 380, 40);
	    
	    
	    lblCpf.setBounds(3, 270, 400, 20); 
	    lblCpf.setText("Cpf:");
	    
	    jTextCpf.setText("");
        getContentPane().add(jTextCpf);
        jTextCpf.setBounds(77, 267, 500, 40);
	    

	    lblTelefone.setBounds(3, 350, 300, 20); 
	    lblTelefone.setText("Telefone:");
	    
	    jTextTelefone.setText("");
        getContentPane().add(jTextTelefone);
        jTextTelefone.setBounds(127, 347, 500, 40);
	    
	
	    lblEnderecoCobranca.setBounds(3, 430, 300, 20); 
	    lblEnderecoCobranca.setText("Endereço de cobrança:");
	    
	    jTextEnderecoCobranca.setText("");
        getContentPane().add(jTextEnderecoCobranca);
        jTextEnderecoCobranca.setBounds(330, 427, 450, 40);
        
        confirmar.setText("Confirmar");
        getContentPane().add(confirmar);
        
        Font novaFonte = new Font ("MV Boli",Font.BOLD, 15);
        confirmar.setBackground(Color.GREEN);
        confirmar.setForeground(Color.BLACK);
        confirmar.setFont(novaFonte);
        
        confirmar.setBounds (655,480,140,28);
        
        voltar.setText("Voltar");
        getContentPane().add(voltar);
        
        voltar.setBackground(Color.GREEN);
        voltar.setForeground(Color.BLACK);
        voltar.setFont(novaFonte);
        
        voltar.setBounds (3,480,140,28);
	    
        Font fonteLabels = new Font("Arial black", Font.PLAIN, 28);
        Font fonteLabels2 = new Font ("Arial black", Font.PLAIN,23);
        Font fonteLabels3 = new Font ("Comic Sans MS",Font.PLAIN,25);
        
        
        jTextNome.setFont(fonteLabels3);
        jTextCpf.setFont(fonteLabels3);
        jTextTelefone.setFont(fonteLabels3);
        jTextEnderecoCobranca.setFont(fonteLabels3);
        lblNovoCliente.setFont(fonteLabels);
        lblNome.setFont(fonteLabels2);
        lblCpf.setFont(fonteLabels2);
        lblTelefone.setFont(fonteLabels2);
        lblEnderecoCobranca.setFont(fonteLabels2);
         
        
  
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
	
	public static void main (String [] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new RegisterCustomerScreen().setVisible(true);
			}
		});
	}
	  
    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {                                         
		new OptionsCustomersScreen().setVisible(true);
	    dispose(); 
	}   
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {         
    	DB bd = new DB ();
    	
    	String nome = jTextNome.getText();	
    	String cpf = jTextCpf.getText();
    	String telefone = jTextTelefone.getText();
    	String enderecoCobranca = jTextEnderecoCobranca.getText();
    	
    	if (nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() || enderecoCobranca.isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios");
    		return;
    	}
    
    	Clientes customer = new Clientes ();
    	customer.setNome(nome);
    	customer.setCpf(cpf);
    	customer.setTelefone(telefone);
    	customer.setEndereco_cobranca(enderecoCobranca);
    	
    	ClientesDAO c = new ClientesDAO (DB.getConnection());
  
    	try {
    		c.inserirCliente(customer);
    		JOptionPane.showMessageDialog (null, "Cliente Cadastrado!");
    	    
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog (null, "Erro ao cadastrar usuário: " + e.getMessage());
    	}
    } 

	private JLabel lblimg;
	private JButton confirmar;
	private JButton voltar;
	private JTextField jTextEnderecoCobranca;
	private JTextField jTextTelefone;
	private JTextField jTextCpf;
	private JTextField jTextNome;
	private JLabel lblNovoCliente;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblTelefone;
	private JLabel lblEnderecoCobranca;


}
