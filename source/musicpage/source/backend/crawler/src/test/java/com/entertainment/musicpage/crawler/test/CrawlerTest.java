package com.entertainment.musicpage.crawler.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.entertainment.musicpage.crawlerimplement.ChiaSeNhacCrawler;

import junit.framework.TestCase;

public class CrawlerTest extends TestCase {
	public void testGenerateLink() throws IOException {
//		String linkSrc = "http://playlist.chiasenhac.com/nhac-hot-2/thu-cuoi~yanbi-mr-t-hang-bingboong~1071071.html";
//		Document doc;
//		CrawlerDraf c = new ChiaSeNhacCrawler("");
//		doc = Jsoup.connect(linkSrc).get();
//		URL host = new URL(linkSrc);
//		Elements links = doc.select("a[href]");
//		for (Element link : links) {
//			link.attr("href", c.generateLink(link.attr("href"), host));
//			System.out.println(link.attr("href"));
//		}
	}
	
	public void testGetSongsOfPlaylist() throws IOException{
		String url = "http://playlist.chiasenhac.com/nhac-hot-2/lang-tham-yeu~miu-le~1031185.html";
		Document doc;
		doc = Jsoup.connect(url).get();
		Elements downloadLinks = doc.select("div.playlist_prv.page-dsms a[href~=chiasenhac([a-z\\/\\.])*download\\.php]");
		System.out.println("title ".concat(doc.title()));
		for (Element l : downloadLinks  ) {
			System.out.println(l.absUrl("href") + " - " + l.attr("title"));
		}	
		
	}
	
	public void testAllowPlayListLink() throws IOException{
		String url = "http://chiasenhac.com";
		Document doc;
		doc = Jsoup.connect(url).get();
		
		ChiaSeNhacCrawler crawler = new ChiaSeNhacCrawler(url);
		Elements links =  doc.select(crawler.getSelector());
		for (Element l : links ) {
			
		}
	}
}
