package org.Chapter2.locks.reenterantlocks.fairness;

public class Main {

	public static void main(String[] args) {
		Task task = new Task();
		Thread[] tArray = new Thread[10];
		for(int i=0;i<10;i++){
			if(i%3==0){
				System.out.println("high priority thread" + i);
				Thread t = new Thread(task, "Thread"+i);
				t.setPriority(10);
				tArray[i]=t;
			}else{
				System.out.println("low priority thread" + i);
				Thread t = new Thread(task, "Thread"+i);
				t.setPriority(1);
				tArray[i]=t;
			}
		}
		
		for(Thread thread:tArray){
			thread.start();
		}
	}

}
