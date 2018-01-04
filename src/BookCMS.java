
public class BookCMS {

	public static void main(String[] args) {
		BookList bookList = new BookList();
		bookList.add(new Book("B03", "Morning", 12, 0, 25.1));
		bookList.add(new Book("B01", "The Noon", 10, 0, 5.2));
		bookList.add(new Book("B02", "River", 5, 0, 4.3));
		bookList.add(new Book("B05", "Physics", 7, 0, 15.4));
		bookList.add(new Book("B07", "Biology", 11, 0, 12.2));
		bookList.add(new Book("B04", "Southern", 9, 0, 5.2));
		bookList.add(new Book("B06", "Evening", 22, 0, 22.2), 2);
		
		//display books
		bookList.displayData();
		
		//search by bcode
		Book result = bookList.searchByBcode("B02");
		if(result != null){
			System.out.println(result.toString());
		} else {
			System.out.println("No data found");
		}
	}

}
