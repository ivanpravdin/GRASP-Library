package LIBRARY;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

// Class for library object

public class Library {
	private String name;
	private List<Book> Books;
	private List<Reader> Readers;
	private Date dateToday;
	private ISBN_Generator isbnGenerator;
	private ID_Generator readersIds;
	private ID_Generator booksIds;

	public Library(String name) {
		this.Books = new ArrayList<Book>();
		this.Readers = new ArrayList<Reader>();
		this.isbnGenerator = new ISBN_Generator();
		this.readersIds = new ID_Generator();
		this.booksIds = new ID_Generator();
		this.name = name;
	}

	// Method for setting today's date from the system
	public void setTodayDate() {
		Calendar today = Date.getInstance();
		this.dateToday = new Date(today.DAY_OF_MONTH, today.MONTH, today.YEAR);
	}

	public Date getTodayDate() {
		return this.dateToday;
	}

	// Method for printing information about the book
	public void searchBook(String title) {
		boolean found = false;
		for (Book book : this.Books) {
			if (Objects.equals(book.title.toLowerCase(), title.toLowerCase())) {
				found = true;
				System.out.println("----------------------");
				System.out.println("Found a book with title: " + book.title);
				System.out.println("ID: " + String.valueOf(book.id));
				System.out.println("ISBN: " + book.isbn);
				if (book.getStatus()) {
					System.out.println("This book is borrowed by " + book.getBorrower().getName() + " ("
							+ book.getBorrower().getEmail() + ", " + String.valueOf(book.getBorrower().getId()) + ")");
				} else {
					System.out.println("This book is not borrowed");
				}
				break;
			}
		}
		if (!found) {
			System.out.println("----------------------");
			System.out.println("Book with this title is not found.");
		}
	}

	// Method for printing information about the book
	public void searchBook(int id) {
		boolean found = false;
		for (Book book : this.Books) {
			if (book.id == id) {
				found = true;
				System.out.println("----------------------");
				System.out.println("Found a book with title: " + book.title);
				System.out.println("ID: " + String.valueOf(book.id));
				System.out.println("ISBN: " + book.isbn);
				break;
			}
		}
		if (!found) {
			System.out.println("----------------------");
			System.out.println("Book with this ID is not found.");
		}
	}

	// Method for adding a reader to the library
	public int addReader(String name, String email) {
		int id = readersIds.getId();
		this.Readers.add(new Reader(name, email, id));
		return id;
	}

	// Method for adding a book to the library
	public int addBook(String title) {
		int id = booksIds.getId();
		this.Books.add(new Book(id, title, isbnGenerator.getISBN()));
		return id;
	}

	// Method for checking fines in the library
	public void checkReaders() {
		int count = 0;
		Map<Reader, List<Book>> fines = new HashMap<Reader, List<Book>>();
		for (Reader reader : this.Readers) {
			fines.put(reader, new ArrayList<Book>());
		}
		for (Book book : this.Books) {
			if (Date.compareDates(book.expected(), dateToday) == 1) {
				fines.get(book.getBorrower()).add(book);
			}
		}
		for (Reader reader : this.Readers) {
			if (fines.get(reader).size() != 0) {
				count++;
			}
		}
		System.out.println("----------------------");
		System.out.println("Found " + String.valueOf(count) + " readers.");
		for (Reader reader : this.Readers) {
			if (fines.get(reader).size() != 0) {
				System.out.println("----------------------");
				System.out.println(
						reader.getName() + " (" + reader.getEmail() + ", " + String.valueOf(reader.getId()) + "):");
				for (Book book : fines.get(reader)) {
					System.out.println(book.title + " (" + String.valueOf(book.id) + ", " + book.isbn + ").");
				}
			}
		}
	}

	public String getName() {
		return this.name;
	}

	// Method for borrowing a book from the library
	public boolean borrowBook(int book_id, int reader_id) {
		boolean success = false;
		loop: for (Book book : this.Books) {
			if (book.id == book_id) {
				if (book.getStatus()) {
					break;
				} else {
					for (Reader reader : this.Readers) {
						if (reader.getId() == reader_id) {
							book.get(reader);
							success = true;
							break loop;
						}
					}
				}
			}
		}
		return success;
	}

	// Method for returning a book to the library
	public boolean returnBook(int book_id) {
		boolean success = false;
		loop: for (Book book : this.Books) {
			if (book.id == book_id) {
				if (!book.getStatus()) {
					break;
				} else {
					book.returnBook();
					success = true;
				}
			}
		}
		return success;
	}
}
