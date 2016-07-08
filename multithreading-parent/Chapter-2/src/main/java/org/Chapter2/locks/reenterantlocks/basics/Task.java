package org.Chapter2.locks.reenterantlocks.basics;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task implements Runnable {
	
	private int count;
	Lock lock = new ReentrantLock();
	
	public void run() {
		System.out.println("Thread "+ Thread.currentThread().getName() +" is being executed");
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lock.lock();
		// critical section
		System.out.println("Thread "+ Thread.currentThread().getName() + " is inside critical section");
		count = count + 1;
		System.out.println(count);
		System.out.println("Thread "+ Thread.currentThread().getName() + " is about to unlock");
		lock.unlock();
		System.out.println("Thread "+ Thread.currentThread().getName() +" execution over");
	}
}
