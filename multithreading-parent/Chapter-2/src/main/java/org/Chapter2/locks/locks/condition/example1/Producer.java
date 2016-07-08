package org.Chapter2.locks.locks.condition.example1;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {
	private final List<Integer> taskQueue;
	private final int MAX_CAPACITY;
	Lock lock = LockFactory.getLock();
	Condition condition = LockFactory.getCondition();
	public Producer(List<Integer> sharedQueue, int size) {
		this.taskQueue = sharedQueue;
		this.MAX_CAPACITY = size;
	}

	private void produce(int i) throws InterruptedException {
		lock.lock();
		while (taskQueue.size() == MAX_CAPACITY) {
			System.out.println("Queue is full "
					+ Thread.currentThread().getName() + " is waiting , size: "
					+ taskQueue.size());
			condition.await();
		}
		Thread.sleep(1000);
		taskQueue.add(i);
		System.out.println("Produced: " + i);
		condition.signalAll();
	}

	public void run() {
		int counter = 0;
		while (true) {
			try {
				produce(counter++);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

	}

}
