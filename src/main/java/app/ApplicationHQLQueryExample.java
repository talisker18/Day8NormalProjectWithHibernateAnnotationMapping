package app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import models.Emp;

public class ApplicationHQLQueryExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg_hql_demo.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		
		Session session = factory.openSession();
		
		Transaction tran = session.beginTransaction();
		
		/*HQl queries*/
		
		Query<Emp> query = session.createQuery("from Emp");
		/*setting some offset*/
		//query.setFirstResult(2);
		//query.setMaxResults(5);
		List <Emp> emps = query.list();
		System.out.println(emps);
		
		//delete
		/*Query<Emp> query2 = session.createQuery("delete from Emp where id = 1");
		int status = query2.executeUpdate();*/
		
		//update
		/*Query<Emp> query2 = session.createQuery("update Emp set name= :name where id = :id");
		 * query.setParameter("name", "Joel2");
		 * query.setParameter("id", 2);
		int status = query2.executeUpdate();*/
		
		Emp emp = new Emp();
		emp.setName("Anita Henz");
		emp.setEmail("anita@gmx.ch");
		session.persist(emp); //or save
		
		tran.commit();
		
		System.out.println("success creating employee");
		factory.close();
		session.close();

	}

}
