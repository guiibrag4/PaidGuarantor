package View;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class TelaClientesOpcoes extends javax.swing.JFrame {
	public	TelaClientesOpcoes() {
	        initComponents();
	        setLocationRelativeTo(null);
	    }

	@SuppressWarnings("unchecked")
	private void initComponents() {

		lblimg = new javax.swing.JLabel();
		cadastrar = new JButton();
		atualizar = new JButton ();
		voltar = new JButton ();
		listar = new JButton ();
		excluir = new JButton ();
		
		voltar.addActionListener(new java.awt.event.ActionListener() {
		        public void actionPerformed(java.awt.event.ActionEvent evt) {
		            voltarActionPerformed(evt);
		        }
		    });
		
		cadastrar.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            cadastrarActionPerformed(evt);
	        }
	    });
		
		listar.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            listarActionPerformed(evt);
	        }
	    });
		
		//Cadastrar
		cadastrar.setText("Cadastrar um novo cliente");
        getContentPane().add(cadastrar);
        
        Font novaFonte = new Font ("MV Boli",Font.BOLD, 15);
        cadastrar.setBackground(Color.GREEN);
        cadastrar.setForeground(Color.BLACK);
        cadastrar.setFont(novaFonte);
        
        cadastrar.setBounds (100,195,250,50);
       
        
        //Listar
        listar.setText("Listar os clientes");
        getContentPane().add(listar);
        
        listar.setBackground(Color.GREEN);
        listar.setForeground(Color.BLACK);
        listar.setFont(novaFonte);
        
        listar.setBounds (450, 195,250,50);
        
        //Atualizar
        atualizar.setText("Atualizar cliente");
        getContentPane().add(atualizar);
        
        atualizar.setBackground(Color.GREEN);
        atualizar.setForeground(Color.BLACK);
        atualizar.setFont(novaFonte);
        
        atualizar.setBounds (100, 345,250,50);
        
        //Excluir
        excluir.setText("Excluir cliente");
        getContentPane().add(excluir);
       
        excluir.setBackground(Color.RED);
        excluir.setForeground(Color.BLACK);
        excluir.setFont(novaFonte);
        
        excluir.setBounds (450, 345,250,50);
        
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
				new TelaClientesOpcoes().setVisible(true);
			}
		});
	}
		  
    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {                                         
		new TelaPrincipal().setVisible(true);
	    dispose(); 
	}   
    
    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {                                         
		new TelaClientesCadastro().setVisible(true);
	    dispose(); 
	}  
    
    private void listarActionPerformed(java.awt.event.ActionEvent evt) {                                         
		new TelaListagemClientes().setVisible(true);
	    dispose(); 
	}  

	private JLabel lblimg;
	private JButton cadastrar;
	private JButton voltar;
	private JButton listar;
	private JButton excluir;
	private JButton atualizar;

}
