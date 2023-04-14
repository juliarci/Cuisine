import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LectureCommande {
	private ArrayList<valmenu> entreq, platsq, dessertsq;
	private String idcom;
	String file;

	public LectureCommande(String file) {
		this.file = file;
		try {
			idcom = IdCommande();
			entreq = LectureEntree();
			platsq = LecturePlat();
			dessertsq = LectureDessert();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String IdCommande() throws ParseException {
		JSONParser jsonP = new JSONParser();
		JSONObject jsonO;
		try {
			jsonO = (JSONObject) jsonP.parse(new FileReader(file));
			idcom = (String) jsonO.get("id");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return idcom;
	}

	public ArrayList<valmenu> LectureEntree() throws ParseException {
		entreq = new ArrayList<valmenu>();
		JSONParser jsonP = new JSONParser();
		JSONObject jsonO;
		try {
			jsonO = (JSONObject) jsonP.parse(new FileReader(file));

			JSONArray starters = (JSONArray) jsonO.get("starters");

			Iterator<JSONObject> iteratorstart = starters.iterator();
			while (iteratorstart.hasNext()) {
				JSONObject jsonos = iteratorstart.next();
				Long id2 = (Long) jsonos.get("id");
				int qty = ((Long) jsonos.get("qty")).intValue();
				System.out.println(id2);
				System.out.println(qty);
				valmenu val = new valmenu(id2, qty);
				entreq.add(val);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entreq;
	}

	public ArrayList<valmenu> LecturePlat() throws ParseException {
		platsq = new ArrayList<valmenu>();
		JSONParser jsonP = new JSONParser();
		JSONObject jsonO;
		try {
			jsonO = (JSONObject) jsonP.parse(new FileReader(file));

			JSONArray plats = (JSONArray) jsonO.get("main_courses");

			Iterator<JSONObject> iteratorplat = plats.iterator();
			while (iteratorplat.hasNext()) {
				JSONObject jsonos = iteratorplat.next();
				Long id2 = (Long) jsonos.get("id");
				int qty = ((Long) jsonos.get("qty")).intValue();
				System.out.println(id2);
				System.out.println(qty);
				valmenu val = new valmenu(id2, qty);
				platsq.add(val);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return platsq;
	}

	public ArrayList<valmenu> LectureDessert() throws ParseException {
		dessertsq = new ArrayList<valmenu>();
		JSONParser jsonP = new JSONParser();
		JSONObject jsonO;
		try {
			jsonO = (JSONObject) jsonP.parse(new FileReader(file));

			JSONArray dessert = (JSONArray) jsonO.get("desserts");

			Iterator<JSONObject> iteratordess = dessert.iterator();
			while (iteratordess.hasNext()) {
				JSONObject jsonos = iteratordess.next();
				Long id2 = (Long) jsonos.get("id");
				int qty = ((Long) jsonos.get("qty")).intValue();
				System.out.println(id2);
				System.out.println(qty);
				valmenu val = new valmenu(id2, qty);
				dessertsq.add(val);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dessertsq;
	}

	public ArrayList<valmenu> getEntreq() {
		return entreq;
	}

	public void setEntreq(ArrayList<valmenu> entreq) {
		this.entreq = entreq;
	}

	public ArrayList<valmenu> getPlatsq() {
		return platsq;
	}

	public void setPlatsq(ArrayList<valmenu> platsq) {
		this.platsq = platsq;
	}

	public ArrayList<valmenu> getDessertsq() {
		return dessertsq;
	}

	public void setDessertsq(ArrayList<valmenu> dessertsq) {
		this.dessertsq = dessertsq;
	}

	public String getIdcom() {
		return idcom;
	}

	public void setIdcom(String idcom) {
		this.idcom = idcom;
	}

}
