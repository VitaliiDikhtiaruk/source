package lesson9;

public class DecimalRomanDecimal {
	public static String[] arrDec = { "1", "4", "5", "9", "10", "40", "50", "90", "100" };
	public static String[] arrRom = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C" };

	public static void main(String[] args) {
		System.out.println("start");
		
		for (int i = 1; i <= 100; i++) {
			System.out.println(i + "==>" + decimal2Roman(i) + "==>" + roman2Decimal(decimal2Roman(i)));
		}

	}

	public static String decimal2Roman(int x) {
		String rom = "";
		int i = arrDec.length - 1;
		if (x <= 0) {
			rom = "smth is wrong";
		}
		while (x > 0) {
			if (x >= Integer.parseInt(arrDec[i])) {
				rom = rom + arrRom[i];
				x = x - Integer.parseInt(arrDec[i]);
			} else
				i--;

		}
		return rom;
	}

	public static int roman2Decimal(String s) {
		s = s.intern() + "  ";
		int i2 = 0;
		int i = arrDec.length - 1;
		int i3 = 0;
		while (i >= 0 && i3 <= (s.length())) {
			String str = s.substring(i3, i3 + arrRom[i].length());
			if (str.equals(arrRom[i])) {
				i2 += Integer.parseInt(arrDec[i]);
				i3 += arrRom[i].length();
				if (i == 0)
					i = arrDec.length - 1;

			} else
				i--;

		}
		return i2;
	}

}
