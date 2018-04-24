package lesson13;

public class PrintName {

	public static void main(String[] args) throws InterruptedException {
		// main thread
		System.out.println(Thread.currentThread().getName());
		// 2nd thread
		Mythread1 t1 = new Mythread1();
		t1.start();
		t1.sleep(2000);
		t1.interrupt();
		// 3rd thread
		MyRunnable myrun = new MyRunnable();
		Thread thread2 = new Thread(myrun);
		thread2.start();
		thread2.sleep(2000);
		thread2.interrupt();
	}
}

class Mythread1 extends Thread {

	@Override
	public void run() {
		try {
		while (true) {
			System.out.println(getName());
			
				Thread.currentThread().sleep(500);
			}
		}catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " was interupted");
			}
		

	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		try {
		while (true) {
			System.out.println(Thread.currentThread().getName());
			
				Thread.currentThread().sleep(500);
			}
		}catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " was interupted");
			}

		
	}
}