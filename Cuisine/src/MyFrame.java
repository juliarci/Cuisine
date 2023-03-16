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

public class MyFrame extends JFrame implements ActionListener {
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
		btn.addActionListener(this);
		b.add(btn);
		this.add(b);
		this.setSize(this.width, this.height);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if (source == btn) {

			JSONObject menu = new JSONObject();

			JSONArray list1 = new JSONArray();
			JSONArray list2 = new JSONArray();
			JSONArray list3 = new JSONArray();
			for (int i = 0; i < mytabbed.getTabCount(); i++) {
				mytabbed.setSelectedIndex(i);

				if (mytabbed.getSelectedIndex() == 0) {
					MySpinner ms = mytabbed.mfpE.getMs();
					if (ms.MySpinnerValue() == 3) {
						MyGridLayout mg = mytabbed.getMfpE().getMgl();
						MyBigPanel[] mbp = mytabbed.getMfpE().getMgl().getMbp();
						System.out.println(mg.getLigne());
						for (int i2 = 0; i2 < mg.getLigne(); i2++) {
							list1.add(mbp[i2].getMp().getSaisie1());
							list1.add(mbp[i2].getMp().getSaisie2());
							list1.add(mbp[i2].getId());
						}
					} else {
						MyGridLayout mg = mytabbed.getMfpE().getMgl1();
						MyBigPanel[] mbp = mytabbed.getMfpE().getMgl1().getMbp();
						System.out.println(mg.getLigne());
						for (int i2 = 0; i2 < mg.getLigne(); i2++) {
							list1.add(mbp[i2].getMp().getSaisie1());
							list1.add(mbp[i2].getMp().getSaisie2());
							list1.add(mbp[i2].getId());
						}
					}
				}

				if (mytabbed.getSelectedIndex() == 1) {
					MyGridLayout mg = mytabbed.getMfpP().getMgl();
					MyBigPanel[] mbp = mytabbed.getMfpP().getMgl().getMbp();
					System.out.println(mg.getLigne());
					for (int i2 = 0; i2 < mg.getLigne(); i2++) {
						list2.add(mbp[i2].getMp().getSaisie1());
						list2.add(mbp[i2].getMp().getSaisie2());
						list2.add(mbp[i2].getId());
					}
				}
				if (mytabbed.getSelectedIndex() == 2) {
					MyGridLayout mg = mytabbed.getMfpD().getMgl();
					MyBigPanel[] mbp = mytabbed.getMfpD().getMgl().getMbp();
					System.out.println(mg.getLigne());
					for (int i2 = 0; i2 < mg.getLigne(); i2++) {
						list3.add(mbp[i2].getMp().getSaisie1());
						list3.add(mbp[i2].getMp().getSaisie2());
						list3.add(mbp[i2].getId());
					}
				}
				menu.put("Entrées", list1);
				menu.put("Plats", list2);
				menu.put("Desserts", list3);
			}
			try (FileWriter file = new FileWriter("//Users//Julia//Downloads//menu.json")) {
				file.write(menu.toJSONString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			System.out.print(menu);

		}

	}

}