package View;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;


public class OptionsRegisterSalesScreen extends javax.swing.JFrame {
	public	OptionsRegisterSalesScreen() {
	        initComponents();
	        setLocationRelativeTo(null);
	    }

	@SuppressWarnings("unchecked")
	private void initComponents() {

		lblimg = new javax.swing.JLabel();
		voltar = new JButton ();
		cadastrar = new JButton();	
		listar = new JButton ();
		
		voltar.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            voltarActionPerformed(evt);
	        }
	    });
		
		cadastrar.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            registrarActionPerformed(evt);
	        }
	    });
		
		listar.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	listarActionPerformed(evt);
	        }
	    });
		
		//Cadastrar
		cadastrar.setText("Registrar uma nova venda");
        getContentPane().add(cadastrar);
        
        Font novaFonte = new Font ("MV Boli",Font.BOLD, 15);
        cadastrar.setBackground(Color.GREEN);
        cadastrar.setForeground(Color.BLACK);
        cadastrar.setFont(novaFonte);
        
        cadastrar.setBounds (270,220,250,50);
       
        //Listar
        listar.setText("Listar as vendas");
        getContentPane().add(listar);
        
        listar.setBackground(Color.GREEN);
        listar.setForeground(Color.BLACK);
        listar.setFont(novaFonte);
        
        listar.setBounds (270, 320,250,50);
        
        //Voltar
        //Voltar
        voltar.setText("Voltar");
        getContentPane().add(voltar);
        
        voltar.setBackground(Color.GREEN);
        voltar.setForeground(Color.BLACK);
        voltar.setFont(novaFonte);
        
        voltar.setBounds (3, 480,150,30);
        
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
				new OptionsRegisterSalesScreen().setVisible(true);
			}
		});
	}
	
    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {                                         
		new MainScreen().setVisible(true);
	    dispose(); 
	}   
    
    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {                                         
		new RegisterSalesScreen().setVisible(true);
	    dispose(); 
	}   
    
    private void listarActionPerformed(java.awt.event.ActionEvent evt) {                                         
		
	} 

	private JLabel lblimg;
	private JButton voltar;
	private JButton cadastrar;
	private JButton listar;
}
