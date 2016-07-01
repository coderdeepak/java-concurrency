package org.Chapter3.cyclicbarier.example1;

import java.util.concurrent.CyclicBarrier;

public class Developer implements Runnable {

	private CyclicBarrier cyclicBarrier = null;
	private String taskName = null;
	public Developer(CyclicBarrier cyclicBarrier, String taskName){
		this.cyclicBarrier=cyclicBarrier;
		this.taskName = taskName;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName()+ " started " +  taskName);
		try {
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName()+ " Task " +  taskName + " is done");
			System.out.println(Thread.currentThread().getName()+ " waiting for others to complete....");
			cyclicBarrier.await();
			System.out.println("All finished there work, "+ Thread.currentThread().getName()+ " lets start integration testing");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
