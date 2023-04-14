
public class valmenu {
	private Long id;
	private int qty;
	private String desc;

	public valmenu(Long id, int qty) {
		super();
		this.id = id;
		this.qty = qty;
	}

	public valmenu(Long id, String desc, int qty) {
		super();
		this.desc = desc;
		this.id = id;
		this.qty = qty;
	}

	public String toString() {
		return "valmenu [id=" + id + ", qty=" + qty + ", desc=" + desc + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	

}
