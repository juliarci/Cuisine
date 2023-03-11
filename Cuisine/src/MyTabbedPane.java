import javax.swing.JTabbedPane;

public class MyTabbedPane extends JTabbedPane {
protected MyFinalPanel mfpE;
protected MyFinalPanel mfpP;
protected MyFinalPanel mfpD;

	public MyTabbedPane() {
		this.setSize(getPreferredSize());
		this.mfpE=new MyFinalPanel("Nom de l'entrée :", "Nombre d'entrées différentes :");
		this.mfpP=new MyFinalPanel("Nom du plat :", null);
		this.mfpD=new MyFinalPanel("Nom du dessert :", "Nombre de desserts différents :");
		this.setUpAndDisplay();
	}

	private void setUpAndDisplay() {
		this.add("Entrées",mfpE);
		this.add("Plats", mfpP);
		this.add("Desserts",mfpD);
	}

	public MyBigPanel getMfpE() {
		return (mfpE.getMbp3());
	}


	public MyBigPanel getMfpP() {
		return (mfpP.getMbp3());
	}


	public MyFinalPanel getMfpD() {
		return mfpD;
	}

	
}
