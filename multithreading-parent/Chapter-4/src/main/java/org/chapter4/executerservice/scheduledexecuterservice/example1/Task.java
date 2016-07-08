package org.chapter4.executerservice.scheduledexecuterservice.example1;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

	@Override
	public String call() throws Exception {
		return "Called!!";
	}

}
