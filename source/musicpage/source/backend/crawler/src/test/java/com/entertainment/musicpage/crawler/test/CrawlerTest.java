package com.entertainment.musicpage.crawler.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.entertainment.musicpage.crawlerimplement.ChiaSeNhacCrawler;

import junit.framework.TestCase;

public class CrawlerTest extends TestCase {

    public void testGetSongsOfPlaylist() throws IOException{
		String url = "http://playlist.chiasenhac.com/nhac-hot-2/lang-tham-yeu~miu-le~1031185.html";
		Document doc;
		doc = Jsoup.connect(url).get();
        doc.setBaseUri(url);
		Elements downloadLinks = doc.select("div.playlist_prv.page-dsms a[href~=chiasenhac([a-z\\/\\.])*download\\.php]");
		System.out.println("title ".concat(doc.title()));
		//System.out.println("base uri ".concat(doc.select("link[rel=canonical]").get(0).absUrl("href")));
        //this tip above just work only playlist link
        System.out.println("base uri ".concat(doc.baseUri()));

		for (Element l : downloadLinks  ) {
			System.out.println(l.absUrl("href") + " - " + l.attr("title"));
		}	
		
	}

    public void testNormallink() throws IOException{
		String url = "http://chiasenhac.com/mp3/beat-playback/u-instrumental/";
		Document doc;
		doc = Jsoup.connect(url).get();
        doc.setBaseUri(url);
		Elements downloadLinks = doc.select("div.playlist_prv.page-dsms a[href~=chiasenhac([a-z\\/\\.])*download\\.php]");
		System.out.println("title ".concat(doc.title()));
        System.out.println("base uri ".concat(doc.baseUri()));
        System.out.println("".concat(String.valueOf(downloadLinks.size())));

	}
	
	public void testAllowPlayListLink() throws IOException{
		String url = "http://chiasenhac.com";
		Document doc;
		doc = Jsoup.connect(url).get();
		
		ChiaSeNhacCrawler crawler = new ChiaSeNhacCrawler(url);
		Elements links =  doc.select(crawler.getSelector());
		for (Element l : links ) {
            String urll =l.absUrl("href") ;
            if(crawler.isAllowToScanInside(urll))
                System.out.println(urll);
		}
	}
}
