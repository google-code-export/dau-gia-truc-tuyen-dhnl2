package com.entertainment.musicpage.crawlerimplement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.entertainment.musicpage.crawler.Crawler;
import com.entertainment.musicpage.dao.Song;

public class ChiaSeNhacCrawler extends Crawler {
	private final static Pattern FILTERS = Pattern
			.compile(".*(\\.(css|js|bmp|gif|jpe?g"
					+ "|png|tiff?|mid|mp2|mp3|mp4"
					+ "|wav|avi|mov|mpeg|ram|m4v|pdf"
					+ "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

	private PrintWriter writer;
	
	public ChiaSeNhacCrawler(String srcLink) {
		super(srcLink);
		try {
			writer = new PrintWriter("d:/data.txt");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void processPageFromLink(String link) {
		try {
			Document doc = Jsoup.connect(link).get();
			Elements elements = doc.select(".plt-text");
			String title = null;
			if(elements.size()>0){
				title = elements.get(0).toString();	
			}else{
				title = link.split("/")[link.split("/").length-1];
			}
			System.out.println(link +" - "+title);
			writer.println(link +" - "+title);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public boolean isAllowToScanInside(String link) {
		return !FILTERS.matcher(link).matches()
				&& link.toLowerCase().contains("chiasenhac.com");
	}

	@Override
	public String getSelector() {
		return "a[href]";
	}

	@Override
	public String getUrl(Element e) {
		return e.absUrl("href");
	}

    public static void main(String[ ]a){
        new ChiaSeNhacCrawler("http://playlist.chiasenhac.com/nhac-hot-2/thu-cuoi~yanbi-mr-t-hang-bingboong~1071071.html").start();
    }

}
