import java.util.List;

import javax.swing.JTabbedPane;

public class MyTabbedPane extends JTabbedPane {
	protected MyFinalPanel mfpE;
	protected MyFinalPanel mfpP;
	protected MyFinalPanel mfpD;

	public MyTabbedPane() {
		this.setSize(getPreferredSize());
		this.mfpE = new MyFinalPanel("Nom de l'entrée :", "Nombre d'entrées différentes :");
		this.mfpP = new MyFinalPanel("Nom du plat :", null);
		this.mfpD = new MyFinalPanel("Nom du dessert :", "Nombre de desserts différents :");
		this.setUpAndDisplay();
	}

	private void setUpAndDisplay() {
		this.add("Entrées", mfpE);
		this.add("Plats", mfpP);
		this.add("Desserts", mfpD);


	}

	public MyFinalPanel getMfpE() {
		return mfpE;
	}

	public void setMfpE(MyFinalPanel mfpE) {
		this.mfpE = mfpE;
	}

	public MyFinalPanel getMfpP() {
		return mfpP;
	}

	public void setMfpP(MyFinalPanel mfpP) {
		this.mfpP = mfpP;
	}

	public MyFinalPanel getMfpD() {
		return mfpD;
	}

	public void setMfpD(MyFinalPanel mfpD) {
		this.mfpD = mfpD;
	}

	
	
}
