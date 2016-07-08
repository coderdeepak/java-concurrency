package org.chapter4.executerservice.example1;

public class Task implements Runnable {

	public void run() {
		System.out.println("I m a thread, My name is " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
