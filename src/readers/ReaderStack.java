package readers;

public class ReaderStack {
	public int top;
	private ReaderNode head;
	
	public void push(Reader reader){
		ReaderNode newNode = new ReaderNode(reader);
		newNode.setNextNode(this.head);
		this.head = newNode;
		top++;
	}
	
	public Reader pop(){
		top--;
		ReaderNode current = this.head;
		this.head = current.getNextNode();
		return current.getReader();
	}
	
	public Reader peek(){
		return this.head.getReader();
	}
	
	public Reader search(String rcode){
		ReaderNode current = this.head;
		while (current != null) {
			if(current.getReader().getRcode().equalsIgnoreCase(rcode)){
				return current.getReader();
			} else {
				current = current.getNextNode();
			}
		}
		
		return null;
	}
	
	public void remove(String rcode){
		ReaderNode current = this.head;
		
		//remove head node
		if(current.getReader().getRcode().equalsIgnoreCase(rcode)){
			this.head = current.getNextNode();
		} else {
			//remove mid node
			while (current != null) {
				ReaderNode nextNode = current.getNextNode();
				if(nextNode.getReader().getRcode().equalsIgnoreCase(rcode)){
					current.setNextNode(nextNode.getNextNode());
					break;
				} else {
					current = current.getNextNode();
				}
			}
		}
		top--;
	
	}
	
	public void displayData(){
		ReaderNode current = this.head;
		System.out.println("----------------------------------------------");
		System.out.format("%-8s|%-30s|%-6s|\n","RCode", "Name", "BYear");
		System.out.println("--------+------------------------------+------|");
		if(current == null){
			System.out.println("No data found!");
		}
		
		while (current != null) {
			System.out.println(current.getReader().toString());
			current = current.getNextNode();
		}
		
		System.out.println("----------------------------------------------"
				+ ""
				+ "");
	}
	
	public ReaderStack() {
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}
}
