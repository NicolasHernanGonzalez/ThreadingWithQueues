package core;

import java.util.concurrent.BlockingQueue;

public class ParNumbersConsumer implements Runnable{

	private BlockingQueue<Integer> myQueue;
	
	
	public ParNumbersConsumer(BlockingQueue<Integer> myQueue) {
		super();
		this.myQueue = myQueue;
	}

	@Override
	public void run() {
		
		Integer num = 0;
		
		while ((num = myQueue.peek()) != null){
			
			if ( num % 2 == 0){
				System.out.println("Par " + num);
			}
		}
		
		
	}

}
