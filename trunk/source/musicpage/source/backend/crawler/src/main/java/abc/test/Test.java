package abc.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.entertainment.musicpage.crawler.Crawler;

import junit.framework.TestCase;

public class Test extends TestCase {
	public void testUrlPath(){
//		String s = Crawler.class.getResource("data.txt").getPath();
		String s = Crawler.class.getResource("").getFile()+"data.txt";
		System.out.println(s);
	}
	
	public void testGetSelectorWithClass() throws IOException{
		String link = "http://chiasenhac.com/down.html";
		Document doc = Jsoup.connect(link).get();
		Elements elements = doc.select(".plt-text");
		String title = elements.get(0).html();
		System.out.println(title);
	}
	
	public void testMp3Zing() throws IOException{
		String link = "http://mp3.zing.vn/";
		Document doc = Jsoup.connect(link).get();
		System.out.println();
	}
}
