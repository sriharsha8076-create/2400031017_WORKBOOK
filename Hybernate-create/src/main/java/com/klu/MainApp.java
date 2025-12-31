package com.klu;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class MainApp {

	public static void main(String[] args) {
		//load configuration & create session factory
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		//open session
		Session session = factory.openSession();
		//begin
		Transaction tx = session.beginTransaction();
		//create object
		Student s=new Student("Harsha");
		//save object
		session.save(s);
		tx.commit();
		//close the resources
		session.close();
		factory.close();
			
		System.out.println("Data have been inserted");
			
	}

}
