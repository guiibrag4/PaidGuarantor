package View;

import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class TelaCarregamento extends JFrame {
	public TelaCarregamento() {
		initComponents();
		setLocationRelativeTo(null);
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		lblimg = new javax.swing.JLabel();

		ImageIcon icon = new ImageIcon(getClass().getResource("/Images/TelaCarregamento2.png"));
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

		// Agendando a transição para a tela de login após 5 segundos
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				openLoginScreen();
			}
		}, 4000); // 5 segundos em milissegundos
	}

	private void openLoginScreen() {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TelaLogin().setVisible(true);
				dispose(); // Fecha a tela de carregamento
			}
		});
	}

	/*
	 * public static void main(String args[]) { java.awt.EventQueue.invokeLater(new
	 * Runnable() { public void run() { new TelaCarregamento().setVisible(true); }
	 * }); }
	 */

	private javax.swing.JLabel lblimg;
}
