package zad3;

import java.util.TreeMap;

public class LiczbaRzymska {

	private int liczba;

	public int getLiczba() {
		return liczba;
	}

	public LiczbaRzymska(int x) {
		this.liczba = x;
	}

	private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

	static {
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
	}

	public final static String toString(int liczba) {
		if (liczba < 1 || liczba > 3999) {
			throw new IllegalArgumentException(
					"Value of Roman Numeral must be positive and must be not higher than 3999");
		}
		int chosenKey = map.floorKey(liczba);
		if (chosenKey == liczba) {
			return map.get(chosenKey);
		}
		return map.get(chosenKey) + toString(liczba - chosenKey);
	}

}
