package core;

import java.util.Iterator;

public class FiboNumbersGenerator implements Iterator<Integer>{

	private Integer a = 0;
	private Integer b = 1;
	
	
	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Integer next() {
		Integer fibonacci = a + b;
		a = b;
		b = fibonacci;
		return fibonacci;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("not implemented");
	}

}
