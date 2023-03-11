import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;

public class MyBigPanel extends JPanel {
	protected String saisie1;
	protected int saisie2;
	protected int id;

	public MyBigPanel(String text) {
		this.saisie1 = new String();
		this.saisie2 = 0;
		this.id = 0;
		this.setUpAndDisplay(text);
	}

	private void setUpAndDisplay(String text) {
		MyBorder arcborder = new MyBorder();
		MyPanel mp = new MyPanel(text);
		Box b = new Box(BoxLayout.Y_AXIS);
		Box b2 = new Box(BoxLayout.X_AXIS);
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		jp2.setPreferredSize(new Dimension(420, 12));
		jp3.setPreferredSize(new Dimension(420, 12));
		MyButton btnv2 = new MyButton("Supprimer");
		jp1.add(btnv2);
		btnv2.addActionListener(e1 -> {
			MyTextField mtf = mp.getMtf();
			mtf.setText("");
			MySpinner ms = mp.getMs();
			ms.setModel(new SpinnerNumberModel(0, 0, null, 1));
		});
		MyButton btnv = new MyButton("OK");
		jp1.add(btnv);
		btnv.addActionListener(e -> {
			MyTextField mtf = mp.getMtf();
			saisie1 = mtf.MyTextFieldValue();
			MySpinner ms = mp.getMs();
			saisie2 = ms.MySpinnerValue();

		});
		b.add(mp);
		b2.add(jp2);
		b2.add(jp1);
		b.add(b2);
		this.add(jp3);
		this.add(b);
		this.setBorder(arcborder);
	}

	public String getSaisie1() {
		return saisie1;
	}

	public void setSaisie1(String saisie1) {
		this.saisie1 = saisie1;
	}

	public int getSaisie2() {
		return saisie2;
	}

	public void setSaisie2(int saisie2) {
		this.saisie2 = saisie2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
