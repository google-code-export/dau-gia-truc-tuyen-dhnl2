package com.entertainment.musicpage.crawler.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.entertainment.musicpage.crawlerimplement.ChiaSeNhacCrawler;
import com.entertainment.musicpage.daoimplement.CustomAlbumSongDAO;
import com.entertainment.musicpage.daoimplement.CustomAlbumSongDAOImpl;

import junit.framework.TestCase;

public class CrawlerTest extends TestCase {

    public void testGetSongsOfPlaylist() throws IOException{
		String url = "http://playlist.chiasenhac.com/nhac-hot-2/lang-tham-yeu~miu-le~1031185.html";
		Document doc;
		doc = Jsoup.connect(url).get();
        doc.setBaseUri(url);
		Elements downloadLinks = doc.select("div.playlist_prv.page-dsms a[href~=chiasenhac([a-z\\/\\.])*download\\.php]");
		String albumName = doc.title().split("~")[0];
		System.out.println("title ".concat(albumName));
		//System.out.println("base uri ".concat(doc.select("link[rel=canonical]").get(0).absUrl("href")));
        //this tip above just work only playlist link
        System.out.println("base uri ".concat(doc.baseUri()));

		for (Element l : downloadLinks  ) {
			System.out.println(l.absUrl("href") + " - " + l.attr("title").split("Download ")[1]);
		}	
		
	}

    public void testNormallink() throws IOException{
		String url = "http://playlist.chiasenhac.com/nhac-hot-2/kiss-the-rain~yiruma~1015078.html";
		Document doc;
		doc = Jsoup.connect(url).get();
        doc.setBaseUri(url);
		Elements downloadLinks = doc.select("a[href~=chiasenhac([a-z\\/\\.])*download\\.php]");
		System.out.println("title ".concat(doc.title()));
        System.out.println("base uri ".concat(doc.baseUri()));
        System.out.println("".concat(String.valueOf(downloadLinks.size())));
        for (Element l : downloadLinks  ) {
			System.out.println(l.absUrl("href") + " - " + l.attr("title").split("Download ")[1]);
		}	
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
	
	/**
	 * this goal of this test to make sure get correct title of song if the link crawled is one song link
	 * @throws IOException 
	 */
	public void testASongLink() throws IOException{
		String url = "http://chiasenhac.com/mp3/us-uk/u-rap-hiphop/that-power~william-justin-bieber~1083964.html";
		Document doc;
		doc = Jsoup.connect(url).get();
        doc.setBaseUri(url);
		Elements downloadLinks = doc.select("a[href~=chiasenhac([a-z\\/\\.])*download\\.php]");
		System.out.println("title ".concat(doc.title()));
        System.out.println("base uri ".concat(doc.baseUri()));
        System.out.println("".concat(String.valueOf(downloadLinks.size())));
        for (Element l : downloadLinks  ) {
			try {
				System.out.println(l.absUrl("href") + " - " + l.attr("title").split("[dD]ownload ")[1]);
			} catch (Exception e) {
				System.out.println(l.toString());
			}
		}	
	}
	
	public void testCookiesJsoup() throws IOException{
		 Document doc= null;
		 Map<String, String>cookies = new HashMap<String, String>();
		 Connection conn = Jsoup.connect("http://chiasenhac.com");
		 cookies = conn.execute().cookies();
		 doc = conn.get();
		 System.out.println(cookies);
		 System.out.println(doc.select("a").size());
	}
	
	
}
