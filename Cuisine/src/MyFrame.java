import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		Box b = new Box(BoxLayout.Y_AXIS);
		MyTabbedPane mtp1 = new MyTabbedPane();
		JLabel label = new JLabel("Création du menu");
		label.setFont(new Font("Serif", Font.BOLD,25));
		b.add(label);
		b.add(mtp1);
		MyButton btn=new MyButton("Valider mon menu");
		btn.addActionListener(e -> {
			
		});
		b.add(btn);
		this.add(b);
		this.setSize(this.width, this.height);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}