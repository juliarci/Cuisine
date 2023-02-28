import java.awt.BorderLayout;
import java.awt.GridLayout;

public class MyGridLayout extends GridLayout{

	public MyGridLayout() {
		super();
		this.setUpAndDisplay();
		}

		private void setUpAndDisplay() {
			this.add(new MyPanel());
			this.add(new MyPanel());
			this.add(new MyPanel());

	}

		private void add(MyPanel myPanel) {
			// TODO Auto-generated method stub
			
		}
	
}
