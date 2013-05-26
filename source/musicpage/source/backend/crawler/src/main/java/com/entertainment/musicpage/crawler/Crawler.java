package com.entertainment.musicpage.crawler;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public abstract class Crawler implements Runnable{
	LinkedBlockingQueue<Document> toScanningQueue = new LinkedBlockingQueue<Document>();// this queue for crawler
	Queue<String> linksQueue = new LinkedList<String>();//this queue for scanner
    Set<String> scandedLinks = new LinkedHashSet<String>();
	private String srcLink;
	private static Logger log = Logger.getLogger(Crawler.class.getName());
	
	public Crawler(String srcLink) {
		this.srcLink = srcLink;
	}

	protected void crawl(String srcLik) {
		log.info("start crawl ".concat(srcLik));
        Elements links= null;
        String popItem = null;
        Document doc= null;
        linksQueue.add(srcLik);
            while ((popItem = linksQueue.poll()) != null) {
                try {
					doc = Jsoup.connect(popItem).get();
					toScanningQueue.add(doc);
					log.info("connect to ".concat(popItem));
				} catch (IOException e) {
					e.printStackTrace();
					log.error(" popItem ".concat(popItem));
				}
                
                
                links = doc.select(getSelector());
                for (Element link : links) {
                    String urll =getUrl(link) ;
                    if (urll.length() > 0
                            && !scandedLinks.contains(urll)
                            && isAllowToScanInside(urll)) {
                        linksQueue.add(urll);
                        
                        scandedLinks.add(urll);
                    }
                }
               
            }
	}

    public void start(){
        new Thread(this).start();
    }

	public abstract void processPageFromLink(Document p);
	
	public abstract boolean isAllowToScanInside(String link);

    public abstract String getSelector();
    
    public abstract String getUrl(Element e);

	@Override
	public void run() {
        new Thread(new WebScanner(this)).start();
        this.crawl(srcLink);
	}
}
