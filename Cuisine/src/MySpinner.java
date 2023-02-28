import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class MySpinner extends JSpinner {

	static SpinnerModel model = new SpinnerNumberModel(3, 3, 4, 1);

	public MySpinner(SpinnerModel model) {
		super(model);
	}

	public MySpinner() {
		this(model);

	}
}
