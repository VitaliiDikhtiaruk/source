package lesson13;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelSearch {
	
	public static void main(String[] args) {
		//filling the array witn random ints and get time of it
		Instant arrBefore = Instant.now();
		int[][] arr = new int[4][10000];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10000; j++) {
				arr[i][j] = (int) (Math.random() * 1000);
			}
		}
		Instant arrAfter = Instant.now();
		System.out.println("filling the array " + Duration.between(arrBefore, arrAfter));
		int max = multiThreaMmax(arr, 4);	// get max from the arr in 4 threads
		Instant multiThreadsEnd = Instant.now();
		System.out.println("array max " + max);
		System.out.println("getting max in 4 threads " +Duration.between(arrAfter, multiThreadsEnd));
		Instant oneThred = Instant.now();
		int max2 = regMax(arr);				// get max from arr in 1 thread
		Instant oneThred2 = Instant.now();
		System.out.println("getting max in 1 thread " + Duration.between(oneThred, oneThred2));
		System.out.println("array max2 " + max2);
	}
	static int regMax(int[][] arr) {
		int maxArr = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			int[] subarr = arr[i];
			for(int j = 0; j < subarr.length; j++) {
				if (subarr[j] > maxArr) {
					maxArr = subarr[j];
				}
			}
		}
		return maxArr;
	}
	static int multiThreaMmax(int[][] arr, int threadNum) {
	
		ExecutorService executor = Executors.newFixedThreadPool(threadNum);
		try {

		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			final int[] subarr = arr[i];

			list.add(executor.submit(new Callable<Integer>() {
				public Integer call() throws InterruptedException {
					int max = Integer.MIN_VALUE;
					for (int j = 0; j < subarr.length; j++) {
						if (subarr[j] > max) {
							max = subarr[j];
							Thread.currentThread().sleep(1);
							}
					}
					return max;					
				}
			}));
		}
		int max = Integer.MIN_VALUE;
		for(Future<Integer> future : list) {
			int threadMax = future.get();
			if (threadMax > max) {
				max = threadMax;
			}
		}
		return max;
	} catch (Exception e){
		System.out.println(e);
		return -1;
	} finally {
		executor.shutdown();
	}
	
}
}