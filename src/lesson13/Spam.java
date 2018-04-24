package lesson13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Spam {

	public static void main(String[] args) throws InterruptedException, IOException {

		
//		part2();
		stopSpam();
			int[] times = { 1000, 2000, 3000, 3000, 4000, 5000, 1000, 2000 };
			String[] messages = { "1", "2", "3", "4", "5", "6", "7", "8" };
			if (times != null && messages != null && times.length == messages.length) {
				for (int i = 0; i < messages.length; i++) {
					System.out.println(messages[i]);
					Thread.currentThread().sleep(times[i]);
				}
			} else
				System.out.println("the array's lenght doen't match");
		
		
			
}
	static void part2() throws InterruptedException {
		
		new Thread(new Runnable() {
			public void run() {
		System.out.println("auto exit in 5 sec");
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(1);
	}
		}).start();
	}
	static void stopSpam() {
		System.out.println("press enter to stop");
		new Thread(new Runnable() {
			public void run() {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				try {

					if (reader.readLine().contains("")) {
						System.out.println("got enter, stoped spamming");
						System.exit(0);
					}
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}).start();

	}
}