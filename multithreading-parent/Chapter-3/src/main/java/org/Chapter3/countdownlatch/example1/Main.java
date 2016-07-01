package org.Chapter3.countdownlatch.example1;

import java.util.concurrent.CountDownLatch;

/**
 * 
 * @author Deepak.Keswani
 * CountDownLatch is a synchronization aid that allows one or more threads to wait 
 * until a set of operations being performed in other threads completes. 
 *
 */

public class Main {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);

		Waiter      waiter      = new Waiter(latch);
		Decrementer decrementer = new Decrementer(latch);

		new Thread(waiter)     .start();
		new Thread(decrementer).start();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
