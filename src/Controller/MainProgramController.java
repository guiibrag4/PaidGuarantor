package Controller;

import java.util.Locale;
import View.LoadingScreen;

public class MainProgramController {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LoadingScreen().setVisible(true);
			}
		});
	}
}
