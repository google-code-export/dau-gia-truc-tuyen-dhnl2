package example.test;

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
//		updateSample();
	}
	
	private static void selectSample(){
		SessionFactory sessionFac = loadConfiguration().buildSessionFactory();
		Session session = sessionFac.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from DBUser where USERNAME = :username"); // table name is Class Name
		query.setParameter("username", "Fuuu1274174343");
		List list = query.list();
		
		System.out.println(String.format("list user %s", list.toString()));
		session.getTransaction().commit();
		session.close();
	}
	
	private static void insertSample(){
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
	
	private static void updateSample(){
		SessionFactory sessionFac = loadConfiguration().buildSessionFactory();
		Session session = sessionFac.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("update DBUser set username = :username1" +
				" where username = :username2");
		query.setParameter("username1", "Fuuu- updated");
		query.setParameter("username2", "Fuuu-2047702172");
		int result = query.executeUpdate();
		System.out.println(result);
		session.getTransaction().commit();
		session.close();
	}
	
	public static Configuration loadConfiguration() {
		Configuration config = new Configuration()
				.configure("hibernate.cfg.xml");
		return config;
	}
}
