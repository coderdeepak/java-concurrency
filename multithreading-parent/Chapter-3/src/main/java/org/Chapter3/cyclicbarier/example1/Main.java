package org.Chapter3.cyclicbarier.example1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CyclicBarrier;

public class Main {

	public static void main(String[] args) throws Exception {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3); 
		Developer bpds = new Developer(cyclicBarrier,"order_management");
		Developer pg = new Developer(cyclicBarrier,"route_building");
		Developer monster = new Developer(cyclicBarrier,"business_validation");
		Thread bhushan = new Thread(bpds,"Bhushan");
		Thread priyanka = new Thread(pg,"Priyanka");
		Thread abhijeet = new Thread(monster,"Abhijeet");
		bhushan.start();
		Thread.sleep(1000);
		priyanka.start();
		Thread.sleep(1000);
		abhijeet.start();
		
		
		
		
		
		

	}

}
