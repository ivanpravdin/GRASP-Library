package LIBRARY;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Class for ID generator

public class ID_Generator {
	private static List<Integer> IDs;

	public ID_Generator() {
		this.IDs = new ArrayList<Integer>();
	}

	public int getId() {
		int id;
		do {
			Random random = new Random();
			id = random.nextInt((int) Math.pow(2, 32));
		} while (this.IDs.contains(id));
		return id;
	}
}
