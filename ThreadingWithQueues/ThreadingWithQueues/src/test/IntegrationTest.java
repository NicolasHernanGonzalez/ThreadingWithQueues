package test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;

import core.FiboNumbersGenerator;
import core.PrimeNumbersGenerator;
import core.Producer;


public class IntegrationTest {
	
	private BlockingQueue<Integer> primeQueue = new LinkedBlockingQueue<Integer>();
	private BlockingQueue<Integer> fiboQueue = new LinkedBlockingQueue<Integer>();
	
	@Test
	public void testNumber1() {
		
		PrimeNumbersGenerator primeNumberGenerator = new PrimeNumbersGenerator();
		Producer primeNumberProducer = new Producer(primeQueue, primeNumberGenerator,100000);
		
		FiboNumbersGenerator fiboNumbersGenerator = new FiboNumbersGenerator();
		Producer fiboNumberProducer = new Producer(fiboQueue,fiboNumbersGenerator,100000);
		
		primeNumberProducer.run();
		fiboNumberProducer.run();
		
		System.out.println("Finish");
		
		
	}
}