package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("введите параметры обоев");
		int c = Integer.parseInt(reader.readLine());
		int b = Integer.parseInt(reader.readLine());
		int a = Integer.parseInt(reader.readLine());
		String[] arr = new String[c];
		String s1 = "+";
		String s11 = new String();
		String s2 = "=";
		String s22 = new String();
		if ((a <= 0) || (b <= 0) || (c <= 0)) {
			System.out.println("значение 0 или меньше");
		} else {
			for (int i = 0; i < b; i++) {
				s11 += s1;
				s22 += s2;
			}
			String s = s11 + s22;
			for (int i = 0; i < c; i++) {
				arr[i] = s;
				for (int j = 0; j < a - 1; j++) {
					if (a == 1) {
						arr[i] = s;
					}

					arr[i] += s;

				}
			}
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		}
	}
}
