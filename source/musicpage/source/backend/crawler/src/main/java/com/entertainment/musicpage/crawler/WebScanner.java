package com.entertainment.musicpage.crawler;

import java.util.concurrent.TimeUnit;

public class WebScanner implements Runnable {
	// scan all child links in currentlink and add to queue
	private Crawler crawler;
	
	public WebScanner(Crawler crawler) {
		this.crawler = crawler;
	}

	private void scan() throws InterruptedException{
		String popItem;
		while (true){
			if((popItem = crawler.toScanningQueue.poll()) == null){
				popItem = crawler.toScanningQueue.poll(10000,TimeUnit.MILLISECONDS);
			}
			
			if(popItem == null) break; // this mean scanning is complete there are not link in queue
			
			crawler.processPageFromLink(popItem);
		}
		
		System.out.println("Finish webscanner");
	}
	
	@Override
	public void run() {
		try {
			scan();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
