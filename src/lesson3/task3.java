package lesson3;

public class task3 {
	public static void main(String[] args) {
		int[] arr = new int[100];
		boolean isPrime;
		for (int i = 0; i < 100; i++) {
			arr[i] = i + 1;
			if (arr[i] <= 2)
				isPrime = false;
			else
				isPrime = true;
			for (int j = 2; j <= arr[i] / j; j++) {
				if ((arr[i] % j) == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime)
				System.out.print(arr[i] + " ");
		}

	}

}
