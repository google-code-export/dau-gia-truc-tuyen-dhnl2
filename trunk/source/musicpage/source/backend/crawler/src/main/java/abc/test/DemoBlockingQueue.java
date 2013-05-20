package abc.test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class DemoBlockingQueue {
	static LinkedBlockingQueue<String> q = new LinkedBlockingQueue <String>();
	public static void main(String[] args) throws InterruptedException  {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					q.add("helo");
			}
		}).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while(true){
			System.out.println(q.poll(1000,TimeUnit.MILLISECONDS));
		}
		
	}
}
