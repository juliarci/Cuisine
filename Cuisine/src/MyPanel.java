import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class MyPanel extends JPanel implements ChangeListener, DocumentListener {
	private MyTextField mtf;
	private MySpinner ms;
	private String saisie1;
	private int saisie2;
	private Box b, b2;
	private JPanel jp;
	private JLabel jl1, jl2;
	private Document doc;

	public MyPanel(String text) {
		mtf = new MyTextField();
		doc = mtf.getDocument();
		SpinnerModel model = new SpinnerNumberModel(0, 0, null, 1);
		ms = new MySpinner(model);
		b = new Box(BoxLayout.Y_AXIS);
		b2 = new Box(BoxLayout.Y_AXIS);
		jp = new JPanel();
		jl1 = new JLabel(text);
		jl2 = new JLabel(" Quantité :");
		this.setUpAndDisplay(text);
	}

	private void setUpAndDisplay(String text) {
		b.setPreferredSize(new Dimension(150, 40));
		jl1.setAlignmentX(LEFT_ALIGNMENT);
		b.add(jl1);
		b2.add(mtf);
		doc.addDocumentListener(this);
		b.add(Box.createVerticalStrut(5));
		b.add(jl2);
		b2.add(ms);
		ms.addChangeListener(this);
		jp.add(b);
		jp.add(b2);
		this.add(jp);
	}

	public void stateChanged(ChangeEvent e) {
		Object source = e.getSource();
		if (source == ms)
			saisie2 = ms.MySpinnerValue(); // Récupération de la quantité

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

	@Override
	public void insertUpdate(DocumentEvent e) {
		Object source = e.getDocument();
		if (source == doc)
			saisie1 = mtf.getText(); // Récupération de la description

	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	public void changedUpdate(DocumentEvent evt) {

	}

}
