package org.chapter4.executerservice.scheduledexecuterservice.example1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Main {

	static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
	
	public static void main(String[] args) {
		Task task = new Task();
		ScheduledFuture<String> scheduledFuture =  scheduledExecutorService.schedule(task, 5, TimeUnit.SECONDS);
		try {
			System.out.println(scheduledFuture.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
