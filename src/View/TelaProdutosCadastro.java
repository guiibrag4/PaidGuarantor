package View;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import DAO.ProdutosDAO;
import Model.Produtos;
import Util.DB;


public class TelaProdutosCadastro extends javax.swing.JFrame {
	public	TelaProdutosCadastro() {
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
		voltar = new JButton ();
		jTextField1 = new javax.swing.JTextField();
		
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
		
		voltar.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            voltarActionPerformed(evt);
	        }
	    });
		
	    // DecimalFormat decimalFormat = new DecimalFormat ("#.##");
	    //decimalFormat.applyPattern("#.##");
	    
	    jFormattedPreco = new JFormattedTextField(numberFormat);
	   
		lblNovoProduto = new JLabel ();
		lblNome = new JLabel ();
		lblPreco = new JLabel ();
	
		getContentPane().add(lblNovoProduto);
		getContentPane().add(lblNome);
		getContentPane().add(lblPreco);
		
		
		//Cadastrar
		cadastrar.setText("Cadastrar");
        getContentPane().add(cadastrar);
        
        Font novaFonte = new Font ("MV Boli",Font.BOLD, 15);
        cadastrar.setBackground(Color.GREEN);
        cadastrar.setForeground(Color.BLACK);
        cadastrar.setFont(novaFonte);
        
        cadastrar.setBounds (320,470,140,28);
        
        //Nome
        jTextField1.setText("");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(279, 240, 248, 29);
        
        lblNome.setBounds(279, 220, 100, 20); 
        lblNome.setText("Nome");
       
        
        //Preco
        jFormattedPreco.setColumns(15); 
        getContentPane().add(jFormattedPreco);
        
        jFormattedPreco.setBounds(279,350,248,29);
        
        lblPreco.setBounds(279, 330, 100, 20);
        lblPreco.setText("Preço");
        
        //Novo Produto
        lblNovoProduto.setBounds(300, 55, 500, 70);
        lblNovoProduto.setText ("Novo Produto");
        
        //Voltar
        voltar.setText("Voltar");
        getContentPane().add(voltar);
        
        voltar.setBackground(Color.GREEN);
        voltar.setForeground(Color.BLACK);
        voltar.setFont(novaFonte);
        
        voltar.setBounds (3, 480,150,30);
        
        Font fonteLabels = new Font("Arial black", Font.PLAIN, 14); 
        Font fonteLabels2 = new Font("Arial black", Font.PLAIN, 28);
        
        lblNovoProduto.setFont(fonteLabels2);
        lblNome.setFont(fonteLabels);
        lblPreco.setFont(fonteLabels);
   
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
				new TelaProdutosCadastro().setVisible(true);
			}
		});
	}
	
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {         	
	String nome = jTextField1.getText();	
	String preco = jFormattedPreco.getText();
	Double precoDouble = Double.parseDouble(preco);
	
	
	Produtos product = new Produtos ();
	product.setNome(nome);
	product.setPreco(precoDouble);
	
	ProdutosDAO p = new ProdutosDAO (DB.getConnection());
	try {
		p.inserirProduto(product);
		JOptionPane.showMessageDialog (null, "Produto Cadastrado!");
	    new TelaPrincipal().setVisible(true);
	    dispose(); 
	} catch (Exception e) {
		JOptionPane.showMessageDialog (null, "Erro ao cadastrar o produto: " + e.getMessage());
	}
} 

	private void voltarActionPerformed(java.awt.event.ActionEvent evt) {                                         
		new TelaProdutosOpcoes().setVisible(true);
		dispose(); 
	}  

	private JLabel lblimg;
	private JButton voltar;
	private JButton cadastrar;
	private JFormattedTextField jFormattedPreco; 
	private JTextField jTextField1;
	private JLabel lblNovoProduto;
	private JLabel lblNome;
	private JLabel lblPreco;
}
