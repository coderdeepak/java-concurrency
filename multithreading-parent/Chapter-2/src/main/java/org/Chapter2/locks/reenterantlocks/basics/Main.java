package org.Chapter2.locks.reenterantlocks.basics;

public class Main {

	public static void main(String[] args) {
		Task task = new Task();
		for(int i =0;i<10;i++){
			Thread t = new Thread(task,"Thread"+i);
			t.start();
		}

	}

}
