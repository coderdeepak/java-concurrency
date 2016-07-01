package org.Chapter3.semaphore.example1;

import java.util.concurrent.Semaphore;

public class Task implements Runnable {
	
	private Semaphore semaphore = new Semaphore(2);
	public void run() {
		System.out.println("Thread " + Thread.currentThread().getName() + " is inside run method");
		try {
			semaphore.acquire();
			System.out.println("Thread " + Thread.currentThread().getName() + " accquired semaphore");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("Thread " + Thread.currentThread().getName() + " about to release semaphore");
			semaphore.release();
		}
	}
}
