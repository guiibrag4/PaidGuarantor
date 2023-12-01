	package View;
	
	import java.awt.Color;
	import java.awt.Font;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JOptionPane;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.SwingUtilities;
	import javax.swing.table.DefaultTableModel;
	
	import DAO.ClientesDAO;
	import Model.Clientes;
	import Util.DB;
	
	public class RUDCustomersScreen extends JFrame {
	
	    private JTable table;
	    private ClientesDAO clientesDAO;
	    private JButton atualizar;
	    private JButton excluir;
	
	    public RUDCustomersScreen() {
	
	    	voltar = new JButton ();
	    	voltar.addActionListener(new java.awt.event.ActionListener() {
		        public void actionPerformed(java.awt.event.ActionEvent evt) {
		            voltarActionPerformed(evt);
		        }
		    });
	    	
	    	voltar.setText("Voltar");
	        getContentPane().add(voltar);
	        
	        atualizar = new JButton("Atualizar");
	        atualizar.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                atualizarActionPerformed(evt);
	            }
	        });
	        getContentPane().add(atualizar);
	
	        excluir = new JButton("Excluir");
	        excluir.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                excluirActionPerformed(evt);
	            }
	        });
	        getContentPane().add(excluir);
	        
	        Font novaFonte = new Font ("MV Boli",Font.BOLD, 15);
	        voltar.setBackground(Color.GREEN);
	        voltar.setForeground(Color.BLACK);
	        voltar.setFont(novaFonte);
	         
	        voltar.setBounds (3, 480,150,30);
	        
	        
	        //Atualizar
	        atualizar.setBackground(Color.GREEN);
	        atualizar.setForeground(Color.BLACK);
	        atualizar.setFont(novaFonte);
	         
	        atualizar.setBounds (330, 480,150,30);
	        
	        //Excluir
	        excluir.setBackground(Color.RED);
	        excluir.setForeground(Color.WHITE);
	        excluir.setFont(novaFonte);
	         
	        excluir.setBounds (627, 480,150,30);
	    	
	        clientesDAO = new ClientesDAO(DB.getConnection());
	
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
	        model.addColumn("Cliente_id");
	        model.addColumn("Nome");
	        model.addColumn("Cpf");
	        model.addColumn("Telefone");
	        model.addColumn("Endereço de cobrança");
	
	        try {
	            ResultSet resultSet = clientesDAO.listarClientes();
	
	            while (resultSet.next()) {
	                int cliente_id = resultSet.getInt("cliente_id");
	                String nome = resultSet.getString("nome");
	                String cpf = resultSet.getString("cpf");
	                String telefone = resultSet.getString("telefone");
	                String endereco_cobranca = resultSet.getString("endereco_cobranca");
	
	                model.addRow(new Object[]{cliente_id, nome, cpf, telefone, endereco_cobranca});
	            }
	
	            table.setModel(model);
	
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	    
	    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {                                         
			new OptionsCustomersScreen().setVisible(true);
		    dispose(); 
		}  
	    
	    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {
	        int linhaSelecionada = table.getSelectedRow();
	        if (linhaSelecionada != -1) {
	        	editarCliente(linhaSelecionada);
	            int cliente_id = (int) table.getValueAt(linhaSelecionada, 0);
	            String nome = (String) table.getValueAt(linhaSelecionada, 1);
	            String cpf = (String) table.getValueAt(linhaSelecionada, 2);
	            String telefone = (String) table.getValueAt(linhaSelecionada, 3);
	            String endereco_cobranca = (String) table.getValueAt(linhaSelecionada, 4);

	            // Aqui você pode abrir uma janela de diálogo para o usuário editar os dados
	            // ou permitir a edição diretamente na tabela, capturando as alterações

	            // Após as alterações serem feitas pelo usuário, atualize o modelo da tabela
	            DefaultTableModel model = (DefaultTableModel) table.getModel();
	            model.setValueAt(nome, linhaSelecionada, 1);
	            model.setValueAt(cpf, linhaSelecionada, 2);
	            model.setValueAt(telefone, linhaSelecionada, 3);
	            model.setValueAt(endereco_cobranca, linhaSelecionada, 4);

	            // Capture os novos valores e atualize o banco de dados
	            try {
	                Clientes clienteSelecionado = new Clientes(cliente_id, nome, cpf, telefone, endereco_cobranca);
	                clientesDAO.atualizarClientes(clienteSelecionado);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	
	    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {
	        int linhaSelecionada = table.getSelectedRow();
	        if (linhaSelecionada != -1) {
	            int cliente_id = (int) table.getValueAt(linhaSelecionada, 0);
	            String nome = (String) table.getValueAt(linhaSelecionada, 1);
	            String cpf = (String) table.getValueAt(linhaSelecionada, 2);
	            String telefone = (String) table.getValueAt(linhaSelecionada, 3);
	            String endereco_cobranca = (String) table.getValueAt(linhaSelecionada, 4);
	
	            Clientes clienteSelecionado = new Clientes(cliente_id, nome, cpf, telefone, endereco_cobranca);
	            
	            int confirmacao = JOptionPane.showConfirmDialog(this,
	                    "Tem certeza que deseja excluir o cliente selecionado?", "Confirmação de Exclusão",
	                    JOptionPane.YES_NO_OPTION);
	
	            if (confirmacao == JOptionPane.YES_OPTION) {
	                try {
	                    clientesDAO.excluirUsuario(clienteSelecionado);
	                    carregarDados(); // Atualiza a tabela após a exclusão
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	    
	    private void editarCliente(int linhaSelecionada) {
	        int cliente_id = (int) table.getValueAt(linhaSelecionada, 0);
	        String nome = (String) table.getValueAt(linhaSelecionada, 1);
	        String cpf = (String) table.getValueAt(linhaSelecionada, 2);
	        String telefone = (String) table.getValueAt(linhaSelecionada, 3);
	        String endereco_cobranca = (String) table.getValueAt(linhaSelecionada, 4);

	        String novoNome = JOptionPane.showInputDialog(this, "Nome:", nome);
	        String novoCpf = JOptionPane.showInputDialog(this, "CPF:", cpf);
	        String novoTelefone = JOptionPane.showInputDialog(this, "Telefone:", telefone);
	        String novoEndereco = JOptionPane.showInputDialog(this, "Endereço de cobrança:", endereco_cobranca);

	        if (novoNome != null && novoCpf != null && novoTelefone != null && novoEndereco != null) {
	            DefaultTableModel model = (DefaultTableModel) table.getModel();
	            model.setValueAt(novoNome, linhaSelecionada, 1);
	            model.setValueAt(novoCpf, linhaSelecionada, 2);
	            model.setValueAt(novoTelefone, linhaSelecionada, 3);
	            model.setValueAt(novoEndereco, linhaSelecionada, 4);
	            
	            try {
	                Clientes clienteSelecionado = new Clientes(cliente_id, novoNome, novoCpf, novoTelefone, novoEndereco);
	                clientesDAO.atualizarClientes(clienteSelecionado);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            RUDCustomersScreen listagemClientes = new RUDCustomersScreen();
	            listagemClientes.setVisible(true);
	        });
	    }
	       
	    private JButton voltar;
	}
