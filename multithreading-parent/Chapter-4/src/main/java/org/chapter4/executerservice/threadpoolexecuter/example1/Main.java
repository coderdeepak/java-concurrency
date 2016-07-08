package org.chapter4.executerservice.threadpoolexecuter.example1;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor = getExecuter();
		for(int i = 0;i<10;i++){
			System.out.println("--getActive count " + threadPoolExecutor.getActiveCount());
			System.out.println("--getCompletedTaskCount" + threadPoolExecutor.getCompletedTaskCount());
			System.out.println("--getCorePoolSize " + threadPoolExecutor.getCorePoolSize());
			System.out.println("--getMaximumPoolSize " + threadPoolExecutor.getMaximumPoolSize());
			threadPoolExecutor.submit(new Task());
		}
		
	}
	private static ThreadPoolExecutor getExecuter(){ 
		int  corePoolSize  =    5;
		int  maxPoolSize   =   10;
		long keepAliveTime = 5000;
		ThreadPoolExecutor threadPoolExecutor =
		        new ThreadPoolExecutor(
		                corePoolSize,
		                maxPoolSize,
		                keepAliveTime,
		                TimeUnit.MILLISECONDS,
		                new LinkedBlockingQueue<Runnable>()
		                );
		return threadPoolExecutor;
	}
}
