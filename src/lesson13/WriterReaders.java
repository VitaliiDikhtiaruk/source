package lesson13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;



public class WriterReaders {
	private static final StringBuilder BUFFER = new StringBuilder();
	private static final int CYCLES = 3;
	private static final int READERS = 3;
	private static boolean stop;
	private static volatile int readersRead = READERS;
	private static ReentrantLock lock = new ReentrantLock();

	private static class Reader extends Thread {
		@Override
		public void run() {
			while (!stop) {
				if (readersRead == 0) {
					try {
						lock.lock();
						read(getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						++readersRead;
						lock.unlock();
					}
				}
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}

	}

	private static class Writer extends Thread  {
		@Override
		public void run() {
			int counter = 0;
			while (!stop) {
				try {
					while (readersRead != READERS) {
						TimeUnit.MICROSECONDS.sleep(100);
					}
					lock.lock();
				
					write();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					readersRead = 0;
					lock.unlock();
					if (++counter == CYCLES) {
						while (readersRead != READERS) {
							try {
								TimeUnit.MICROSECONDS.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						stop = true;
					}
				}
			}
				
		}
	}

	private static void read(String threadName) throws InterruptedException {
		System.out.print("reader " + threadName + ": ");
		for (int j = 0; j < BUFFER.length(); j++) {
			Thread.sleep(100);
			System.out.print(BUFFER.charAt(j));
		}
		System.out.println();
		Thread.sleep(5);
	}

	private static void write() throws InterruptedException {
		BUFFER.setLength(0);
		// write to buffer
		System.out.print("Writer writes:");

		for (int j = 0; j < 1; j++) {
			Thread.sleep(100);
			String s = "sssss";
			System.out.print(s);
			BUFFER.append(s);
		}
		System.out.println();
		Thread.sleep(5);
	}

	public static void main(String[] args) throws InterruptedException {
		Writer writer = new Writer();

		List<Thread> readers = new ArrayList<>();
		for (int j = 0; j < READERS; j++) {
			readers.add(new Reader());
		}


		Thread.sleep(10);
		for (Thread reader : readers) {
			reader.start();
		}


		Thread.sleep(10);
		writer.start();


		writer.join();
		for (Thread reader : readers) {
			reader.join();
		}
	}

}
