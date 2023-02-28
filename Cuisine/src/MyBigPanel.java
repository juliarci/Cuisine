import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MyBigPanel extends JPanel {

	public MyBigPanel() {
		this.setUpAndDisplay();
	}

	private void setUpAndDisplay() {
		Border lineborder = BorderFactory.createLineBorder(Color.gray, 1); 
		MyBorder arcborder = new MyBorder();
		/**this.setLayout(new BorderLayout());**/
		Box b =new Box(BoxLayout.Y_AXIS);
		JPanel jp1 = new JPanel();
		jp1.add(new MyButton("Cancel"));
		jp1.add(new MyButton("OK"));
		b.add(new MyPanel());
		b.add(jp1);
		this.add(b);
		this.setBorder(arcborder);
	}

}
