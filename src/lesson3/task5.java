package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task5 {
	public static void main(String[] args) throws NumberFormatException, IOException, ArrayIndexOutOfBoundsException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("введите размеры матрицы");
		int a = Integer.parseInt(reader.readLine());
		int b = Integer.parseInt(reader.readLine());
		int[][] arr = new int[a][b];
		int[][] temp2 = new int[a][b];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int) (Math.round(Math.random() * 10));
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("поворот на 90");

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				temp2[i][arr.length - 1 - j] = arr[j][i];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(temp2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("поворот на 180");
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				temp2[i][j] = arr[a - i - 1][b - j - 1];
			}
		}
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				System.out.print(temp2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("от наповор270");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][arr.length - 1 - j] = temp2[j][i];
			}
		}
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}
}
