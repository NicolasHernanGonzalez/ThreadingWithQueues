package core;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	private BlockingQueue<Integer> queue;
	private Iterator<Integer> iterator;
	private int limit;
	
	public Producer(BlockingQueue<Integer> queue, Iterator<Integer> iterator,int limit) {
		super();
		this.queue = queue;
		this.iterator = iterator;
		this.limit = limit;
	}

	@Override
	public void run() {
		while (iterator.hasNext()) {
			Integer number = iterator.next();
			if (number <= limit){
				queue.add(number);
			}else{
				break;
			}
		}
	}
}