package test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;

import core.FiboNumbersGenerator;
import core.PrimeNumbersGenerator;
import core.Producer;


public class IntegrationTest implements Cloneable{
	
	private BlockingQueue<Integer> primeQueue = new LinkedBlockingQueue<Integer>();
	private BlockingQueue<Integer> fiboQueue = new LinkedBlockingQueue<Integer>();
	
	@Test
	public void testNumber1() {
		
		PrimeNumbersGenerator primeNumberGenerator = new PrimeNumbersGenerator();
		Producer primeNumberProducer = new Producer(primeQueue, primeNumberGenerator,100000);
		Thread primeThread = new Thread(primeNumberProducer);
		
		this.clone();
		
		FiboNumbersGenerator fiboNumbersGenerator = new FiboNumbersGenerator();
		Producer fiboNumberProducer = new Producer(fiboQueue,fiboNumbersGenerator,100000);
		Thread fiboThread = new Thread(fiboNumberProducer);
		
		primeThread.start();
		fiboThread.start();
		
		try {
			getIntersection();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finish");
	}

	private void getIntersection() throws InterruptedException {

		Integer prime = primeQueue.take();
		Integer fibo = fiboQueue.take();
		
		while (prime != -1 && fibo != -1 ) {
			
			if (prime.equals(fibo)) {
				System.out.println(prime);
				prime = primeQueue.take();
				fibo = fiboQueue.take();
			} else {
				if (prime < fibo) {
					prime = primeQueue.take();
				}else {
					fibo = fiboQueue.take();
				}
			}
		}
		System.out.println("Exit!");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() {
		return null;
	}
	
	
	
}