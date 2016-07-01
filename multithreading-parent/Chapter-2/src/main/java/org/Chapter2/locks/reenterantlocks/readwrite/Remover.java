package org.Chapter2.locks.reenterantlocks.readwrite;

import java.util.Random;

public class Remover implements Runnable {

	
	private MySharedResource<Integer, String> resource = new MySharedResource<>();
	Random random = new Random();

	public Remover(MySharedResource<Integer, String> resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		while(true){
			int key = random.nextInt(2);
			System.out.println(" deleted key -->" + key + " value was " + resource.remove(key));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
