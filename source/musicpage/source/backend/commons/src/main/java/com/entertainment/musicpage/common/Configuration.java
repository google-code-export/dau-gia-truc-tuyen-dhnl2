package com.entertainment.musicpage.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	private static Properties properties;
	private static org.hibernate.cfg.Configuration config;

	public static Properties getProperties() {
		if (properties == null) {
			properties = new Properties();
			try {
				properties.load(Configuration.class
						.getResourceAsStream("configuration.properties"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return properties;
	}

	public static org.hibernate.cfg.Configuration loadHBConfiguration() {
		if (config == null)
			config = new org.hibernate.cfg.Configuration()
					.configure("hibernate.cfg.xml");
		return config;
	}
}
