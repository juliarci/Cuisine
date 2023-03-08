import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class MyGridLayout extends JPanel {

	private int ligne;

	public MyGridLayout(int ligne, int colonne, int espace1, int espace2, String text) {
		GridLayout grid = new GridLayout(ligne, colonne, espace1, espace2);
		this.ligne=ligne;
		this.setLayout(grid);
		this.setUpAndDisplay(text);
	}

	private void setUpAndDisplay(String text) {
		for (int i = 0; i < this.ligne; i++) {
			this.add(new MyBigPanel(text));
		}
		
		}

	


}
