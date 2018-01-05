package books;
public class BookLinkedList {
	private Node head;
	
	public void displayData(){
		Node current = this.head;
		
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.format("%-8s|%-50s|%-9s|%-8s|%-7s|%-12s|\n","Code", "Title", "Quantity", "Lended", "Price", "Value");
		System.out.println("--------+--------------------------------------------------+---------+--------+-------+------------|");
		if(current == null){
			System.out.println("No data found!");
		}
		while (current != null) {
			System.out.println(current.getBook().toString());
			current = current.getNextNode();
		}
		System.out.println("----------------------------------------------------------------------------------------------------");
	}
	
	public Book searchByBcode(String bcode) {
		Node current = this.head;
		while (current != null) {
			if(current.getBook().getBcode().equalsIgnoreCase(bcode)){
				return current.getBook();
			} else {
				current = current.getNextNode();
			}
		}
		
		return null;
	}

	public void addToBeginning(Book book) {
		Node newNode = new Node(book);
		newNode.setNextNode(this.head);
		this.head = newNode;

	}

	// add book to the end of the book list
	public void add(Book book) {
		Node current = this.head;
		Node newNode = new Node(book);
		if(current != null){
			while (current.getNextNode() != null) {
				current = current.getNextNode();
			}
			current.setNextNode(newNode);
		} else {
			this.head = newNode;
		}
	}

	public void add(Book book, int position) {
		int currentPosition = 0;

		Node current = this.head;
		Node newNode = new Node(book);

		while (current != null && currentPosition < position) {
			current = current.getNextNode();
			currentPosition++;
		}

		// current now at k position
		// set next node of newNode to k+2 position's Node
		newNode.setNextNode(current.getNextNode());

		// set next node of current node to newNode (at position k+1)
		current.setNextNode(newNode);
	}

	public void remove(int position) {
		int currentPosition = 0;

		Node current = this.head;

		while (current != null && currentPosition < position - 1) {
			current = current.getNextNode();
			currentPosition++;
		}
		
		if (currentPosition != 0) {
			// current now at k-1 position
			// set next node of newNode to k+1 position's Node
			current.setNextNode(current.getNextNode().getNextNode());
		} else {
			this.head = current.getNextNode();
		}
	}

}
