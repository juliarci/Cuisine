import javax.swing.JTabbedPane;

public class MyTabbedPane extends JTabbedPane {

	public MyTabbedPane() {
		this.setSize(getPreferredSize());
		this.setUpAndDisplay();
	}

	private void setUpAndDisplay() {
		this.add("Entrées", new MyFinalPanel("Nom de l'entrée :", "Nombre d'entrées différentes :"));
		this.add("Plats", new MyFinalPanel("Nom du plat :", null));
		this.add("Desserts", new MyFinalPanel("Nom du dessert :", "Nombre de desserts différents :"));
	}
}
