package com.entertainment.musicpage.crawler;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public abstract class Crawler implements Runnable{
	LinkedBlockingQueue<Element> toScanningQueue = new LinkedBlockingQueue<Element>();// this queue for crawler
	Queue<Element> linksQueue = new LinkedList<>();//this queue for scanner
	private String srcLink;
	
	
	public Crawler(String srcLink) {
		this.srcLink = srcLink;
	}

	public void crawl(String srcLik) throws IOException {
		Elements links;
		Element popItem;
		Document doc;
		URL host;

		doc = Jsoup.connect(srcLik).get();
	}

	public abstract void processLink(String link);
	
	public abstract boolean isAllowToScanInside(String link);
	
	@Override
	public void run() {
		
	}
}
