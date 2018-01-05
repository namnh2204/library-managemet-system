package readers;

public class ReaderNode {
	private Reader reader;
	private ReaderNode nextNode;
	
	public ReaderNode(Reader reader){
		this.reader = reader;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public ReaderNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(ReaderNode nextNode) {
		this.nextNode = nextNode;
	}
}
