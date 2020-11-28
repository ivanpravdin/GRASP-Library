package LIBRARY;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Class for ISBN generator object

public class ISBN_Generator {
	private static List<String> ISBNs;

	public ISBN_Generator() {
		this.ISBNs = new ArrayList<String>();
	}

	public String getISBN() {
		String ISBN_CODE;
		do {
			ISBN_CODE = "";
			Random rand = new Random();
			int sum = 0;
			for (int i = 1; i < 10; i++) {
				int n = rand.nextInt(11);
				sum += n * (11 - i);
				if (n < 10) {
					ISBN_CODE += String.valueOf(n);
				} else {
					ISBN_CODE += "X";
				}
			}
			int CheckDigit = 11 - (sum % 11);
			if (CheckDigit < 10) {
				ISBN_CODE += String.valueOf(CheckDigit);
			} else {
				ISBN_CODE += "X";
			}
		} while (this.ISBNs.contains(ISBN_CODE));
		this.ISBNs.add(ISBN_CODE);
		return ISBN_CODE;
	}

}
