package lesson13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Counter implements Runnable {
	public int counter1 = 0;
	public int counter2 = 0;

	@Override
	public void run() {
		try {
			synchronized (this) {
				while (true) {
					System.out.println(counter1 + "=" + counter2);
					counter1++;
					TimeUnit.MILLISECONDS.sleep(10);
					counter2++;
					TimeUnit.MILLISECONDS.sleep(10);
				}
			}
		} catch (InterruptedException e) {
			System.out.println("interrupted thread");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		Thread t1 = new Thread(counter);
		Thread t2 = new Thread(counter);
		t1.start();
		t2.start();
		TimeUnit.MILLISECONDS.sleep(3000);
		t1.interrupt();
		t2.interrupt();

	}

}