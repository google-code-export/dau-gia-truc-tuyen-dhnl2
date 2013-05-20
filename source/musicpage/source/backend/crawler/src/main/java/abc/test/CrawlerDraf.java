package abc.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.SynchronousQueue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public abstract class CrawlerDraf {

	Queue<Element> toScanningQueue = new SynchronousQueue<Element>();
	Set<String> scandedLinks = new LinkedHashSet<>();

	Thread queuPoller;

	/**
	 * this function to process every link the crawler scan through
	 * 
	 * @param link
	 */
	public abstract void process(String link);

	public abstract boolean isAllowScanIndise(String link);

	public void scan(String srclink) throws IOException {
		Document doc;
		doc = Jsoup.connect(srclink).get();
		URL host = new URL(srclink);
		Elements links = doc.select("a[href]");
		for (Element link : links) {
			if (link.attr("href").length() > 0) {
				link.attr("href", generateLink(link.attr("href"), host));
				toScanningQueue.add(link);
				scandedLinks.add(link.attr("href"));
			}

		}
		queuPoller = new Thread(new Runnable() {
			// this thread to scan deep inside link
			@Override
			public void run() {
				Elements links;
				Element popItem;
				Document doc;
				URL host;
				try {
					host = new URL("");

					while ((popItem = toScanningQueue.poll()) != null) {

						process(popItem.attr("href"));
						try {
							doc = Jsoup.connect(popItem.attr("href")).get();
							links = doc.select("a[href]");
							// get all links
							for (Element link : links) {

								if (link.attr("href").length() > 0
										&& isAllowScanIndise(link.attr("href"))) {
									link.attr(
											"href",
											generateLink(link.attr("href"),
													host));
									// toScanningQueue.push(link);
								}

							}
						} catch (IOException e) {
							e.printStackTrace();
						}

					}
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}

	public void scan2(String srclink) throws IOException {

		// this.process(srclink);
		// doc = Jsoup.connect(srclink).get();
		// URL host = new URL(srclink);
		// Elements links = doc.select("a[href]");
		// for (Element link : links) {
		// if (link.attr("href").length() > 0) {
		// link.attr("href", generateLink(link.attr("href"), host));
		// toScanningQueue.push(link);
		// scandedLinks.add(link.attr("href"));
		// }
		//
		// }
		// Element popItem;
		//
		// while ((popItem = toScanningQueue.poll()) != null) {
		//
		// this.process(popItem.attr("href"));
		// doc = Jsoup.connect(popItem.attr("href")).get();
		// links = doc.select("a[href]");
		// host = new URL(popItem.attr("href"));
		// // get all links
		// for (Element link : links) {
		//
		// if (link.attr("href").length() > 0
		// && isAllowScanIndise(link.attr("href"))) {
		// link.attr("href", generateLink(link.attr("href"), host));
		// toScanningQueue.push(link);
		// }
		//
		// }
		// }
	}

	public String generateLink(String src, URL host) {
		try {
			new URL(src);
			return src;
		} catch (MalformedURLException e) {
			return host.getProtocol().concat("://")
					+ host.getHost().concat("/").concat(src);
		}
	}

}
