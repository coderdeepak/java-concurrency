package org.Chapter3.countdownlatch.example1;

import java.util.concurrent.CountDownLatch;

public class Waiter implements Runnable {

	CountDownLatch latch = null;

	public Waiter(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		System.out.println("Inside run of Waiter");
		try {
			latch.await();
			System.out.println("Inside await");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Waiter Released");
	}
}
