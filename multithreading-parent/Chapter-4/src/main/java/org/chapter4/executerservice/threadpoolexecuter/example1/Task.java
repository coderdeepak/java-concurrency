package org.chapter4.executerservice.threadpoolexecuter.example1;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task implements Callable<Integer> {

	@Override
	public Integer call() {
		System.out.println(" Thread " + Thread.currentThread().getName() + " is executing request ");
		Random random = new Random(); 
		return random.nextInt(9);
	}

}
