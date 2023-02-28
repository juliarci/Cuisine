import java.awt.Color;

import javax.swing.JButton;

public class MyButton extends JButton {
	private Color color;
	
	public MyButton(String text) {
		super(text);
	}

	public MyButton(String text, Color color) {
		super(text);
		this.color = color;
		this.setUpAndDisplay();
	}

	private void setUpAndDisplay() {
		this.setOpaque(true);
		this.setBorderPainted(false);
		this.setBackground(color);
	}
}
