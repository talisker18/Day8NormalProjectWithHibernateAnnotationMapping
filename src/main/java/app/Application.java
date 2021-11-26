package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import models.Address;
import models.Employee;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		
		Session session = factory.openSession();
		
		Transaction tran = session.beginTransaction();
		
		Address add = new Address();
		add.setStreet("wilerstrasse 387");
		add.setCity("bärschwil");
		add.setCountry("CH");
		
		Employee emp = new Employee();
		emp.setName("Anita Henz");
		emp.setEmail("anita@gmx.ch");
		emp.setAddress(add);
		
		session.persist(emp); //or save
		tran.commit();
		
		System.out.println("success creating employee");
		factory.close();
		session.close();

	}

}
