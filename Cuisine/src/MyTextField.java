import javax.swing.JTextField;

public class MyTextField extends JTextField {

	public MyTextField(int nbrCara) {
		super(nbrCara);
	}

	public MyTextField() {
		this(35);
	}

	public String MyTextFieldValue() {
		String saisie = (String) this.getText();
		System.out.println(saisie);
		return saisie;
	}

	public void setMtf(MyTextField mtf) {
		mtf.setText("");
	}
}
