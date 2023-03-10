import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

public class MyPanel extends JPanel {
protected MyTextField mtf;
protected MySpinner ms;


	public MyPanel(String text) {
		this.mtf=new MyTextField();
		SpinnerModel model = new SpinnerNumberModel(0, 0, null, 1);
		this.ms=new MySpinner(model);
		this.setUpAndDisplay(text);
	}

	private void setUpAndDisplay(String text) {
		Border lineborder = BorderFactory.createLineBorder(Color.gray, 1);
		Box b = new Box(BoxLayout.Y_AXIS);
		Box b2 = new Box(BoxLayout.Y_AXIS);
		JPanel b3 = new JPanel();
		JLabel jl1 = new JLabel(text);
		JLabel jl2 = new JLabel(" Quantité :");
		b.setPreferredSize(new Dimension(150, 40));
		jl1.setAlignmentX(LEFT_ALIGNMENT);
		b.add(jl1);
		b2.add(mtf);
		b.add(Box.createVerticalStrut(5));
		b.add(jl2);
		b2.add(ms);
		b3.add(b);
		b3.add(b2);
		this.add(b3);
	}

	public MyTextField getMtf() {
		return mtf;
	}

	public void setMtf(MyTextField mtf) {
		this.mtf = mtf;
	}

	public MySpinner getMs() {
		return ms;
	}

	

}
