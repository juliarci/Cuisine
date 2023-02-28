import javax.swing.JTabbedPane;

public class MyTabbedPane extends JTabbedPane {

	public MyTabbedPane() {
		this.setSize(getPreferredSize());
		this.setUpAndDisplay();
	}

	private void setUpAndDisplay() {
		this.add("Entrées", new MyFinalPanel());
		this.add("Plats", new MyFinalPanel());
		this.add("Desserts",new MyFinalPanel());
	}
}
