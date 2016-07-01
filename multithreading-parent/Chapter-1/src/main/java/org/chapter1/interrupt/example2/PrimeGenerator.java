package org.chapter1.interrupt.example2;

/**
 *  This class generates prime numbers until is interrumped
 */
public class PrimeGenerator extends Thread{

	/**
	 *  Central method of the class
	 */
	@Override
	public void run() {
		long number=1L;
		
		// This bucle never ends... until is interrupted
		boolean flag = true;
		while (flag) {
			
			try{
				if (isPrime(number)) {
					System.out.printf("Number %d is Prime\n",number);
				}
				Thread.sleep(1000);
				// When is interrupted, write a message and ends
				
				number++;
			}catch(InterruptedException e){
				System.out.println("THread interuppted");
				flag=false;
			}
			
		}
	}

	/**
	 *  Method that calculate if a number is prime or not
	 * @param number : The number
	 * @return A boolean value. True if the number is prime, false if not.
	 */
	private boolean isPrime(long number) {
		if (number <=2) {
			return true;
		}
		for (long i=2; i<number; i++){
			if ((number % i)==0) {
				return false;
			}
		}
		return true;
	}

}
