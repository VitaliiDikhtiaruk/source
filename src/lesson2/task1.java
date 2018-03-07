package lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task1 {
	public static void main(String[] args) throws IOException, IndexOutOfBoundsException {
		
		System.out.println("¬ведите число");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		int i = 0;
		while (i < s.length()) {
			char b = s.charAt(i++);
			System.out.println(b);
		}
		
	}

}
