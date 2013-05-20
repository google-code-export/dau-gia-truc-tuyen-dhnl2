package com.entertainment.musicpage.crawler;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public abstract class Crawler implements Runnable{
	LinkedBlockingQueue<Element> toScanningQueue = new LinkedBlockingQueue<Element>();// this queue for crawler
	Queue<String> linksQueue = new LinkedList<String>();//this queue for scanner
    Set<String> scandedLinks = new LinkedHashSet<String>();
	private String srcLink;
	
	
	public Crawler(String srcLink) {
		this.srcLink = srcLink;
	}

	public void crawl(String srcLik) {
        Elements links= null;
        String popItem = null;
        Document doc= null;
        linksQueue.add(srcLik);
        try{
            while ((popItem = linksQueue.poll()) != null) {
                System.out.println("connect to "+ popItem);
                doc = Jsoup.connect(popItem).get();

                links = doc.select(getSelector());
                for (Element link : links) {
                    String urll =link.absUrl("href") ;
                    if (urll.length() > 0
                            && !scandedLinks.contains(urll)
                            && isAllowToScanInside(urll)) {
                        linksQueue.add(urll);
                        toScanningQueue.add(link);
                        scandedLinks.add(urll);
                    }
                }
            }
            doc = Jsoup.connect(srcLik).get();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("popItem "+ popItem);
        }
	}

    public void start(){
        new Thread(this).start();
    }

	public abstract void processLink(String link);
	
	public abstract boolean isAllowToScanInside(String link);

    public abstract String getSelector();

	@Override
	public void run() {
        new Thread(new WebScanner(this)).start();
        this.crawl(srcLink);
	}
}
