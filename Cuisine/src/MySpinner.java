import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class MySpinner extends JSpinner {


	public MySpinner(SpinnerModel model) {
		super(model);
	}


	public int MySpinnerValue() {
		int value =(Integer) this.getValue();
		return value;
	}


}
