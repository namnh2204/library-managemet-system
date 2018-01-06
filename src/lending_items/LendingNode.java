package lending_items;

public class LendingNode {
	private Lending data;
	private LendingNode nextNode;
	
	public LendingNode(Lending data){
		this.data = data;
	}

	public Lending getData() {
		return data;
	}

	public void setData(Lending data) {
		this.data = data;
	}

	public LendingNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(LendingNode nextNode) {
		this.nextNode = nextNode;
	}
}
