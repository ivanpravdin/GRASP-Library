package LIBRARY;

import java.util.Calendar;

// Class for book object

public class Book {
	public String title;
	public int id;
	public String isbn;
	private boolean isBorrowed = false;
	private Reader borrower;
	private Date dateExpected;

	public Book(int id, String title, String isbn) {
		this.id = id;
		this.title = title;
		this.isbn = isbn;
	}

	// Method for borrowing a book
	public void get(Reader reader) {
		this.borrower = reader;
		this.isBorrowed = true;
		Calendar today = Date.getInstance();
		int days = today.DAY_OF_MONTH + today.MONTH * 30 + today.YEAR * 360 + 30;
		this.dateExpected = new Date((days / 360) % 30, (days % 360) / 30, days / 360);
	}

	// Method for returning a book
	public void returnBook() {
		this.borrower = null;
		this.isBorrowed = false;
		this.dateExpected = null;
	}

	public Date expected() {
		return this.dateExpected;
	}

	public Reader getBorrower() {
		return this.borrower;
	}

	public boolean getStatus() {
		return this.isBorrowed;
	}

}
