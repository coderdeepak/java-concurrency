package org.chapter4.executerservice.example1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
	
	/* ExecutorService is created using the newFixedThreadPool() factory method. 
	* This creates a thread pool with 10 threads executing tasks.*/
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);
	private static ThreadPoolExecutor threadPoolExecutor = null;
	
	public static void main(String[] args) {
		
		//executeOneTask();
		executeBunchOfTasks();
		executorService.shutdown();
		

	}
	
	private static void executeOneTask(){
		//Create an instance of  task , which is a thread
				Task task = new Task();
		/*Instance of task in then passed to the execute() method. 
		 * This causes the Runnable to be executed by one of the threads in the ExecutorService.*/
				executorService.execute(task);
	}
	
	private static void executeBunchOfTasks(){
		for(int i=0;i<50;i++){
			executorService.execute(new Task());
		}
	}

}
