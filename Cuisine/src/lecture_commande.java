import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class lecture_commande {
	private ArrayList<valmenu> idquantit, idquantit1, idquantit2;

	public lecture_commande() {

	}

	public ArrayList<valmenu> lecture_entree(String file) throws ParseException {
		idquantit = new ArrayList<valmenu>();
		JSONParser jsonP = new JSONParser();
		JSONObject jsonO = (JSONObject) jsonP.parse(file);
		int id = (int) jsonO.get("id");
		JSONArray starters = (JSONArray) jsonO.get("starters");

		Iterator<JSONObject> iteratorstart = starters.iterator();
		while (iteratorstart.hasNext()) {
			JSONObject jsonos = iteratorstart.next();
			Long id2 = (Long) jsonos.get("id");
			int qty = (int) jsonos.get("qty");
			valmenu val = new valmenu(id2, qty);
			idquantit.add(val);
		}

		return idquantit;
	}

	public ArrayList<valmenu> lecture_plat(String file) throws ParseException {
		idquantit1 = new ArrayList<valmenu>();
		JSONParser jsonP = new JSONParser();
		JSONObject jsonO = (JSONObject) jsonP.parse(file);
		int id = (int) jsonO.get("id");
		JSONArray plats = (JSONArray) jsonO.get("main_courses");

		Iterator<JSONObject> iteratorplat = plats.iterator();
		while (iteratorplat.hasNext()) {
			JSONObject jsonos = iteratorplat.next();
			Long id2 = (Long) jsonos.get("id");
			int qty = (int) jsonos.get("qty");
			valmenu val = new valmenu(id2, qty);
			idquantit1.add(val);
		}

		return idquantit1;
	}

	public ArrayList<valmenu> lecture_dessert(String file) throws ParseException {
		idquantit2 = new ArrayList<valmenu>();
		JSONParser jsonP = new JSONParser();
		JSONObject jsonO = (JSONObject) jsonP.parse(file);
		int id = (int) jsonO.get("id");
		JSONArray dessert = (JSONArray) jsonO.get("desserts");

		Iterator<JSONObject> iteratordess = dessert.iterator();
		while (iteratordess.hasNext()) {
			JSONObject jsonos = iteratordess.next();
			Long id2 = (Long) jsonos.get("id");
			int qty = (int) jsonos.get("qty");
			valmenu val = new valmenu(id2, qty);
			idquantit2.add(val);
		}

		return idquantit;
	}
}
