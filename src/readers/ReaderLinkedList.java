package readers;

public class ReaderLinkedList {
	private ReaderNode head;
	
	public void insertAtHead(Reader reader){
		ReaderNode newNode = new ReaderNode(reader);
		newNode.setNextNode(this.head);
		this.head = newNode;
	}
	
	public Reader removeFirst(){
		ReaderNode current = this.head;
		this.head = current.getNextNode();
		return current.getReader();
	}
	
	public Reader getHead(){
		return this.head.getReader();
	}
	
	public Reader searchByRcode(String rcode){
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
	
	public void deleteByRcode(String rcode){
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
	
	}
	
	public void displayData(){
		ReaderNode current = this.head;
		
		System.out.format("%-8s|%-30s|%-6s|\n","RCode", "Name", "BYear");
		System.out.println("--------+------------------------------+------|");
		if(current == null){
			System.out.println("No data found!");
		}
		
		while (current != null) {
			System.out.println(current.getReader().toString());
			current = current.getNextNode();
		}
	}
}
