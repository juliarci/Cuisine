import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MyFrame extends JFrame {
	private int height;
	private int width;
	private Color buttonColor;
	private MyTabbedPane mytabbed;
	private JLabel label;
	private Box b;
	private MyButton btn;

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
		mytabbed = new MyTabbedPane();
		label = new JLabel("Création du menu");
		btn = new MyButton("Valider mon menu");
		b = new Box(BoxLayout.Y_AXIS);
		this.setUpAndDisplay();

	}

	private void setUpAndDisplay() {

		this.getContentPane().setLayout(new BorderLayout());
		label.setFont(new Font("Serif", Font.BOLD, 25));
		b.add(label);
		b.add(mytabbed);
		btn.addActionListener(new MyActionListener(mytabbed));
		b.add(btn);
		this.add(b);
		this.setSize(this.width, this.height);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	

}