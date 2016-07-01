package org.Chapter2.locks.locks.condition.example1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockFactory {
	
	private static Lock lock = new ReentrantLock();
	private static Condition condition = lock.newCondition();
	public static Lock getLock(){
		return lock;
	}
	
	public static Condition getCondition(){
		return condition;
	}

}
