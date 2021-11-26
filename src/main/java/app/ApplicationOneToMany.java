package app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import models.Address;
import models.Answer;
import models.Employee;
import models.Question;

public class ApplicationOneToMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg_demo_onetomany.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		
		Session session = factory.openSession();
		
		Transaction tran = session.beginTransaction();
		
		Answer ans1 = new Answer();
		ans1.setAnswer("Answer1");
		ans1.setPostedBy("Joel");
		
		Answer ans2 = new Answer();
		ans2.setAnswer("Answer2");
		ans2.setPostedBy("Anita");
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(ans1);
		list.add(ans2);
		
		Question q1 = new Question();
		q1.setQuestion("question1???");
		q1.setAnswers(list);
		
		session.persist(q1); //or save
		tran.commit();
		
		System.out.println("success creating question");
		factory.close();
		session.close();

	}

}
