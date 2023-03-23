import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MyActionListener implements ActionListener {
	MyTabbedPane mytabbed;

	public MyActionListener(MyTabbedPane mytabbed) {
		this.mytabbed = mytabbed;
	}

	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();

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
				MySpinner ms1 = mytabbed.mfpD.getMs();
				if (ms1.MySpinnerValue() == 3) {
					MyGridLayout mg1 = mytabbed.getMfpD().getMgl();
					MyBigPanel[] mbp1 = mytabbed.getMfpD().getMgl().getMbp();
					System.out.println(mg1.getLigne());
					for (int i2 = 0; i2 < mg1.getLigne(); i2++) {
						list3.add(mbp1[i2].getMp().getSaisie1());
						list3.add(mbp1[i2].getMp().getSaisie2());
						list3.add(mbp1[i2].getId());
					}
				} else {
					MyGridLayout mg1 = mytabbed.getMfpD().getMgl1();
					MyBigPanel[] mbp1 = mytabbed.getMfpD().getMgl1().getMbp();
					System.out.println(mg1.getLigne());
					for (int i2 = 0; i2 < mg1.getLigne(); i2++) {
						list3.add(mbp1[i2].getMp().getSaisie1());
						list3.add(mbp1[i2].getMp().getSaisie2());
						list3.add(mbp1[i2].getId());
					}
				}
			}
			menu.put("Entrées", list1);
			menu.put("Plats", list2);
			menu.put("Desserts", list3);
		}
		try (FileWriter file = new FileWriter("menu.json")) {
			file.write(menu.toJSONString());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		System.out.print(menu);

	}
}
