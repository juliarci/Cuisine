import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;

public class MyBigPanel extends JPanel implements ActionListener {
	private MyPanel mp;
	private int id;
	private MyBorder arcborder;
	private Box b, b2;
	private JPanel jp1, jp2, jp3;
	private MyButton btnv2;

	public MyBigPanel(String text) {
		id = 0;
		mp = new MyPanel(text);
		arcborder = new MyBorder();
		b = new Box(BoxLayout.Y_AXIS);
		b2 = new Box(BoxLayout.X_AXIS);
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		btnv2 = new MyButton("Supprimer");
		this.setUpAndDisplay(text);
	}

	private void setUpAndDisplay(String text) {
		jp2.setPreferredSize(new Dimension(420, 12));
		jp3.setPreferredSize(new Dimension(420, 12));
		jp1.add(btnv2);
		btnv2.addActionListener(this);
		b.add(mp);
		b2.add(jp2);
		b2.add(jp1);
		b.add(b2);
		this.add(jp3);
		this.add(b);
		this.setBorder(arcborder);
	}
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if (source == btnv2) {
			MyTextField mtf = mp.getMtf();
			mtf.setText("");
			MySpinner ms = mp.getMs();
			ms.setModel(new SpinnerNumberModel(0, 0, null, 1));
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MyPanel getMp() {
		return mp;
	}

}
