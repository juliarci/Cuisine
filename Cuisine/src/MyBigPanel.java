import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MyBigPanel extends JPanel {

	public MyBigPanel(String text) {
		this.setUpAndDisplay(text);
	}

	private void setUpAndDisplay(String text) {
		Border lineborder = BorderFactory.createLineBorder(Color.gray, 1);
		MyBorder arcborder = new MyBorder();
		/** this.setLayout(new BorderLayout()); **/
		Box b = new Box(BoxLayout.Y_AXIS);
		Box b2 = new Box(BoxLayout.X_AXIS);
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		jp2.setPreferredSize(new Dimension(420,12));
		jp3.setPreferredSize(new Dimension(420,12));
		jp1.add(new MyButton("Supprimer"));
		jp1.add(new MyButton("OK"));
		b.add(new MyPanel(text));
		b2.add(jp2);
		b2.add(jp1);
		b.add(b2);
		this.add(jp3);
		this.add(b);
		this.setBorder(arcborder);
	}

}
