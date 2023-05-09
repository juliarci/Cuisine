import java.awt.GridLayout;

import javax.swing.JPanel;

public class MyGridLayout extends JPanel {
	private MyBigPanel[] mbp;
	private int ligne;
	private GridLayout grid;

	public MyGridLayout(int ligne, int colonne, int espace1, int espace2, String text) {
		this.ligne = ligne;
		grid = new GridLayout(ligne, colonne, espace1, espace2);
		mbp = new MyBigPanel[this.ligne];
		this.setLayout(grid);
		this.setUpAndDisplay(text);
	}

	private void setUpAndDisplay(String text) {
		for (int i = 0; i < this.ligne; i++) {
			mbp[i] = new MyBigPanel(text); // Ajout des panels dans la grille
			this.add(mbp[i]);
			mbp[i].setId(i + 1);// Création des identifiants des plats
		}
	}

	public MyBigPanel[] getMbp() {
		return mbp;
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

}
