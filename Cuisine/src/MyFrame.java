import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
import org.json.simple.parser.ParseException;

public class MyFrame extends JFrame {
	private int height;
	private int width;
	private MyTabbedPane mytabbed;
	private JLabel label;
	private Box b, b1;
	private MyButton btn, btn1;
	MyActionListener action;

	public MyFrame() throws ParseException {
		this("Cuisine", 700, 1400, Color.orange);
	}

	public MyFrame(String title, int width, int height, Color buttonColor) throws ParseException {
		super(title);
		// Création des différents éléments graphiques
		this.width = width;
		this.height = height;
		mytabbed = new MyTabbedPane();
		label = new JLabel("Création du menu");
		btn = new MyButton("Valider mon menu");
		btn1 = new MyButton("Ajouter une nouvelle commande");
		b = new Box(BoxLayout.Y_AXIS);
		b1 = new Box(BoxLayout.X_AXIS);
		new LectureCommande("order_1683710112435.json");
		action = new MyActionListener(mytabbed);
		this.setUpAndDisplay();

	}

	private void setUpAndDisplay() throws ParseException {

		this.getContentPane().setLayout(new BorderLayout());
		label.setFont(new Font("Serif", Font.ITALIC, 25));
		b.add(label);
		b.add(mytabbed);
		// Ecoute des actions du bouton menu
		btn.addActionListener(e -> {
			action = new MyActionListener(mytabbed);
			action.actionPerformed(e);
		});
		// Ecoute des actions du bouton commande
		btn1.addActionListener(e1 -> {
			action.ControleQuantity("order_1683710112435.json");

		});
		b1.add(btn);
		b1.add(btn1);
		b.add(b1);
		this.add(b);
		this.setSize(this.width, this.height);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Gestion de la fermeture de la fenetre
		this.setVisible(true);
	}

}