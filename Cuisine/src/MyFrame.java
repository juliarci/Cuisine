import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
	private int height;
	private int width;
	private Color buttonColor;

	public MyFrame() {
		this("Cuisine", 700, 1400, Color.orange);
	}

	public MyFrame(String title) {
		this(title, 200, 200, Color.orange);
	}

	public MyFrame(int width, int height) {
		this("Cuisine", width, height, Color.orange);
	}

	public MyFrame(String title, int width, int height, Color buttonColor) {
		super(title);
		this.width = width;
		this.height = height;
		this.buttonColor = buttonColor;
		this.setUpAndDisplay();
	}

	private void setUpAndDisplay() {

		this.getContentPane().setLayout(new BorderLayout());
		MyTabbedPane mtp1 = new MyTabbedPane();
		MyPanel mp1 = new MyPanel();
		this.add(mtp1, BorderLayout.CENTER);

		this.setSize(this.width, this.height);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}