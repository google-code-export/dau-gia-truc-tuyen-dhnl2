package com.entertainment.musicpage.crawler;

import java.io.IOException;
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
	LinkedBlockingQueue<String> toScanningQueue = new LinkedBlockingQueue<String>();// this queue for crawler
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
            while ((popItem = linksQueue.poll()) != null) {
                try {
					doc = Jsoup.connect(popItem).get();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("popItem ".concat(popItem));
				}
                System.out.println("connect to "+ popItem);
                links = doc.select(getSelector());
                for (Element link : links) {
                    String urll =getUrl(link) ;
                    if (urll.length() > 0
                            && !scandedLinks.contains(urll)
                            && isAllowToScanInside(urll)) {
                        linksQueue.add(urll);
                        toScanningQueue.add(urll);
                        scandedLinks.add(urll);
                    }
                }
               
            }
	}

    public void start(){
        new Thread(this).start();
    }

	public abstract void processPageFromLink(String link);
	
	public abstract boolean isAllowToScanInside(String link);

    public abstract String getSelector();
    
    public abstract String getUrl(Element e);

	@Override
	public void run() {
        new Thread(new WebScanner(this)).start();
        this.crawl(srcLink);
	}
}
