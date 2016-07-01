package org.Chapter2.locks.reenterantlocks.readwrite;

public class Main {

	public static void main(String[] args) {
		MySharedResource<Integer, String> myResource = new MySharedResource<Integer, String>(); 
		Writer writer = new Writer(myResource);
		Reader reader = new Reader(myResource);
		
		for(int i = 0; i< 5; i++){
			Thread writerThread = new Thread(writer);
			writerThread.start();
		}
		
		for(int j = 0; j< 5; j++){
			Thread readerThread = new Thread(reader);
			readerThread.start();
		}
		
		for(int k = 0; k< 5; k++){
			Thread readerThread = new Thread(reader);
			readerThread.start();
		}
		
		
		

	}

}
