package LIBRARY;

// Class for reader object

public class Reader {
	private String name;
	private String email;
	private int id;

	public Reader(String name, String email, int id) {
		this.name = name;
		this.email = email;
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public int getId() {
		return this.id;
	}
}
