package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import DAO.ProdutosDAO;
import Util.DB;

public class TelaListagemProdutos extends JFrame {

    private JTable table;
    private ProdutosDAO produtosDAO;

    public TelaListagemProdutos() {

    	voltar = new JButton ();
    	voltar.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            voltarActionPerformed(evt);
	        }
	    });
    	
    	voltar.setText("Voltar");
        getContentPane().add(voltar);
        
        Font novaFonte = new Font ("MV Boli",Font.BOLD, 15);
        voltar.setBackground(Color.GREEN);
        voltar.setForeground(Color.BLACK);
        voltar.setFont(novaFonte);
         
        voltar.setBounds (3, 480,150,30);
    	
        produtosDAO = new ProdutosDAO(DB.getConnection());

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        setTitle("Listagem de Produtos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        carregarDados();
    }

    private void carregarDados() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Produto_id");
        model.addColumn("Nome");
        model.addColumn("Preço");

        try {
            ResultSet resultSet = produtosDAO.listarProdutos();

            while (resultSet.next()) {
                int produto_id = resultSet.getInt("produto_id"); 
                String nome = resultSet.getString("nome");
                double preco = resultSet.getDouble("preco");

                model.addRow(new Object[]{produto_id, nome, preco});
            }

            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            // Trate ou registre a exceção de acordo com a necessidade
        }
    }
    
    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {                                         
		new TelaProdutosOpcoes().setVisible(true);
	    dispose(); 
	}  

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaListagemProdutos listagemProdutos = new TelaListagemProdutos();
            listagemProdutos.setVisible(true);
        });
    }
    
    private JButton voltar;
}
