package lesson3;

import java.util.Random;

public class task4 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		int[] arr2 = new int[20];
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int a = random.nextInt(50);
			arr[i] = a;
			arr2[i] = arr[i];
			arr2[i + 10] = arr2[i] * 2;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
	}

}
