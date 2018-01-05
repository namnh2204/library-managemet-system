import java.util.InputMismatchException;
import java.util.Scanner;

import lending_items.Lending;
import readers.Reader;
import readers.ReaderStack;
import books.Book;
import books.BookLinkedList;

public class BookLMS {
	private static String bcode, title, rcode, name;
	private static int quantity, lended, byear, state;
	private static double price;
	public static BookLinkedList bookList;
	public static ReaderStack readerList;
	public static Scanner sc;
	
	public static void main(String[] args) {
		
		bookList = new BookLinkedList();
		bookList.add(new Book("B03", "Morning", 12, 0, 25.1));
		bookList.add(new Book("B01", "The Noon", 10, 0, 5.2));
		bookList.add(new Book("B02", "River", 5, 0, 4.3));
		bookList.add(new Book("B05", "Physics", 7, 0, 15.4));
		bookList.add(new Book("B07", "Biology", 11, 0, 12.2));
		bookList.add(new Book("B04", "Southern", 9, 0, 5.2));
		bookList.add(new Book("B06", "Evening", 22, 0, 22.2), 2);
		
		readerList = new ReaderStack();
		readerList.push(new Reader("R03", "Hoa", 1902));
		readerList.push(new Reader("R01", "La", 1901));
		readerList.push(new Reader("R02", "Cay", 1903));
		readerList.push(new Reader("R05", "Canh", 1910));

		
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
								
								System.out.println("----------------------------------------------------------------------------------------------------");
								System.out.format("%-8s|%-50s|%-9s|%-8s|%-7s|%-12s|\n","Code", "Title", "Quantity", "Lended", "Price", "Value");
								System.out.println("--------+--------------------------------------------------+---------+--------+-------+------------|");
								Book foundBook = bookList.searchByBcode(bcode);
								if (foundBook != null) {
									System.out.println(foundBook.toString());
								} else {
									System.out.println("No data found");
								}
								System.out.println("----------------------------------------------------------------------------------------------------");
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
								
								// remove book in position k
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
					while (true) {
						System.out.println("Reader list:");
						System.out.println("1. Add reader");
						System.out.println("2. Display data");
						System.out.println("3. Search by rcode");
						System.out.println("4. Delete by rcode");
						System.out.println("5. Back");
						
						try {
							int result1 = sc.nextInt();
							if (result1 == 1){
								System.out.println("--Add reader--");
								
								// get rcode, name and byear
								getReaderInfo();
								
								//push new reader to stack
								readerList.push(new Reader(rcode, name, byear));
								System.out.println("Reader with rcode " + rcode + " is added!");
								
							} else if (result1 == 2){
								System.out.println("--Display data--");
								readerList.displayData();
							} else if (result1 == 3){
								System.out.println("--Search by rcode--");
								sc.nextLine();
								System.out.println("RCODE: ");
								rcode = sc.nextLine();
								
								// header of table
								System.out.println("-----------------------------------------------");
								System.out.format("%-8s|%-30s|%-6s|\n","RCode", "Name", "BYear");
								System.out.println("--------+------------------------------+------|");
								
								// search by rcode
								Reader foundReader = readerList.search(rcode);
								if (foundReader != null) {
									System.out.println(foundReader.toString());
								} else {
									System.out.println("No data found");
								}
								
								System.out.println("-----------------------------------------------");
								
							} else if (result1 == 4){
								System.out.println("--Delete by rcode--");
								while (true) {
									sc.nextLine();
									System.out.println("Rcode: ");
									rcode = sc.nextLine();
									if (rcode.length() != 0){
										Reader reader = readerList.search(rcode);
										if (reader == null) {
											System.out.println("Reader is not found!");
										} else {
											break;
										}
									} else {
										System.out.println("RCODE must not be empty!");
									}
								}
								
								readerList.remove(rcode);
								System.out.println("Reader with rcode " + rcode + " is removed!");
							} else if (result1 == 5){
								break;
							}
						} catch (InputMismatchException e) {
							System.out.println("Answer must be a number!");
						}
					}
				} else if (result == 3){
					/*while (true){
						System.out.println("Lending list: ");
						System.out.println("1. Input data");
						System.out.println("2. Display data");
						
						try {
							int result1 = sc.nextInt();
							if (result1 == 1){
								System.out.println("--Input data--");
								
								// get bcode, rcode, name and status
								getLendingInfo();
								
								//push new reader to stack
								lendingList.push(new Lending(bcode, rcode, state));
								System.out.println("Lending with Bcode: " + bcode + ", Rcode: " + rcode + " is added!");
								
							} else if (result1 == 2){
								System.out.println("--Display data--");
								lendingList.displayData();
							}
						} catch (InputMismatchException e) {
							System.out.println("Answer must be a number!");
						}
					}*/
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
		//get bcode, bcode must not be empty
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
		
		//get title, title must not be empty
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
		
		//get quantity - number verified
		while (true){
			System.out.println("Quantity: ");
			try {
				quantity = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Quantity must be a number!");
			}
			
		}
		
		//get lended - number verified, lended < quantity
		while (true){
			sc.nextLine();
			System.out.println("Lended: ");
			try {
				lended = sc.nextInt();
				if(lended > quantity){
					System.out.println("Lended must be less than quantity!");
				} else {
					break;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Lended must be a number!");
			}
			
		}
		
		//get price - number verified
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
	
	public static void getReaderInfo(){
		//get rcode, rcode must not be empty
		while (true){
			sc.nextLine();
			System.out.println("RCODE: ");
			rcode = sc.next();
			if (rcode.length() != 0){
				Reader reader = readerList.search(rcode);
				if (reader != null) {
					System.out.println("This reader is exist!");
				} else {
					break;
				}
			} else {
				System.out.println("RCODE must not be empty!");
			}
		}
		
		//get name, name must not be empty
		while (true){
			sc.nextLine();
			System.out.println("Name: ");
			name = sc.nextLine();
			if (name.length() != 0){
				break;
			} else {
				System.out.println("Name must not be empty!");
			}
		}
		
		//get byear, between 1990 and 2010
		while (true){
			System.out.println("BYear: ");
			try {
				byear = sc.nextInt();
				if(byear > 2010 || byear < 1900) {
					System.out.println("BYear mus be between 1900 and 2010");
				} else {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("BYear must be a number!");
			}
			
		}
	}
	
	public static void getLendingInfo(){
		
	}

}
