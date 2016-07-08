package org.Chapter3.countdownlatch.example1;

import java.util.concurrent.CountDownLatch;

public class Decrementer implements Runnable {

	CountDownLatch latch = null;

	public Decrementer(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {

		try {
			
			Thread.sleep(1000);
			System.out.println(this.latch.getCount());
			this.latch.countDown();
			System.out.println(this.latch.getCount());

			Thread.sleep(1000);
			this.latch.countDown();
			System.out.println(this.latch.getCount());

			Thread.sleep(1000);
			System.out.println("don't confuse");
			this.latch.countDown();
			System.out.println(this.latch.getCount());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
