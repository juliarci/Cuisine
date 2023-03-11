import java.awt.GridLayout;

import javax.swing.JPanel;

public class MyGridLayout extends JPanel {
	protected MyBigPanel mbp;
	private int ligne;

	public MyGridLayout(int ligne, int colonne, int espace1, int espace2, String text) {
		GridLayout grid = new GridLayout(ligne, colonne, espace1, espace2);
		this.ligne=ligne;
		this.setLayout(grid);
		this.mbp=new MyBigPanel(text);
		this.setUpAndDisplay(text);
	}

	private void setUpAndDisplay(String text) {
		for (int i = 0; i < this.ligne; i++) {
			mbp=new MyBigPanel(text);
			this.add(mbp);
			mbp.setId(i+1);
		}
		
		}

	public MyBigPanel getMbp() {
		return mbp;
	}

	public int getLigne() {
		return ligne;
	}


}
