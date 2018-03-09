package lesson4;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task2 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, -6, 10, -11 };
		System.out.println(maxArray(a));
		int b = 3;
		int c = 3;
		char[][] array = new char[b][c];
		square(array, b, c);
		String s = "abc ab   1 abas";
		System.out.println(wordCounter(s));

	}
	
	//сортируем и выводим максимальное значение
	
	public static int maxArray(int[] arr) {			
		Arrays.sort(arr);
		return arr[arr.length - 1];
	}
	
	//рисуем фигуру из +

	public static char[][] square(char[][] arr, int a, int b) {			

		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				arr[i][j] = '+';
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		return arr;

	}
	
	//ищем кол. слов с помощью рег. выражений

	public static int wordCounter(String s) {
		int c = 0;
		Matcher matcher = Pattern.compile("(\\s+)?\\S+(\\s*)?").matcher(s);
		while (matcher.find()) {
			c++;
		}
		return c;
	}

}
