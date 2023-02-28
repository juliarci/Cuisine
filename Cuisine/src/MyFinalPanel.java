import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFinalPanel extends JPanel {

	public MyFinalPanel() {
		this.setUpAndDisplay();
	}

	private void setUpAndDisplay() {
		this.setLayout(new BorderLayout());
		this.add(new MyBoxLayout(), BorderLayout.CENTER);
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp1.add(new JLabel("Nombre d'entrées différentes :"));
		jp2.add(new MyButton(">"));
		this.add(jp1, BorderLayout.NORTH);
		this.add(jp2, BorderLayout.SOUTH);

	}
}
