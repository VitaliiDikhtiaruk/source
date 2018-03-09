package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("введите высоту фигуры");
		int a = Integer.parseInt(reader.readLine());
		String[] arr = new String[a];
		String s = ".";
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s;
			System.out.println(arr[i]);
			s += ".";
		}
		for (int i = arr.length - 2; i >= 0; i--) {
			System.out.println(arr[i]);
		}

	}

}
