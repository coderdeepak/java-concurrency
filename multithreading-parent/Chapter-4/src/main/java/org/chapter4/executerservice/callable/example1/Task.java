package org.chapter4.executerservice.callable.example1;

import java.util.Random;
import java.util.concurrent.Callable;

public class Task implements Callable<Integer> {

	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Task is being executed by Thread " + Thread.currentThread().getName());
		Random random = new Random(); 
		return random.nextInt(9);
	}

}
