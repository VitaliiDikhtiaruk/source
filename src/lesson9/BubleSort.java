package lesson9;

public class BubleSort {

	public static void main(String[] args) {
		int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 121, 1};
		
		bubleSort(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	static int[] bubleSort(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {

				if (arr[j] > arr[j + 1]) {
					int a = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = a;
				}
			}
		}

		return arr;
	}

}
