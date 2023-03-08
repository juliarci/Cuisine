import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class MyFinalPanel extends JPanel {

	public MyFinalPanel(String text, String text2) {
		this.setUpAndDisplay(text, text2);
	}

	private void setUpAndDisplay(String text, String text2) {
		this.setLayout(new BorderLayout());
		MyGridLayout mgl = new MyGridLayout(3, 0, 5, 5, text);
		MyGridLayout mgl1= new MyGridLayout(4, 0, 5, 5, text);
		if (text == "Nom du plat :") {
			this.add(mgl);
			Box b = new Box(BoxLayout.X_AXIS);
			JPanel jp1 = new JPanel();
			JPanel jp2 = new JPanel();
			JPanel jp3 = new JPanel();
			jp3.setPreferredSize(new Dimension(600, 12));
			jp1.add(new JLabel(text2));
			b.add(jp3);
			b.add(new MyButton(">"));
			jp2.add(b);
			this.add(jp1, BorderLayout.NORTH);
			this.add(jp2, BorderLayout.SOUTH);
		} else {
			this.add(mgl);
			Box b = new Box(BoxLayout.X_AXIS);
			Box b2 = new Box(BoxLayout.X_AXIS);
			JPanel jp1 = new JPanel();
			JPanel jp2 = new JPanel();
			JPanel jp3 = new JPanel();
			JPanel jp4 = new JPanel();
			jp3.setPreferredSize(new Dimension(600, 12));
			jp4.setPreferredSize(new Dimension(430, 12));
			SpinnerModel model = new SpinnerNumberModel(3, 3, 4, 1);
			MySpinner ms = new MySpinner(model);
			b2.add(new JLabel(text2));
			b2.add(ms);
			ms.addChangeListener(e -> {
			if (ms.MySpinnerValue()==3) {
				this.remove(mgl1);
				this.add(mgl, BorderLayout.CENTER);
	
			}else if(ms.MySpinnerValue()==4) {
				this.remove(mgl);
				this.add(mgl1, BorderLayout.CENTER);
			}
			revalidate();
			repaint();
			} );
			b2.add(jp4);
			jp1.add(b2);
			b.add(jp3);
			b.add(new MyButton(">"));
			jp2.add(b);
			this.add(jp1, BorderLayout.NORTH);
			this.add(jp2, BorderLayout.SOUTH);
		}
	}

}
