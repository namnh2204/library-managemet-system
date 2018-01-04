import java.util.InputMismatchException;
import java.util.Scanner;

public class BookLMS {
	private static String bcode, title;
	private static int quantity, lended;
	private static double price;
	public static BookList bookList;
	public static Scanner sc;
	
	public static void main(String[] args) {
		
		bookList = new BookList();
		bookList.add(new Book("B03", "Morning", 12, 0, 25.1));
		bookList.add(new Book("B01", "The Noon", 10, 0, 5.2));
		bookList.add(new Book("B02", "River", 5, 0, 4.3));
		bookList.add(new Book("B05", "Physics", 7, 0, 15.4));
		bookList.add(new Book("B07", "Biology", 11, 0, 12.2));
		bookList.add(new Book("B04", "Southern", 9, 0, 5.2));
		bookList.add(new Book("B06", "Evening", 22, 0, 22.2), 2);

		
		while (true) {
			try {
				System.out
						.println("1. Book List\n2. Reader List\n3. Lending List\n4. Exit");

				sc= new Scanner(System.in);

				int result = sc.nextInt();
				if(result == 1){
					
					while (true) {
						System.out.println("Book List:");
						System.out.println("1. Input & add to the end");
						System.out.println("2. Display data");
						System.out.println("3. Search by bcode");
						System.out.println("4. Input & add to beginning");
						System.out.println("5. Add after position k");
						System.out.println("6. Delete position k");
						System.out.println("7. Back");
						try {
							int result1 = sc.nextInt();
							if (result1 == 1){
								System.out.println("--Input & add to the end--");
								//get book info from user's input
								getBookInfo();
								
								// add book to bookList
								bookList.add(new Book(bcode, title, quantity, lended, price));
								System.out.println("Book with bcode " + bcode + " is added!");
								
							} else if (result1 == 2){
								System.out.println("--Display data--");
								bookList.displayData();
							} else if (result1 == 3){
								System.out.println("--Search by bcode--");
								sc.nextLine();
								System.out.println("BCODE: ");
								String bcode = sc.nextLine();
								
								System.out.format("%-8s|%-50s|%-9s|%-8s|%-7s|%-12s|\n","Code", "Title", "Quantity", "Lended", "Price", "Value");
								System.out.println("---------------------------------------------------------------------------------------------------|");
								Book foundBook = bookList.searchByBcode(bcode);
								if (foundBook != null) {
									System.out.println(foundBook.toString());
								} else {
									System.out.println("No data found");
								}
							} else if (result1 == 4){
								System.out.println("--Input & add to beginning--");
								//get book info from user's input
								getBookInfo();
								
								// add book to bookList
								bookList.addToBeginning(new Book(bcode, title, quantity, lended, price));
								System.out.println("Book with bcode " + bcode + " is added to the beginning of the list!");
							} else if (result1 == 5){
								System.out.println("--Add after position k--");
								int k;
								//get book info from user's input
								getBookInfo();
								while (true) {
									System.out.println("Position k: ");
									try{
										k = sc.nextInt();
										break;
									} catch (InputMismatchException e) {
										System.out.println("k must be a number!");
									}
								}
								
								// add book to bookList
								bookList.add(new Book(bcode, title, quantity, lended, price), k);
								System.out.println("Book with bcode " + bcode + " is added to the position " + k + " of the list!");
							} else if (result1 == 6){
								System.out.println("--Delete position k--");

								int k;
								while (true) {
									System.out.println("Position k: ");
									try{
										k = sc.nextInt();
										break;
									} catch (InputMismatchException e) {
										System.out.println("k must be a number!");
									}
								}
								
								bookList.remove(k);
								System.out.println("Book with bcode " + bcode + " is removed to the position " + k + " of the list!");
							} else if (result1 == 7){
								break;
							}
						} catch (InputMismatchException e) {
							System.out.println("Answer must be a number!");
						}
					}
					
				} else if (result == 2){
					
				} else if (result == 3){
					
				} else if (result == 4){
					break;
				} else {
					System.out.println("Please choose in these options");
				}
			} catch (InputMismatchException e) {
				System.out.println("Answer must be a number!");
			}

		}
	}
	
	public static void getBookInfo(){
		//get bcode
		while (true){
			sc.nextLine();
			System.out.println("BCODE: ");
			bcode = sc.next();
			if (bcode.length() != 0){
				Book book = bookList.searchByBcode(bcode);
				if (book != null) {
					System.out.println("This book is exist!");
				} else {
					break;
				}
			} else {
				System.out.println("BCODE must not be empty!");
			}
		}
		
		//get title
		while (true){
			sc.nextLine();
			System.out.println("Title: ");
			title = sc.nextLine();
			if (title.length() != 0){
				break;
			} else {
				System.out.println("Title must not be empty!");
			}
		}
		
		//get quantity
		while (true){
			System.out.println("Quantity: ");
			try {
				quantity = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Quantity must be a number!");
			}
			
		}
		
		//get lended
		while (true){
			sc.nextLine();
			System.out.println("Lended: ");
			try {
				lended = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Lended must be a number!");
			}
			
		}
		
		//get price
		while (true){
			sc.nextLine();
			System.out.println("Price: ");
			try {
				price = sc.nextDouble();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Price must be a number!");
			}
			
		}
	}

}
