package org.join.example1;

public class MyTask implements Runnable {

	public void run() {
		System.out.println("Thread started:::"+ Thread.currentThread().getName());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread ended:::" + Thread.currentThread().getName());

	}

}
