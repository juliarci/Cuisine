import javax.swing.JTextField;

public class MyTextField extends JTextField {

	public MyTextField(int nbrCara) {
		super(nbrCara);
	}

	public MyTextField() {
		this(35);
	}
}
