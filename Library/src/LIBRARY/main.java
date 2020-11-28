package LIBRARY;

import java.util.Scanner;

// Main class for Library System
public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Library System 1.0.0");
		System.out.println("----------------------");
		System.out.print("Please write down name for your library: ");
		boolean libraryCreated = false;
		Library mainLibrary = null;
		while (!libraryCreated) { // Creates library
			try {
				String libraryName = sc.nextLine();
				mainLibrary = new Library(libraryName);
				libraryCreated = true;
				System.out.println("----------------------");
				System.out.println("Library " + mainLibrary.getName() + " is created.");
			} catch (Exception e) {
				System.out.println("Failed to create new library. Please try again.");
			}
		}
		mainLibrary.setTodayDate();
		while (true) {
			try {
				System.out.println("----------------------");
				System.out.println("1 - Add new reader.");
				System.out.println("2 - Add new book.");
				System.out.println("3 - Borrow a book.");
				System.out.println("4 - Return a book.");
				System.out.println("5 - Check fines.");
				System.out.println("6 - Find book");
				System.out.println("0 - Exit the library system.");
				System.out.println("----------------------");
				int n = sc.nextInt();
				if (n > 6 || n < 0) {
					System.out.println("No such option, please, try again.");
				} else if (n == 0) {
					break;
				} else if (n == 1) {
					try {
						System.out.println("----------------------");
						System.out.print("Name: ");
						sc.nextLine();
						String name = sc.nextLine();
						System.out.print("Email: ");
						String email = sc.next();
						int id = mainLibrary.addReader(name, email);
						System.out.println("----------------------");
						System.out.println("New reader is successfully created. Issued ID is " + String.valueOf(id));

					} catch (Exception e) {
						System.out.println("Please try again, following error occured: " + e);
						sc.next();
					}
				} else if (n == 2) {
					try {
						System.out.println("----------------------");
						System.out.print("Title: ");
						sc.nextLine();
						String title = sc.nextLine();
						int id = mainLibrary.addBook(title);
						System.out.println("----------------------");
						System.out.println("New book is successfully created. Issued ID is " + String.valueOf(id));

					} catch (Exception e) {
						System.out.println("Please try again, following error occured: " + e);
						sc.next();
					}
				} else if (n == 3) {
					try {
						System.out.println("----------------------");
						System.out.print("Book's ID: ");
						int book_id = sc.nextInt();
						System.out.print("Reader's ID: ");
						int reader_id = sc.nextInt();
						boolean success = mainLibrary.borrowBook(book_id, reader_id);
						if (success) {
							System.out.println("----------------------");
							System.out.println("Book is successfully borrowed.");
						} else {
							System.out.println("----------------------");
							System.out.println("Book could not be borrowed. Please, try again.");
						}
					} catch (Exception e) {
						System.out.println("Please try again, following error occured: " + e);
						sc.next();
					}
				} else if (n == 4) {
					try {
						System.out.println("----------------------");
						System.out.print("Book's ID: ");
						int book_id = sc.nextInt();
						boolean success = mainLibrary.returnBook(book_id);
						if (success) {
							System.out.println("----------------------");
							System.out.println("Book is successfully returned.");
						} else {
							System.out.println("----------------------");
							System.out.println("Book could not be return. Please, try again.");
						}
					} catch (Exception e) {
						System.out.println("Please try again, following error occured: " + e);
						sc.next();
					}
				} else if (n == 5) {
					try {
						mainLibrary.checkReaders();
					} catch (Exception e) {
						System.out.println("Please try again, following error occured: " + e);
						sc.next();
					}
				} else if (n == 6) {
					try {
						System.out.println("----------------------");
						System.out.println("Find book by ID or title:");
						System.out.println("1 - ID");
						System.out.println("2 - Title");
						System.out.println("----------------------");
						int o = sc.nextInt();
						System.out.println("----------------------");
						if (o == 1) {
							System.out.print("Book's ID: ");
							int id = sc.nextInt();
							mainLibrary.searchBook(id);
						} else if (o == 2) {
							System.out.print("Book's title: ");
							sc.nextLine();
							String title = sc.nextLine();
							mainLibrary.searchBook(title);
						} else {
							System.out.println("----------------------");
							System.out.println("No such option.");
						}
					} catch (Exception e) {
						System.out.println("Please try again, following error occured: " + e);
						sc.next();
					}
				}
			} catch (Exception e) {
				System.out.println("Please try again, following error occured: " + e);
				sc.next();
			}

		}
		System.out.println("----------------------");
		System.out.println("Exiting the system.");

	}

}
