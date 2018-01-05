package readers;

public class ReaderStack {
	public int top;
	public ReaderLinkedList stackLinkedList;

	public ReaderStack() {
		stackLinkedList = new ReaderLinkedList();
		top = -1;
	}

	public void push(Reader newReader) {
		stackLinkedList.insertAtHead(newReader);
		top++;
	}

	public Reader pop() {
		top--;
		return stackLinkedList.removeFirst();
	}

	public Reader peek() {
		return stackLinkedList.getHead();
	}
	
	public Reader search(String rcode){
		return stackLinkedList.searchByRcode(rcode);
	}
	
	public void remove(String rcode){
		stackLinkedList.deleteByRcode(rcode);
		top--;
	}
	
	public void displayData(){
		stackLinkedList.displayData();
	}

	public boolean isEmpty() {
		return top == -1;
	}
}
