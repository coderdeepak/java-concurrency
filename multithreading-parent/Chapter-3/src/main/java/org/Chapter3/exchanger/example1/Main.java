package org.Chapter3.exchanger.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {

	public static void main(String[] args) {
		Exchanger<List<String>> exchanger = new Exchanger<List<String>>();
		
		List<String> list1 = new ArrayList<String>();
		list1.add("list1");
		List<String> list2 = new ArrayList<String>();
		list2.add("list2");
		
		Task task1 = new Task(exchanger,list1);
		Task task2 = new Task(exchanger,list2);
		
		Thread t1 = new Thread(task1, "Thread1");
		Thread t2 = new Thread(task2, "Thread2");
		t1.start();
		t2.start();
	}

}
