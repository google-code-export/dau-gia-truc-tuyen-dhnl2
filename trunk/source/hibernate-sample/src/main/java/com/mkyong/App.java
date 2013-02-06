package com.mkyong;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
//		insertSample();
		selectSample();
	}
	
	private static void selectSample(){
		SessionFactory sessionFac = loadConfiguration().buildSessionFactory();
		Session session = sessionFac.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from DBUser "); // table name is Class Name
		List list = query.list();
		System.out.println(String.format("list user %s", list.toString()));
		session.getTransaction().commit();
		session.close();
	}
	
	private static void insertSample(){
		SimpleDateFormat spdfm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DBUser u = new DBUser();
		u.setUsername("Fuuu"+ new Random().nextInt());
		u.setCreatedBy("ll");
		u.setCreatedDate(new Date());
		
		SessionFactory sessionFac = loadConfiguration().buildSessionFactory();
		Session session = sessionFac.openSession();
		session.beginTransaction();
		
		session.save(u);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public static Configuration loadConfiguration() {
		Configuration config = new Configuration()
				.configure("hibernate.cfg.xml");
		return config;
	}
}
