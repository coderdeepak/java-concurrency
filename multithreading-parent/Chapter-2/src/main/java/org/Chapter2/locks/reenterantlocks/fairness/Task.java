package org.Chapter2.locks.reenterantlocks.fairness;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task implements Runnable {
	
	/**
	 * By default a ReentrantLock is not fair, ie. there is no guarantee on the order that eventually lock waiting threads will acquire the lock as soon as it is released.

		On the other hand, if we specify the lock to be fair the waiting threads will acquire the released lock in a first-in-first-out basis.Thread waiting for the longest time will get CPU
	 */
	
	
	Lock lock = new ReentrantLock(true);
	@Override
	public void run() {
		System.out.println(" Thread name " + Thread.currentThread().getName() +" is waiting for the lock ");
		lock.lock();
		System.out.println(" Thread name " + Thread.currentThread().getName() +" received lock ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" Thread name " + Thread.currentThread().getName() +" about to release lock ");
		lock.unlock();
		

	}

}
