package Controller;

import java.util.Locale;
import View.TelaCarregamento;

public class MainProgramController {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TelaCarregamento().setVisible(true);
			}
		});
	}
}
