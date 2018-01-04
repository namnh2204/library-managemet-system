
public class Reader {
	private String rcode;
	private String name;
	private int byear;
	
	public Reader(String rcode, String name, int byear){
		this.rcode = rcode;
		this.name = name;
		this.byear = byear;
	}

	public String getRcode() {
		return rcode;
	}

	public void setRcode(String rcode) {
		this.rcode = rcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getByear() {
		return byear;
	}

	public void setByear(int byear) {
		this.byear = byear;
	}
}
