import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MyActionListener implements ActionListener {
	MyTabbedPane mytabbed;
	private ArrayList<valmenu> entrem, platsm, dessertsm;

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
			entrem = new ArrayList<valmenu>();
			platsm = new ArrayList<valmenu>();
			dessertsm = new ArrayList<valmenu>();

			if (mytabbed.getSelectedIndex() == 0) {
				MySpinner ms = mytabbed.mfpE.getMs();
				if (ms.MySpinnerValue() == 3) {
					MyGridLayout mg = mytabbed.getMfpE().getMgl();
					MyBigPanel[] mbp = mytabbed.getMfpE().getMgl().getMbp();
					for (int i2 = 0; i2 < mg.getLigne(); i2++) {
						JSONObject starters = new JSONObject();
						starters.put("qty", mbp[i2].getMp().getSaisie2());
						starters.put("description", mbp[i2].getMp().getSaisie1());
						starters.put("id", mbp[i2].getId());
						list1.add(starters);
						int idint = mbp[i2].getId();
						long id = idint;
						valmenu val = new valmenu(id, mbp[i2].getMp().getSaisie1(), mbp[i2].getMp().getSaisie2());
						entrem.add(val);
					}
				} else {
					MyGridLayout mg = mytabbed.getMfpE().getMgl1();
					MyBigPanel[] mbp = mytabbed.getMfpE().getMgl1().getMbp();
					for (int i2 = 0; i2 < mg.getLigne(); i2++) {
						JSONObject starters = new JSONObject();
						starters.put("qty", mbp[i2].getMp().getSaisie2());
						starters.put("description", mbp[i2].getMp().getSaisie1());
						starters.put("id", mbp[i2].getId());
						list1.add(starters);
						int idint = mbp[i2].getId();
						long id = idint;
						valmenu val = new valmenu(id, mbp[i2].getMp().getSaisie1(), mbp[i2].getMp().getSaisie2());
						entrem.add(val);
					}
				}
			}

			if (mytabbed.getSelectedIndex() == 1) {
				MyGridLayout mg = mytabbed.getMfpP().getMgl();
				MyBigPanel[] mbp = mytabbed.getMfpP().getMgl().getMbp();
				for (int i2 = 0; i2 < mg.getLigne(); i2++) {
					JSONObject main_courses = new JSONObject();
					main_courses.put("qty", mbp[i2].getMp().getSaisie2());
					main_courses.put("description", mbp[i2].getMp().getSaisie1());
					main_courses.put("id", mbp[i2].getId());
					list2.add(main_courses);
					int idint = mbp[i2].getId();
					long id = idint;
					valmenu val = new valmenu(id, mbp[i2].getMp().getSaisie1(), mbp[i2].getMp().getSaisie2());
					platsm.add(val);
				}
			}
			if (mytabbed.getSelectedIndex() == 2) {
				MySpinner ms1 = mytabbed.mfpD.getMs();
				if (ms1.MySpinnerValue() == 3) {
					MyGridLayout mg1 = mytabbed.getMfpD().getMgl();
					MyBigPanel[] mbp1 = mytabbed.getMfpD().getMgl().getMbp();
					for (int i2 = 0; i2 < mg1.getLigne(); i2++) {
						JSONObject desserts = new JSONObject();
						desserts.put("qty", mbp1[i2].getMp().getSaisie2());
						desserts.put("description", mbp1[i2].getMp().getSaisie1());
						desserts.put("id", mbp1[i2].getId());
						list3.add(desserts);
						int idint = mbp1[i2].getId();
						long id = idint;
						valmenu val = new valmenu(id, mbp1[i2].getMp().getSaisie1(), mbp1[i2].getMp().getSaisie2());
						dessertsm.add(val);

					}
				} else {
					MyGridLayout mg1 = mytabbed.getMfpD().getMgl1();
					MyBigPanel[] mbp1 = mytabbed.getMfpD().getMgl1().getMbp();
					for (int i2 = 0; i2 < mg1.getLigne(); i2++) {
						JSONObject desserts = new JSONObject();
						desserts.put("qty", mbp1[i2].getMp().getSaisie2());
						desserts.put("description", mbp1[i2].getMp().getSaisie1());
						desserts.put("id", mbp1[i2].getId());
						list3.add(desserts);
						int idint = mbp1[i2].getId();
						long id = idint;
						valmenu val = new valmenu(id, mbp1[i2].getMp().getSaisie1(), mbp1[i2].getMp().getSaisie2());
						dessertsm.add(val);
					}
				}
			}
			menu.put("starters", list1);
			menu.put("main_courses", list2);
			menu.put("desserts", list3);
		}
		try (FileWriter file = new FileWriter("menu.json")) {
			file.write(menu.toJSONString());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		System.out.print(menu);
	}

	public void ControleQuantity(String filename) {
		LectureCommande cde = new LectureCommande(filename);

		for (valmenu val : entrem) {
			for (valmenu val2 : cde.getEntreq()) {
				if (val.getId() == val2.getId()) {
					int qty = (val.getQty() - val2.getQty());
					val.setQty(qty);
					if (qty < 0) {
						throw new ArithmeticException("Il ne reste pas suffisamment d'entrée : " + val.getDesc()
								+ " pour réaliser la commande numéro : " + cde.getIdcom());
					} else {
						System.out.println("Il reste " + val.getQty() + " de " + val.getDesc());
					}
				}
			}
		}
		for (valmenu val : platsm) {
			for (valmenu val2 : cde.getPlatsq())
				if (val.getId() == val2.getId()) {
					int qty = (val.getQty() - val2.getQty());
					val.setQty(qty);
					if (qty < 0) {
						throw new ArithmeticException("Il ne reste pas suffisamment de plat : " + val.getDesc()
								+ " pour réaliser la commande numéro : " + cde.getIdcom());
					} else {
						System.out.println("Il reste " + val.getQty() + " de " + val.getDesc());
					}
				}
		}
		for (valmenu val : dessertsm) {
			for (valmenu val2 : cde.getDessertsq())
				if (val.getId() == val2.getId()) {
					int qty = (val.getQty() - val2.getQty());
					val.setQty(qty);
					if (qty < 0) {
						throw new ArithmeticException("Il ne reste pas suffisamment de desserts : " + val.getDesc()
								+ " pour réaliser la commande numéro : " + cde.getIdcom());
					} else {
						System.out.println("Il reste " + val.getQty() + " de " + val.getDesc());
					}
				}
		}
	}
}
