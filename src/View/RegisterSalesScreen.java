package View;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.ClientesDAO;
import Util.DB;


public class RegisterSalesScreen extends javax.swing.JFrame {
	public	RegisterSalesScreen() {
	        initComponents();
	        setLocationRelativeTo(null);
	    }

	@SuppressWarnings("unchecked")
	private void initComponents() {

		lblimg = new javax.swing.JLabel();
		confirmar = new JButton();
		voltar = new JButton ();
		jTextField1 = new JTextField();
		jTextField2 = new JTextField();
		jTextField3 = new JTextField();
		jTextField4 = new JTextField();
		jTextField5 = new JTextField();
		lblNovaVenda = new JLabel ();
		lblCliente= new JLabel ();
		lblValorPedido= new JLabel ();
		lblDataPedido= new JLabel ();
		lblItensPedido= new JLabel ();
		lblQuantidade= new JLabel ();
		
		voltar.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            voltarActionPerformed(evt);
	        }
	    });
		
		confirmar.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            confirmarVendaActionPerformed(evt);
	        }
	    });
		
		getContentPane().add(lblNovaVenda);
		getContentPane().add(lblCliente);
		getContentPane().add(lblValorPedido);
		getContentPane().add(lblDataPedido);
		getContentPane().add(lblItensPedido);
		getContentPane().add(lblQuantidade);
		
		//Nova Venda
		lblNovaVenda.setBounds(300, 55, 500, 70); 
	    lblNovaVenda.setText("Nova Venda");
	    
	    
	    //Cliente
	    lblCliente.setBounds(3, 150, 300, 20); 
	    lblCliente.setText("Cliente:");
	    
	    jTextField1.setText("");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(127, 147, 250, 30);
	    
	    //Valor do Pedido
	    lblValorPedido.setBounds(3, 210, 300, 20); 
	    lblValorPedido.setText("Valor do Pedido:");
	    
	    jTextField2.setText("");
        getContentPane().add(jTextField2);
        jTextField2.setBounds(245, 207, 250, 30);
	    
	    //Data do Pedido
	    lblDataPedido.setBounds(3, 290, 300, 20); 
	    lblDataPedido.setText("Data do pedido:");
	    
	    jTextField3.setText("");
        getContentPane().add(jTextField3);
        jTextField3.setBounds(245, 287, 250, 30);
	    
	    //Itens do Pedido
	    lblItensPedido.setBounds(3, 370, 300, 20); 
	    lblItensPedido.setText("Itens do pedido:");
	    
	    jTextField4.setText("");
        getContentPane().add(jTextField4);
        jTextField4.setBounds(245, 367, 250, 30);
        
        //Quantidade
	    lblQuantidade.setBounds(3, 450, 300, 20); 
	    lblQuantidade.setText("Quantidade:");
	    
	    jTextField5.setText("");
        getContentPane().add(jTextField5);
        jTextField5.setBounds(185, 447, 250, 30);
        
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

        lblNovaVenda.setFont(fonteLabels);
        lblCliente.setFont(fonteLabels2);
        lblValorPedido.setFont(fonteLabels2);
        lblDataPedido.setFont(fonteLabels2);
        lblItensPedido.setFont(fonteLabels2);
        lblQuantidade.setFont (fonteLabels2);
         
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
				new RegisterSalesScreen().setVisible(true);
			}
		});
	}
	  
    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {                                         
		new MainScreen().setVisible(true);
	    dispose(); 
	}   
    
    private void confirmarVendaActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	
	}

	private JLabel lblimg;
	private JButton confirmar;
	private JButton voltar;
	private JTextField jTextField5;
	private JTextField jTextField4;
	private JTextField jTextField3;
	private JTextField jTextField2;
	private JTextField jTextField1;
	private JLabel lblNovaVenda;
	private JLabel lblCliente;
	private JLabel lblValorPedido;
	private JLabel lblDataPedido;
	private JLabel lblItensPedido;
	private JLabel lblQuantidade;
}
