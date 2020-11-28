package LIBRARY;

// Class for date object

public class Date extends java.util.Calendar {
	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return this.day;
	}

	public int getMonth() {
		return this.month;
	}

	public int getYear() {
		return this.year;
	}

	public static int compareDates(Date date_1, Date date_2) {
		if (date_1 == null || date_2 == null) {
			return -2;
		}
		int compared = 0;
		if (date_1.getYear() * 360 + date_1.getMonth() * 30 + date_1.getDay() + 30 < date_2.getYear() * 360
				+ date_2.getMonth() * 30 + date_2.getDay()) {
			compared = 1;
		} else if (date_1.getYear() * 360 + date_1.getMonth() * 30 + date_1.getDay() + 30 > date_2.getYear() * 360
				+ date_2.getMonth() * 30 + date_2.getDay()) {
			compared = -1;
		}
		return compared;
	}

	@Override
	protected void computeTime() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void computeFields() {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(int field, int amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void roll(int field, boolean up) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMinimum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaximum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getGreatestMinimum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLeastMaximum(int field) {
		// TODO Auto-generated method stub
		return 0;
	}
}
