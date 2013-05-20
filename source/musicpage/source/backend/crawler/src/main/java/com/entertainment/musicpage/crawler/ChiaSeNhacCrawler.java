package com.entertainment.musicpage.crawler;


public class ChiaSeNhacCrawler extends Crawler {


	public ChiaSeNhacCrawler(String srcLink) {
		super(srcLink);
	}

	public void processLink(String link) {
        System.out.println(link);
	}

	public boolean isAllowToScanInside(String link) {
		return link.toLowerCase().contains("chiasenhac.com");
	}
    public static void main(String[ ]a){
        new ChiaSeNhacCrawler("http://chiasenhac.com/mp3/us-uk/u-pop/if-i-could-fly~helloween~1020922.html").start();
    }
}
