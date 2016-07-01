package org.Chapter3.exchanger.example1;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Task implements Runnable {

	List<String> myList=null;
	Exchanger<List<String>> exchanger;
	public Task(Exchanger<List<String>> exchenger, List<String> myList){
		myList=myList;
	}
	
	public void run() {
		try {
			System.out.println(" List received by thread " + Thread.currentThread().getName() + myList.get(0));
			List<String> otherList = this.exchanger.exchange(myList);
			System.out.println(" List received by thread " + Thread.currentThread().getName() + "after exchange is " +  otherList.get(0));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
