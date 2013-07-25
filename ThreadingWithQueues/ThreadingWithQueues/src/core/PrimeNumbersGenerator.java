package core;

import java.util.Iterator;

public class PrimeNumbersGenerator implements Iterator<Integer> {

	private int next = 2;
	
	private boolean isPrime(Integer number) {
		
		if ( (number > 2 && number % 2 == 0) || number < 2) {
			return false;
		}
		
		for (long i = 3; i <= Math.sqrt(number); i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
		
	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Integer next() {
		
		Integer prime = next;
		
		next = (next == 2) ? next + 1: next+2;
		
		while(!isPrime(next)) {
			next+=2;
		}
		return prime;
	}

	@Override
	public void remove() {
	
	}
}