package org.chapter4.executerservice.callable.example1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	private static ExecutorService executorService = Executors
			.newFixedThreadPool(10);

	public static void main(String[] args) {
		//submitATask();
		//invokeAnyTask();
		invokeAllTask();
		executorService.shutdown();
		

	}

	private static void submitATask() {
		// Create a task that implements Callable
		Task task = new Task();
		// executorService assign one of its worker thread to a execute the
		// task.
		Future future = executorService.submit(task);
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void invokeAnyTask() {
		// Create a list of tasks that implements Callable
		Set<Task> tasksSet = new HashSet<>();
		for (int i = 0; i < 10; i++) {
			tasksSet.add(new Task());
		}
		/**
		 *  executorService assign one of its worker thread to a execute any on the task from set.
		 *  There is no guarantee which task it will pick up to execute.  
		 **/
		try {
			
			//Invoking this method does not return a Future, but returns the result of one of the Callable objects; In this case return type is Integer
			Integer returnVal = executorService.invokeAny(tasksSet);
			System.out.println(returnVal);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void invokeAllTask() {
		// Create a list of tasks that implements Callable
		Set<Task> tasksSet = new HashSet<>();
		for (int i = 0; i < 10; i++) {
			tasksSet.add(new Task());
		}
		/**
		 *  executorService assign one of its worker thread to a execute any on the task from set.
		 *  There is no guarantee which task it will pick up to execute.  
		 **/
		try {
			
			//Invoking this method does not return a Future, but returns the result of one of the Callable objects; In this case return type is Integer
			List<Future<Integer>> futureList = executorService.invokeAll(tasksSet);
			for(Future<Integer> future:futureList){
				System.out.println(future.get());
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
