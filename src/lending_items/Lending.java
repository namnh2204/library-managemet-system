package lending_items;

public class Lending {
	private String bcode;
	private String rcode;
	private int state;
	public Lending(String bcode,String rcode,int state) {
		this.bcode = bcode;
		this.rcode = rcode;
		this.state = state;
	}
	public String getBcode() {
		return bcode;
	}
	public void setBcode(String bcode) {
		this.bcode = bcode;
	}
	public String getRcode() {
		return rcode;
	}
	public void setRcode(String rcode) {
		this.rcode = rcode;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

}
