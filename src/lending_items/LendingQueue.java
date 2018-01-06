package lending_items;

public class LendingQueue {
	private LendingNode head, tail;
	public LendingQueue() {
		this.head = this.tail = null;
	}
	
	public boolean isEmpty(){
		return this.head == null;
	}
	
	public void enqueue(Lending newLending){
		if(isEmpty()){
			this.head = this.tail = new LendingNode(newLending);
		} else {
			this.tail.setNextNode(new LendingNode(newLending));
			this.tail = this.tail.getNextNode();
		}
	}
	
	public Lending front(){
		return this.head.getData();
	}
	
	public Lending dequeue(){
		if(isEmpty()){
			return null;
		} else{
			LendingNode node = this.head;
			this.head = node.getNextNode();
			return node.getData();
		}
	}
	
	public void displayData(){
		LendingNode current = this.head;
		System.out.println("-------------------------");
		System.out.format("%-8s|%-8s|%-7s|\n","BCode", "RCode", "State");
		System.out.println("--------+--------+-------|");
		if(current == null){
			System.out.println("No data found!");
		}
		
		while (current != null) {
			System.out.println(current.getData().toString());
			current = current.getNextNode();
		}
		
		System.out.println("-------------------------");
	}

}
