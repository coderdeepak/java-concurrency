package org.Chapter2.locks.locks.condition.example1;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable {

	private final List<Integer> taskQueue;
	Lock lock = LockFactory.getLock();
	Condition condition = LockFactory.getCondition();

	public Consumer(List<Integer> sharedQueue) {
		this.taskQueue = sharedQueue;
	}

	public void run() {
		while (true) {
			try {
				consume();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void consume() throws InterruptedException {
		lock.lock();
		while (taskQueue.isEmpty()) {
			System.out.println("Queue is empty "
					+ Thread.currentThread().getName() + " is waiting , size: "
					+ taskQueue.size());
			condition.await();
		}
		Thread.sleep(1000);
		int i = (Integer) taskQueue.remove(0);
		System.out.println("Consumed: " + i);
		condition.signalAll();

	}
}
