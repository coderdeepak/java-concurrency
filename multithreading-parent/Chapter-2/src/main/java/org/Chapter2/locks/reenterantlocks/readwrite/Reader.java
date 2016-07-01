package org.Chapter2.locks.reenterantlocks.readwrite;

import java.util.Random;

public class Reader implements Runnable {

	private MySharedResource<Integer, String> resource = new MySharedResource<>();
	Random random = new Random();
	public Reader(MySharedResource<Integer, String> resource){
		this.resource = resource;
	}
	
	@Override
	public void run() {
		while(true){
			int key = random.nextInt(2);
			System.out.println(" value of key-->" + key + " is " + resource.get(key));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
