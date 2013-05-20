package com.entertainment.musicpage.crawler;


import java.util.regex.Pattern;

public class ChiaSeNhacCrawler extends Crawler {
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g"
            + "|png|tiff?|mid|mp2|mp3|mp4"
            + "|wav|avi|mov|mpeg|ram|m4v|pdf"
            + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

    public ChiaSeNhacCrawler(String srcLink) {
		super(srcLink);
	}

	public void processLink(String link) {
        System.out.println(link);
	}

	public boolean isAllowToScanInside(String link) {
		return !FILTERS.matcher(link).matches()&& link.toLowerCase().contains("chiasenhac.com");
	}

    @Override
    public String getSelector() {
        return "a[href]";
    }

    public static void main(String[ ]a){
        new ChiaSeNhacCrawler("http://playlist.chiasenhac.com/nhac-hot-2/thu-cuoi~yanbi-mr-t-hang-bingboong~1071071.html").start();
    }
}
