package org.Chapter2.locks.reenterantlocks.readwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MySharedResource<K,V> {
	
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock readLock = lock.readLock();
	private final Lock writeLock = lock.writeLock();
	private Map<K,V> hashMap = new HashMap<>();
	
	public void put(K key, V value){
		writeLock.lock();
		System.out.println(" Inside put accquired write lock");
		try{
			hashMap.put(key, value);
		}finally{
			System.out.println("Inside put about to release write lock");
			writeLock.unlock();
		}
	}
	
	public V get(K key){
		readLock.lock();
		System.out.println(" Inside get accquired read lock");
		try{
			return hashMap.get(key);
		}finally{
			System.out.println(" Inside get about to release read lock");
			readLock.unlock();
		}
	}
	
	public V remove(K key){
		writeLock.lock();
		System.out.println(" Inside remove accquired write lock");
		try{
			return hashMap.remove(key);
		}finally{
			System.out.println("Inside remove about to release write lock");
			writeLock.unlock();
		}
	}
	
	public boolean containsKey(K key){
		readLock.lock();
		try{
		return hashMap.containsKey(key);
		}finally{
			readLock.unlock();
		}
	}


}
