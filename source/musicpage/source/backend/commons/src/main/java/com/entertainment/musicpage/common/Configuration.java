package com.entertainment.musicpage.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Configuration {
	private static Properties properties ;

	public static Properties getProperties() {
		if(properties==null){
			properties = new Properties();
			try {
				properties.load(Configuration.class.getResourceAsStream("configuration.properties"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return properties;
	}
	
	
}
