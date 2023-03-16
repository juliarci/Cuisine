import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyFinalPanel extends JPanel implements ChangeListener {
	private MyGridLayout mgl;
	private MyGridLayout mgl1;
	private MySpinner ms;
	private Box b, b2;
	private JPanel jp1, jp2, jp3, jp4;
	private MyButton btn;

	public MyFinalPanel(String text, String text2) {
		mgl = new MyGridLayout(3, 0, 5, 5, text);
		mgl1 = new MyGridLayout(4, 0, 5, 5, text);
		SpinnerModel model = new SpinnerNumberModel(3, 3, 4, 1);
		b = new Box(BoxLayout.X_AXIS);
		b2 = new Box(BoxLayout.X_AXIS);
		ms = new MySpinner(model);
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		btn = new MyButton(">");
		this.setUpAndDisplay(text, text2);
	}

	private void setUpAndDisplay(String text, String text2) {
		this.setLayout(new BorderLayout());
		if (text.equals("Nom du plat :")) {
			this.add(mgl);
			jp3.setPreferredSize(new Dimension(600, 12));
			jp1.add(new JLabel(text2));
			b.add(jp3);
			this.add(jp1, BorderLayout.NORTH);
			this.add(jp2, BorderLayout.SOUTH);

		} else {
			this.add(mgl);
			jp3.setPreferredSize(new Dimension(600, 12));
			jp4.setPreferredSize(new Dimension(430, 12));
			b2.add(new JLabel(text2));
			b2.add(ms);
			ms.addChangeListener(this);
			b2.add(jp4);
			jp1.add(b2);
			b.add(jp3);
			jp2.add(b);
			this.add(jp1, BorderLayout.NORTH);
			this.add(jp2, BorderLayout.SOUTH);

		}
	}

	public void stateChanged(ChangeEvent e) {
		Object source = e.getSource();
		if (source == ms) {
			if (ms.MySpinnerValue() == 3) {
				this.remove(mgl1);
				this.add(mgl, BorderLayout.CENTER);
			} else if (ms.MySpinnerValue() == 4) {
				this.remove(mgl);
				this.add(mgl1, BorderLayout.CENTER);
			}
			revalidate();
			repaint();
		}
	}

	public MyGridLayout getMgl() {
		return mgl;
	}

	public void setMgl(MyGridLayout mgl) {
		this.mgl = mgl;
	}

	public MyGridLayout getMgl1() {
		return mgl1;
	}

	public void setMgl1(MyGridLayout mgl1) {
		this.mgl1 = mgl1;
	}

	public MySpinner getMs() {
		return ms;
	}

	public void setMs(MySpinner ms) {
		this.ms = ms;
	}

}
