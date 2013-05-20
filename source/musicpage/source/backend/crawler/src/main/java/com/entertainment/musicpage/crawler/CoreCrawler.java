package com.entertainment.musicpage.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CoreCrawler {
	public static void main(String[] args) {
		Document doc;
		try {
			/**
			 * refer selector
			 * http://jsoup.org/apidocs/org/jsoup/select/Selector.html
			 */
			// need http protocol
			doc = Jsoup.connect("http://playlist.chiasenhac.com/nhac-hot-2/ket-thuc-hay-buong-tay~kuppj-uriboo~76772.html").get();

			// get page title
			String title = doc.title();
			System.out.println("title : " + title);

			// get all links
			Elements links = doc.select("a[href]");
			for (Element link : links) {

				if(link.attr("href").contains("download.php")){

					// get the value from href attribute
					System.out.println("\nlink : " + link.attr("href"));
					System.out.println("text : " + link.text());
					System.out.println("title : " + link.attr("title"));
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
